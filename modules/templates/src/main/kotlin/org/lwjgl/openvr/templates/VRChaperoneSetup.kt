/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRChaperoneSetup = "VRChaperoneSetup".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRChaperoneSetup_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	bool(
		"CommitWorkingCopy",
		"",

		EChaperoneConfigFile.IN("configFile", "")
	)

	void(
		"RevertWorkingCopy",
		""
	)

	bool(
		"GetWorkingPlayAreaSize",
		"",

		Check(1)..float_p.OUT("pSizeX", ""),
		Check(1)..float_p.OUT("pSizeZ", "")
	)

	bool(
		"GetWorkingPlayAreaRect",
		"",

		HmdQuad_t.p.OUT("rect", "")
	)

	bool(
		"GetWorkingSeatedZeroPoseToRawTrackingPose",
		"",

		HmdMatrix34_t.p.OUT("pmatSeatedZeroPoseToRawTrackingPose", "")
	)

	bool(
		"GetWorkingStandingZeroPoseToRawTrackingPose",
		"",

		HmdMatrix34_t.p.OUT("pmatStandingZeroPoseToRawTrackingPose", "")
	)

	void(
		"SetWorkingPlayAreaSize",
		"",

		float.IN("sizeX", ""),
		float.IN("sizeZ", "")
	)

	void(
		"SetWorkingSeatedZeroPoseToRawTrackingPose",
		"",

		const..HmdMatrix34_t.p.IN("pMatSeatedZeroPoseToRawTrackingPose", "")
	)

	void(
		"SetWorkingStandingZeroPoseToRawTrackingPose",
		"",

		const..HmdMatrix34_t.p.IN("pMatStandingZeroPoseToRawTrackingPose", "")
	)

	void(
		"ReloadFromDisk",
		"",

		EChaperoneConfigFile.IN("configFile", "")
	)

	bool(
		"GetLiveSeatedZeroPoseToRawTrackingPose",
		"",

		HmdMatrix34_t.p.OUT("pmatSeatedZeroPoseToRawTrackingPose", "")
	)

	bool(
		"ExportLiveToBuffer",
		"",

		Unsafe..char_p.OUT("pBuffer", ""),
		Check(1)..uint32_t_p.OUT("pnBufferLength", "")
	)

	bool(
		"ImportFromBufferToWorking",
		"",

		Unsafe..const..char_p.IN("pBuffer", ""),
		uint32_t.IN("nImportFlags", "")
	)
}