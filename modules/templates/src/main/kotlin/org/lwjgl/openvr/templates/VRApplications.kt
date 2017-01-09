/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRApplications = "VRApplications".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRApplications_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	EVRApplicationError(
		"AddApplicationManifest",
		"",

		const..charASCII_p.IN("pchApplicationManifestFullPath", ""),
		bool.IN("bTemporary", "")
	)

	EVRApplicationError(
		"RemoveApplicationManifest",
		"",

		const..charASCII_p.IN("pchApplicationManifestFullPath", "")
	)

	bool(
		"IsApplicationInstalled",
		"",

		const..charASCII_p.IN("pchAppKey", "")
	)

	uint32_t(
		"GetApplicationCount",
		""
	)

	EVRApplicationError(
		"GetApplicationKeyByIndex",
		"",

		uint32_t.IN("unApplicationIndex", ""),
		char_p.OUT("pchAppKeyBuffer", ""),
		AutoSize("pchAppKeyBuffer")..uint32_t.IN("unAppKeyBufferLen", "")
	)

	EVRApplicationError(
		"GetApplicationKeyByProcessId",
		"",

		uint32_t.IN("unProcessId", ""),
		char_p.OUT("pchAppKeyBuffer", ""),
		AutoSize("pchAppKeyBuffer")..uint32_t.IN("unAppKeyBufferLen", "")
	)

	EVRApplicationError(
		"LaunchApplication",
		"",

		const..charASCII_p.IN("pchAppKey", "")
	)

	EVRApplicationError(
		"LaunchApplicationFromMimeType",
		"",

		const..charASCII_p.IN("pchMimeType", ""),
		const..charASCII_p.IN("pchArgs", "")
	)

	EVRApplicationError(
		"LaunchDashboardOverlay",
		"",

		const..charASCII_p.IN("pchAppKey", "")
	)

	bool(
		"CancelApplicationLaunch",
		"",

		const..charASCII_p.IN("pchAppKey", "")
	)

	EVRApplicationError(
		"IdentifyApplication",
		"",

		uint32_t.IN("unProcessId", ""),
		const..charASCII_p.IN("pchAppKey", "")
	)

	uint32_t(
		"GetApplicationProcessId",
		"",

		const..charASCII_p.IN("pchAppKey", "")
	)

	const..charASCII_p(
		"GetApplicationsErrorNameFromEnum",
		"",

		EVRApplicationError.IN("error", "")
	)

	uint32_t(
		"GetApplicationPropertyString",
		"",

		const..charASCII_p.IN("pchAppKey", ""),
		EVRApplicationProperty.IN("eProperty", ""),
		Return(RESULT, "VR.k_unMaxPropertyStringSize", includesNT = true)..nullable..charASCII_p.OUT("pchPropertyValueBuffer", ""),
		AutoSize("pchPropertyValueBuffer")..uint32_t.IN("unPropertyValueBufferLen", ""),
		Check(1)..EVRApplicationError.p.OUT("peError", "")
	)

	bool(
		"GetApplicationPropertyBool",
		"",

		const..charASCII_p.IN("pchAppKey", ""),
		EVRApplicationProperty.IN("eProperty", ""),
		Check(1)..EVRApplicationError.p.OUT("peError", "")
	)

	uint64_t(
		"GetApplicationPropertyUint64",
		"",

		const..charASCII_p.IN("pchAppKey", ""),
		EVRApplicationProperty.IN("eProperty", ""),
		Check(1)..EVRApplicationError.p.OUT("peError", "")
	)

	EVRApplicationError(
		"SetApplicationAutoLaunch",
		"",

		const..charASCII_p.IN("pchAppKey", ""),
		bool.IN("bAutoLaunch", "")
	)

	bool(
		"GetApplicationAutoLaunch",
		"",

		const..charASCII_p.IN("pchAppKey", "")
	)

	EVRApplicationError(
		"SetDefaultApplicationForMimeType",
		"",

		const..charASCII_p.IN("pchAppKey", ""),
		const..charASCII_p.IN("pchMimeType", "")
	)

	bool(
		"GetDefaultApplicationForMimeType",
		"",

		const..charASCII_p.IN("pchMimeType", ""),
		char_p.OUT("pchAppKeyBuffer", ""),
		AutoSize("pchAppKeyBuffer")..uint32_t.IN("unAppKeyBufferLen", "")
	)

	bool(
		"GetApplicationSupportedMimeTypes",
		"",

		const..charASCII_p.IN("pchAppKey", ""),
		nullable..char_p.OUT("pchMimeTypesBuffer", ""),
		AutoSize("pchMimeTypesBuffer")..uint32_t.IN("unMimeTypesBuffer", "")
	)

	uint32_t(
		"GetApplicationsThatSupportMimeType",
		"",

		const..charASCII_p.IN("pchMimeType", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchAppKeysThatSupportBuffer", ""),
		AutoSize("pchAppKeysThatSupportBuffer")..uint32_t.IN("unAppKeysThatSupportBuffer", "")
	)

	uint32_t(
		"GetApplicationLaunchArguments",
		"",

		uint32_t.IN("unHandle", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchArgs", ""),
		AutoSize("pchArgs")..uint32_t.IN("unArgs", "")
	)

	EVRApplicationError(
		"GetStartingApplication",
		"",

		char_p.OUT("pchAppKeyBuffer", ""),
		AutoSize("pchAppKeyBuffer")..uint32_t.IN("unAppKeyBufferLen", "")
	)

	EVRApplicationTransitionState(
		"GetTransitionState",
		""
	)

	EVRApplicationError(
		"PerformApplicationPrelaunchCheck",
		"",

		const..charASCII_p.IN("pchAppKey", "")
	)

	const..charASCII_p(
		"GetApplicationsTransitionStateNameFromEnum",
		"",

		EVRApplicationTransitionState.IN("state", "")
	)

	bool(
		"IsQuitUserPromptRequested",
		""
	)

	EVRApplicationError(
		"LaunchInternalProcess",
		"",

		const..charASCII_p.IN("pchBinaryPath", ""),
		const..charASCII_p.IN("pchArguments", ""),
		const..charASCII_p.IN("pchWorkingDirectory", "")
	)
}