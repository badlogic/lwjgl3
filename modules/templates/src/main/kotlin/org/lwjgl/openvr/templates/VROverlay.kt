/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VROverlay = "VROverlay".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VROverlay_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	EVROverlayError(
		"FindOverlay",
		"",

		const..charASCII_p.IN("pchOverlayKey", ""),
		Check(1)..VROverlayHandle_t.p.OUT("pOverlayHandle", "")
	)

	EVROverlayError(
		"CreateOverlay",
		"",

		const..charASCII_p.IN("pchOverlayKey", ""),
		const..charASCII_p.IN("pchOverlayFriendlyName", ""),
		Check(1)..VROverlayHandle_t.p.OUT("pOverlayHandle", "")
	)

	EVROverlayError(
		"DestroyOverlay",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", "")
	)

	EVROverlayError(
		"SetHighQualityOverlay",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", "")
	)

	VROverlayHandle_t(
		"GetHighQualityOverlay",
		""
	)

	uint32_t(
		"GetOverlayKey",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchValue", ""),
		AutoSize("pchValue")..uint32_t.IN("unBufferSize", ""),
		Check(1)..EVROverlayError.p.OUT("pError", "")
	)

	uint32_t(
		"GetOverlayName",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchValue", ""),
		AutoSize("pchValue")..uint32_t.IN("unBufferSize", ""),
		Check(1)..EVROverlayError.p.OUT("pError", "")
	)

	EVROverlayError(
		"GetOverlayImageData",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		void_p.OUT("pvBuffer", ""),
		AutoSize("pvBuffer")..uint32_t.IN("unBufferSize", ""),
		Check(1)..uint32_t_p.OUT("punWidth", ""),
		Check(1)..uint32_t_p.OUT("punHeight", "")
	)

	const..charASCII_p(
		"GetOverlayErrorNameFromEnum",
		"",

		EVROverlayError.IN("error", "")
	)

	EVROverlayError(
		"SetOverlayRenderingPid",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		uint32_t.IN("unPID", "")
	)

	uint32_t(
		"GetOverlayRenderingPid",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", "")
	)

	EVROverlayError(
		"SetOverlayFlag",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		VROverlayFlags.IN("eOverlayFlag", ""),
		bool.IN("bEnabled", "")
	)

	EVROverlayError(
		"GetOverlayFlag",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		VROverlayFlags.IN("eOverlayFlag", ""),
		Check(1)..bool_p.OUT("pbEnabled", "")
	)

	EVROverlayError(
		"SetOverlayColor",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		float.IN("fRed", ""),
		float.IN("fGreen", ""),
		float.IN("fBlue", "")
	)

	EVROverlayError(
		"GetOverlayColor",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..float_p.OUT("pfRed", ""),
		Check(1)..float_p.OUT("pfGreen", ""),
		Check(1)..float_p.OUT("pfBlue", "")
	)

	EVROverlayError(
		"SetOverlayAlpha",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		float.IN("fAlpha", "")
	)

	EVROverlayError(
		"GetOverlayAlpha",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..float_p.OUT("pfAlpha", "")
	)

	EVROverlayError(
		"SetOverlayTexelAspect",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		float.IN("fTexelAspect", "")
	)

	EVROverlayError(
		"GetOverlayTexelAspect",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..float_p.OUT("pfTexelAspect", "")
	)

	EVROverlayError(
		"SetOverlaySortOrder",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		uint32_t.IN("unSortOrder", "")
	)

	EVROverlayError(
		"GetOverlaySortOrder",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..uint32_t_p.OUT("punSortOrder", "")
	)

	EVROverlayError(
		"SetOverlayWidthInMeters",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		float.IN("fWidthInMeters", "")
	)

	EVROverlayError(
		"GetOverlayWidthInMeters",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..float_p.OUT("pfWidthInMeters", "")
	)

	EVROverlayError(
		"SetOverlayAutoCurveDistanceRangeInMeters",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		float.IN("fMinDistanceInMeters", ""),
		float.IN("fMaxDistanceInMeters", "")
	)

	EVROverlayError(
		"GetOverlayAutoCurveDistanceRangeInMeters",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..float_p.OUT("pfMinDistanceInMeters", ""),
		Check(1)..float_p.OUT("pfMaxDistanceInMeters", "")
	)

	EVROverlayError(
		"SetOverlayTextureColorSpace",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		EColorSpace.IN("eTextureColorSpace", "")
	)

	EVROverlayError(
		"GetOverlayTextureColorSpace",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..EColorSpace.p.OUT("peTextureColorSpace", "")
	)

	EVROverlayError(
		"SetOverlayTextureBounds",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		const..VRTextureBounds_t.p.IN("pOverlayTextureBounds", "")
	)

	EVROverlayError(
		"GetOverlayTextureBounds",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		VRTextureBounds_t.p.OUT("pOverlayTextureBounds", "")
	)

	EVROverlayError(
		"GetOverlayTransformType",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..VROverlayTransformType.p.OUT("peTransformType", "")
	)

	EVROverlayError(
		"SetOverlayTransformAbsolute",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		ETrackingUniverseOrigin.IN("eTrackingOrigin", ""),
		const..HmdMatrix34_t.p.IN("pmatTrackingOriginToOverlayTransform", "")
	)

	EVROverlayError(
		"GetOverlayTransformAbsolute",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..ETrackingUniverseOrigin.p.OUT("peTrackingOrigin", ""),
		HmdMatrix34_t.p.OUT("pmatTrackingOriginToOverlayTransform", "")
	)

	EVROverlayError(
		"SetOverlayTransformTrackedDeviceRelative",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		TrackedDeviceIndex_t.IN("unTrackedDevice", ""),
		const..HmdMatrix34_t.p.IN("pmatTrackedDeviceToOverlayTransform", "")
	)

	EVROverlayError(
		"GetOverlayTransformTrackedDeviceRelative",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..TrackedDeviceIndex_t.p.OUT("punTrackedDevice", ""),
		HmdMatrix34_t.p.OUT("pmatTrackedDeviceToOverlayTransform", "")
	)

	EVROverlayError(
		"SetOverlayTransformTrackedDeviceComponent",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		TrackedDeviceIndex_t.IN("unDeviceIndex", ""),
		const..charASCII_p.IN("pchComponentName", "")
	)

	EVROverlayError(
		"GetOverlayTransformTrackedDeviceComponent",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..TrackedDeviceIndex_t.p.OUT("punDeviceIndex", ""),
		char_p.OUT("pchComponentName", ""),
		AutoSize("pchComponentName")..uint32_t.IN("unComponentNameSize", "")
	)

	EVROverlayError(
		"ShowOverlay",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", "")
	)

	EVROverlayError(
		"HideOverlay",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", "")
	)

	bool(
		"IsOverlayVisible",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", "")
	)

	EVROverlayError(
		"GetTransformForOverlayCoordinates",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		ETrackingUniverseOrigin.IN("eTrackingOrigin", ""),
		HmdVector2_t.IN("coordinatesInOverlay", ""),
		HmdMatrix34_t.p.OUT("pmatTransform", "")
	)

	bool(
		"PollNextOverlayEvent",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		VREvent_t.p.OUT("pEvent", ""),
		AutoSize("pEvent")..uint32_t.IN("uncbVREvent", "")
	)

	EVROverlayError(
		"GetOverlayInputMethod",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..VROverlayInputMethod.p.OUT("peInputMethod", "")
	)

	EVROverlayError(
		"SetOverlayInputMethod",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		VROverlayInputMethod.IN("eInputMethod", "")
	)

	EVROverlayError(
		"GetOverlayMouseScale",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		HmdVector2_t.p.OUT("pvecMouseScale", "")
	)

	EVROverlayError(
		"SetOverlayMouseScale",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		const..HmdVector2_t.p.IN("pvecMouseScale", "")
	)

	bool(
		"ComputeOverlayIntersection",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		const..VROverlayIntersectionParams_t.p.IN("pParams", ""),
		VROverlayIntersectionResults_t.p.OUT("pResults", "")
	)

	bool(
		"HandleControllerOverlayInteractionAsMouse",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		TrackedDeviceIndex_t.IN("unControllerDeviceIndex", "")
	)

	bool(
		"IsHoverTargetOverlay",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", "")
	)

	VROverlayHandle_t(
		"GetGamepadFocusOverlay",
		""
	)

	EVROverlayError(
		"SetGamepadFocusOverlay",
		"",

		VROverlayHandle_t.IN("ulNewFocusOverlay", "")
	)

	EVROverlayError(
		"SetOverlayNeighbor",
		"",

		EOverlayDirection.IN("eDirection", ""),
		VROverlayHandle_t.IN("ulFrom", ""),
		VROverlayHandle_t.IN("ulTo", "")
	)

	EVROverlayError(
		"MoveGamepadFocusToNeighbor",
		"",

		EOverlayDirection.IN("eDirection", ""),
		VROverlayHandle_t.IN("ulFrom", "")
	)

	EVROverlayError(
		"SetOverlayTexture",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		const..Texture_t.p.IN("pTexture", "")
	)

	EVROverlayError(
		"ClearOverlayTexture",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", "")
	)

	EVROverlayError(
		"SetOverlayRaw",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Unsafe..void_p.IN("pvBuffer", ""),
		uint32_t.IN("unWidth", ""),
		uint32_t.IN("unHeight", ""),
		uint32_t.IN("unDepth", "")
	)

	EVROverlayError(
		"SetOverlayFromFile",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		const..charASCII_p.IN("pchFilePath", "")
	)

	EVROverlayError(
		"GetOverlayTexture",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..void_pp.OUT("pNativeTextureHandle", ""),
		voidptr.IN("pNativeTextureRef", ""),
		Check(1)..uint32_t_p.OUT("pWidth", ""),
		Check(1)..uint32_t_p.OUT("pHeight", ""),
		Check(1)..uint32_t_p.OUT("pNativeFormat", ""),
		Check(1)..ETextureType.p.OUT("pAPIType", ""),
		Check(1)..EColorSpace.p.OUT("pColorSpace", ""),
		VRTextureBounds_t.p.OUT("pTextureBounds", "")
	)

	EVROverlayError(
		"ReleaseNativeOverlayHandle",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		voidptr.IN("pNativeTextureHandle", "")
	)

	EVROverlayError(
		"GetOverlayTexture",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..void_pp.OUT("pNativeTextureHandle", ""),
		voidptr.IN("pNativeTextureRef", ""),
		Check(1)..uint32_t_p.OUT("pWidth", ""),
		Check(1)..uint32_t_p.OUT("pHeight", ""),
		Check(1)..uint32_t_p.OUT("pNativeFormat", ""),
		Check(1)..ETextureType.p.OUT("pAPIType", ""),
		Check(1)..EColorSpace.p.OUT("pColorSpace", ""),
		VRTextureBounds_t.p.OUT("pTextureBounds", "")
	)

	EVROverlayError(
		"ReleaseNativeOverlayHandle",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		voidptr.IN("pNativeTextureHandle", "")
	)

	EVROverlayError(
		"GetOverlayTextureSize",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..uint32_t_p.OUT("pWidth", ""),
		Check(1)..uint32_t_p.OUT("pHeight", "")
	)

	EVROverlayError(
		"CreateDashboardOverlay",
		"",

		const..charASCII_p.IN("pchOverlayKey", ""),
		const..charASCII_p.IN("pchOverlayFriendlyName", ""),
		Check(1)..VROverlayHandle_t.p.OUT("pMainHandle", ""),
		Check(1)..VROverlayHandle_t.p.OUT("pThumbnailHandle", "")
	)

	bool(
		"IsDashboardVisible",
		""
	)

	bool(
		"IsActiveDashboardOverlay",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", "")
	)

	EVROverlayError(
		"SetDashboardOverlaySceneProcess",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		uint32_t.IN("unProcessId", "")
	)

	EVROverlayError(
		"GetDashboardOverlaySceneProcess",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..uint32_t_p.OUT("punProcessId", "")
	)

	void(
		"ShowDashboard",
		"",

		const..charASCII_p.IN("pchOverlayToShow", "")
	)

	TrackedDeviceIndex_t(
		"GetPrimaryDashboardDevice",
		""
	)

	EVROverlayError(
		"ShowKeyboard",
		"",

		EGamepadTextInputMode.IN("eInputMode", ""),
		EGamepadTextInputLineMode.IN("eLineInputMode", ""),
		const..charASCII_p.IN("pchDescription", ""),
		uint32_t.IN("unCharMax", ""),
		const..charASCII_p.IN("pchExistingText", ""),
		bool.IN("bUseMinimalMode", ""),
		uint64_t.IN("uUserValue", "")
	)

	EVROverlayError(
		"ShowKeyboardForOverlay",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		EGamepadTextInputMode.IN("eInputMode", ""),
		EGamepadTextInputLineMode.IN("eLineInputMode", ""),
		const..charASCII_p.IN("pchDescription", ""),
		uint32_t.IN("unCharMax", ""),
		const..charASCII_p.IN("pchExistingText", ""),
		bool.IN("bUseMinimalMode", ""),
		uint64_t.IN("uUserValue", "")
	)

	uint32_t(
		"GetKeyboardText",
		"",

		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchText", ""),
		AutoSize("pchText")..uint32_t.IN("cchText", "")
	)

	void(
		"HideKeyboard",
		""
	)

	void(
		"SetKeyboardTransformAbsolute",
		"",

		ETrackingUniverseOrigin.IN("eTrackingOrigin", ""),
		const..HmdMatrix34_t.p.IN("pmatTrackingOriginToKeyboardTransform", "")
	)

	void(
		"SetKeyboardPositionForOverlay",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		HmdRect2_t.IN("avoidRect", "")
	)

	EVROverlayError(
		"GetOverlayFlags",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		Check(1)..uint32_t_p.OUT("pFlags", "")
	)

	VRMessageOverlayResponse(
		"ShowMessageOverlay",
		"",

		const..charASCII_p.IN("pchText", ""),
		const..charASCII_p.IN("pchCaption", ""),
		const..charASCII_p.IN("pchButton0Text", ""),
		const..charASCII_p.IN("pchButton1Text", ""),
		const..charASCII_p.IN("pchButton2Text", ""),
		const..charASCII_p.IN("pchButton3Text", "")
	)
}