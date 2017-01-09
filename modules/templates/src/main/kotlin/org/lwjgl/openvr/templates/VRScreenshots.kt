/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRScreenshots = "VRScreenshots".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRScreenshots_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	EVRScreenshotError(
		"RequestScreenshot",
		"",

		Check(1)..ScreenshotHandle_t.p.OUT("pOutScreenshotHandle", ""),
		EVRScreenshotType.IN("type", ""),
		const..charASCII_p.IN("pchPreviewFilename", ""),
		const..charASCII_p.IN("pchVRFilename", "")
	)

	EVRScreenshotError(
		"HookScreenshot",
		"",

		const..EVRScreenshotType.p.IN("pSupportedTypes", ""),
		AutoSize("pSupportedTypes")..int.IN("numTypes", "")
	)

	EVRScreenshotType(
		"GetScreenshotPropertyType",
		"",

		ScreenshotHandle_t.IN("screenshotHandle", ""),
		Check(1)..EVRScreenshotError.p.OUT("pError", "")
	)

	uint32_t(
		"GetScreenshotPropertyFilename",
		"",

		ScreenshotHandle_t.IN("screenshotHandle", ""),
		EVRScreenshotPropertyFilenames.IN("filenameType", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchFilename", ""),
		AutoSize("pchFilename")..uint32_t.IN("cchFilename", ""),
		Check(1)..EVRScreenshotError.p.OUT("pError", "")
	)

	EVRScreenshotError(
		"UpdateScreenshotProgress",
		"",

		ScreenshotHandle_t.IN("screenshotHandle", ""),
		float.IN("flProgress", "")
	)

	EVRScreenshotError(
		"TakeStereoScreenshot",
		"",

		Check(1)..ScreenshotHandle_t.p.OUT("pOutScreenshotHandle", ""),
		const..charASCII_p.IN("pchPreviewFilename", ""),
		const..charASCII_p.IN("pchVRFilename", "")
	)

	EVRScreenshotError(
		"SubmitScreenshot",
		"",

		ScreenshotHandle_t.IN("screenshotHandle", ""),
		EVRScreenshotType.IN("type", ""),
		const..charASCII_p.IN("pchSourcePreviewFilename", ""),
		const..charASCII_p.IN("pchSourceVRFilename", "")
	)
}