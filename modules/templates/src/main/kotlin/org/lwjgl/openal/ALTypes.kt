/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openal

import org.lwjgl.generator.*

val OPENAL_PACKAGE = "org.lwjgl.openal"

fun config() {
	packageInfo(
		OPENAL_PACKAGE,
		"""
		Contains bindings to the <a href="http://www.openal.org/">OpenAL</a> cross-platform 3D audio API.

        LWJGL comes with a software OpenAL implementation, <a href="http://www.openal-soft.org/">OpenAL Soft</a>.

        OpenAL Soft can be dynamically configured with <a href="https://github.com/kcat/openal-soft/blob/master/docs/env-vars.txt">environment variables</a>. A
        very useful option for debugging is {@code ALSOFT_LOGLEVEL}; it can be set to values 0 through 4, with higher values producing more information.

        In addition to standard OpenAL features, OpenAL Soft supports <a href="https://en.wikipedia.org/wiki/Head-related_transfer_function">HRTF</a>,
        <a href="https://en.wikipedia.org/wiki/Ambisonics">Ambisonics</a> and <a href="http://www.codemasters.com/research/3D_sound_for_3D_games.pdf">3D7.1</a>.
		Documentation for these features is available in the OpenAL Soft <a href="https://github.com/kcat/openal-soft/tree/master/docs">repository</a>.
		"""
	)
}

// void

val ALvoid = NativeType("ALvoid", TypeMapping.VOID)
val ALvoid_p = PointerType("ALvoid", PointerMapping.DATA)

// numeric

val ALboolean = IntegerType("ALboolean", PrimitiveMapping.BOOLEAN)
val ALint = IntegerType("ALint", PrimitiveMapping.INT)
val ALuint = IntegerType("ALuint", PrimitiveMapping.INT, unsigned = true)
val ALfloat = PrimitiveType("ALfloat", PrimitiveMapping.FLOAT)
val ALdouble = PrimitiveType("ALdouble", PrimitiveMapping.DOUBLE)

val ALboolean_p = ALboolean.p
val ALint_p = ALint.p
val ALuint_p = ALuint.p
val ALfloat_p = ALfloat.p
val ALdouble_p = ALdouble.p

val ALint64SOFT = IntegerType("ALint64SOFT", PrimitiveMapping.LONG)
val ALint64SOFT_p = ALint64SOFT.p

// custom numeric

val ALsizei = IntegerType("ALsizei", PrimitiveMapping.INT)
val ALenum = IntegerType("ALenum", PrimitiveMapping.INT)

// strings

val ALcharASCII_p = CharSequenceType(name = "ALchar", charMapping = CharMapping.ASCII)
val ALcharUTF8_p = CharSequenceType(name = "ALchar", charMapping = CharMapping.UTF8)

val ALvoidptr = "void".p // see alGetProcAddress