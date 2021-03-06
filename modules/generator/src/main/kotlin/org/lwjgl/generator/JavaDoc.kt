/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.generator

import java.lang.Math.*

private val REDUNDANT_WHITESPACE = "^[ \\t]+$".toRegex(RegexOption.MULTILINE)
private val BLOCK_NODE = "(?:div|h[1-6]|pre|table|thead|tfoot|tbody|td|tr|ul|li|ol|dl|dt|dd)" // TODO: add more here if necessary
private val FRAGMENT = "(</?$BLOCK_NODE(?:\\s[^>]+)?>|^)([\\s\\S]*?)(?=</?$BLOCK_NODE(?:\\s[^>]+)?>|$)".toRegex()
private val CHILD_NODE = "<(?:tr|thead|tfoot|tbody|li|dt|dd)>".toRegex()
private val PARAGRAPH_PATTERN = "\\n\\n(?:\\n?[ \\t]*[\\S][^\\n]*)+".toRegex(RegexOption.MULTILINE)
private val CLEANUP_PATTERN = "^[ \t]++(?![*])".toRegex(RegexOption.MULTILINE)
private val UNESCAPE_PATTERN = "\uFFFF".toRegex()

/*
Here we perform the following transformation:

<block>                 <block>
text                    text

text            =>      <p>text</p>

text                    <p>text</p>

	<div>                   <div>
	text                    text

	text                    <p>text</p>
	</div>                  </div>

text                    <p>text</p>
</block>                </block>

The first text sub-block is not wrapped in <p> because:
	a) It is not strictly necessary, renders fine in browsers and IDEs.
	b) It improves readability of the source javadoc.

For the purposes of this transformation, the javadoc root is an implicit block.
 */
private fun String.cleanup(linePrefix: String = "\t * "): String {
	val dom = trim().replace(REDUNDANT_WHITESPACE, "")
	return StringBuilder(dom.length).layoutDOM(dom, linePrefix)
		.replace(CLEANUP_PATTERN, linePrefix)
		.replace(UNESCAPE_PATTERN, "")
}

private fun StringBuilder.layoutDOM(dom: String, linePrefix: String): StringBuilder {
	FRAGMENT.findAll(dom).forEach { match ->
		val (tag, text) = match.destructured

		if (tag.isNotEmpty()) {
			if (startNewLine(dom, match.range.start)) {
				if (!tag.startsWith("</") && !tag.matches(CHILD_NODE)) {
					append('\n')
					append(linePrefix)
				}
				append('\n')
				append(linePrefix)
			}
			append(tag)
		}

		text.trim().let {
			if (it.isNotEmpty())
				layoutText(it, linePrefix, forceParagraph = tag.isNotEmpty() && tag.startsWith("</"))
		}
	}

	return this
}

private fun startNewLine(dom: String, index: Int): Boolean {
	if (index == 0)
		return false

	for (i in (index - 1) downTo 0) {
		if (dom[i] == '\n')
			return true

		if (!dom[i].isWhitespace())
			break
	}

	return false
}

private fun StringBuilder.layoutText(text: String, linePrefix: String, forceParagraph: Boolean = false) {
	var to: Int = -1

	PARAGRAPH_PATTERN.findAll(text).forEach { match ->
		val from = match.range.start
		if (to == -1 && from > 0)
			appendParagraphFirst(linePrefix, text, from, forceParagraph)

		to = match.range.endInclusive + 1
		appendParagraph(linePrefix, text, from, to)
	}

	if (to == -1)
		appendParagraphFirst(linePrefix, text, text.length, forceParagraph)
	else if (to < text.length)
		appendParagraph(linePrefix, text, to, text.length)
}

private fun StringBuilder.appendParagraphFirst(linePrefix: String, text: String, end: Int, forceParagraph: Boolean = false) {
	if (forceParagraph)
		appendParagraph(linePrefix, text, 0, end)
	else
		append(text, 0, end)
}

private fun StringBuilder.appendParagraph(linePrefix: String, text: String, start: Int, end: Int) {
	append('\n')
	append(linePrefix)
	append('\n')
	append(linePrefix)

	append("<p>")
	append(text.substring(start, end).trim())
	append("</p>")
}

fun String.toJavaDoc(indentation: String = "\t", allowSingleLine: Boolean = true): String {
	val clean = cleanup("$indentation * ")

	return if (allowSingleLine && clean.indexOf('\n') == -1)
		"$indentation/** $clean */"
	else
		"$indentation/**\n$indentation * $clean\n$indentation */"
}

/** Specialized conversion for methods. */
internal fun GeneratorTarget.toJavaDoc(documentation: String, params: Sequence<Parameter>, returns: NativeType, returnDoc: String, since: String): String {
	if (documentation.isEmpty() && returnDoc.isEmpty() && since.isEmpty() && params.all { it.documentation == null })
		return ""

	if (params.none() && returnDoc.isEmpty())
		return documentation.toJavaDoc()

	return StringBuilder("\t/**\n\t * ${documentation.cleanup()}").run {
		val returnsStructValue = !returnDoc.isEmpty() && returns is StructType

		if (params.any()) {
			// Find maximum param name length
			var alignment = params.map { it.name.length }.fold(0) { left, right -> Math.max(left, right) }
			if (returnsStructValue)
				alignment = Math.max(alignment, RESULT.length)

			val multilineAligment = paramMultilineAligment(alignment)

			append("\n\t *")
			params.forEach {
				printParam(this, it.name, it.documentation.let { if (it == null) "" else processDocumentation(it()) }, alignment, multilineAligment)
			}
			if (returnsStructValue)
				printParam(this, RESULT, processDocumentation(returnDoc), alignment, multilineAligment)
		}

		if (!returnDoc.isEmpty() && !returnsStructValue) {
			append("\n\t *")
			append("\n\t * @return ")
			append(processDocumentation(returnDoc).cleanup("\t *         "))
		}

		if (!since.isEmpty()) {
			append("\n\t *")
			append("\n\t * @since ")
			append(since)
		}

		append("\n\t */")

		toString()
	}
}

// Used for aligning parameter javadoc when it spans multiple lines.
private fun paramMultilineAligment(alignment: Int): String {
	val whitespace = " @param ".length + alignment + 1
	return StringBuilder("\t *".length + whitespace).run {
		append("\t *")
		for (i in 0..whitespace - 1)
			append(' ')

		toString()
	}
}

private fun printParam(builder: StringBuilder, name: String, documentation: String, alignment: Int, multilineAligment: String) {
	builder.append("\n\t * @param $name")

	// Align
	for (i in 0..(alignment - name.length))
		builder.append(' ')

	builder.append(documentation.cleanup(multilineAligment))
}

enum class LinkMode {
	SINGLE {
		override fun print(multi: Boolean): String = if (multi) "One of:" else "Must be:"
	},
	SINGLE_CNT {
		override fun print(multi: Boolean): String = if (multi) "one of:" else "must be:"
	},
	BITFIELD {
		override fun print(multi: Boolean): String = "One or more of:"
	},
	BITFIELD_CNT {
		override fun print(multi: Boolean): String = "one or more of:"
	};

	companion object {
		private val WHITESPACE = "\\s+".toRegex()
	}

	protected abstract fun print(multi: Boolean): String

	internal fun appendLinks(documentation: String, links: String): String {
		val trimmed = documentation.trim()
		val builder = StringBuilder(trimmed.length + 16 + links.length) // Rough estimate to reduce mallocs. TODO: validate

		val effectiveLinkMode: LinkMode
		if (trimmed.isEmpty()) {
			effectiveLinkMode = when (this) {
				SINGLE   -> SINGLE_CNT
				BITFIELD -> BITFIELD_CNT
				else     -> this
			}
		} else {
			effectiveLinkMode = this
			builder.append(trimmed)
			if (this == SINGLE || this == BITFIELD) {
				if (!trimmed.endsWith('.'))
					builder.append('.')
			}
			builder.append(' ')
		}

		builder.append(effectiveLinkMode.print(links.any { Character.isWhitespace(it) }))
		builder.append("<br><table><tr>")

		val theLinks = WHITESPACE.split(links.trim()).asSequence()
		val columns = theLinks
			.map { it.length - it.indexOf('#') - 1 }
			.average()
			.let { max(1, 80 / round(it).toInt()) }

		theLinks.forEachIndexed { i, link ->
			if (i > 0 && i % columns == 0)
				builder.append("</tr><tr>")

			builder
				.append("<td>")
				.append(link)
				.append("</td>")
		}
		builder.append("</tr></table>")

		return builder.toString()
	}
}

// DSL extensions

/** Useful for simple expressions. */
fun code(code: String) = """<code>$code</code>"""

private val CODE_BLOCK_TRIM_PATTERN = """^\s*\n|\n\s*$""".toRegex() // first and/or last empty lines...
private val CODE_BLOCK_ESCAPE_PATTERN = "^[ \t\n]".toRegex(RegexOption.MULTILINE) // leading space/tab in line, empty line
private val CODE_BLOCK_TAB_PATTERN = "\t".toRegex() // tabs

/** Useful for pre-formatted code blocks. */
fun codeBlock(code: String) = """<pre><code>${code
	.replace(CODE_BLOCK_TRIM_PATTERN, "") // ...trim
	.replace(CODE_BLOCK_ESCAPE_PATTERN, "\uFFFF$0") // ...escape
	.replace(CODE_BLOCK_TAB_PATTERN, "    ") // ...replace with 4 spaces for consistent formatting.
}</code></pre>"""

fun note(content: String) = "<div style=\"margin-left: 26px; border-left: 1px solid gray; padding-left: 14px;\"><h5>Note</h5>\n$content</div>"

fun url(href: String, innerHTML: String) = """<a href="$href">$innerHTML</a>"""

fun table(vararg rows: String, matrix: Boolean = false) = StringBuilder(512).run {
	append("<table class=${if (matrix) "\"lwjgl matrix\"" else "lwjgl"}>")
	for (row in rows) {
		append("\n\t")
		append(row)
	}
	append("\n\t</table>")

	toString()
}

fun tr(vararg columns: String) = StringBuilder().run {
	append("<tr>")
	for (column in columns)
		append(column)
	append("</tr>")

	toString()
}

fun th(content: String = "", colspan: Int = 1, rowspan: Int = 1) = td(content, colspan, rowspan, "th")
fun td(content: String = "", colspan: Int = 1, rowspan: Int = 1, tag: String = "td", className: String? = null) = StringBuilder().run {
	append("<$tag")
	if (1 < colspan)
		append(" colspan=$colspan")
	if (1 < rowspan)
		append(" rowspan=$rowspan")
	if (className != null)
		append(" class=\"$className\"")
	append(">")
	append(content.trim())
	append("</$tag>")

	toString()
}

private fun htmlList(tag: String, attributes: String, vararg items: String) = StringBuilder(512).run {
	append("<$tag")
	if (attributes.isNotEmpty())
		append(" $attributes")
	append(">")
	for (li in items) {
		append("\n\t<li>")
		append(li.trim())
		append("</li>")
	}
	append("\n\t</$tag>")

	toString()
}

fun ul(vararg items: String) = htmlList("ul", "", *items)
fun ol(vararg items: String, marker: Char = '1') = htmlList("ol", if (marker == '1') "" else "type=$marker", *items)