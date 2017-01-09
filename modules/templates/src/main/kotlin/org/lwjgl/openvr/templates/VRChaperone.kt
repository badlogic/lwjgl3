/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRChaperone = "VRChaperone".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRChaperone_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	ChaperoneCalibrationState(
		"GetCalibrationState",
		""
	)

	bool(
		"GetPlayAreaSize",
		"",

		Check(1)..float_p.OUT("pSizeX", ""),
		Check(1)..float_p.OUT("pSizeZ", "")
	)

	bool(
		"GetPlayAreaRect",
		"",

		HmdQuad_t.p.OUT("rect", "")
	)

	void(
		"ReloadInfo",
		""
	)

	void(
		"SetSceneColor",
		"",

		HmdColor_t.IN("color", "")
	)

	void(
		"GetBoundsColor",
		"",

		HmdColor_t.p.OUT("pOutputColorArray", ""),
		AutoSize("pOutputColorArray")..int.IN("nNumOutputColors", ""),
		float.IN("flCollisionBoundsFadeDistance", ""),
		HmdColor_t.p.OUT("pOutputCameraColor", "")
	)

	bool(
		"AreBoundsVisible",
		""
	)

	void(
		"ForceBoundsVisible",
		"",

		bool.IN("bForce", "")
	)
}