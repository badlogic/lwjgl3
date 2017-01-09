/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRResources = "VRResources".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRResources_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	uint32_t(
		"LoadSharedResource",
		"",

		const..charASCII_p.IN("pchResourceName", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchBuffer", ""),
		AutoSize("pchBuffer")..uint32_t.IN("unBufferLen", "")
	)

	uint32_t(
		"GetResourceFullPath",
		"",

		const..charASCII_p.IN("pchResourceName", ""),
		const..charASCII_p.IN("pchResourceTypeDirectory", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchPathBuffer", ""),
		AutoSize("pchPathBuffer")..uint32_t.IN("unBufferLen", "")
	)
}