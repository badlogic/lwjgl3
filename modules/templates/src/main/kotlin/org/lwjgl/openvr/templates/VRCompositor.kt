/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRCompositor = "VRCompositor".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRCompositor_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	nativeDirective("""DISABLE_WARNINGS()
#include "openvr_capi.h"
ENABLE_WARNINGS()
#define APIENTRY OPENVR_FNTABLE_CALLTYPE""")

	documentation =
		"""
		"""

	void(
		"SetTrackingSpace",
		"",

		ETrackingUniverseOrigin.IN("eOrigin", "")
	)

	ETrackingUniverseOrigin(
		"GetTrackingSpace",
		""
	)

	EVRCompositorError(
		"GetLastPoseForTrackedDeviceIndex",
		"",

		TrackedDeviceIndex_t.IN("unDeviceIndex", ""),
		TrackedDevicePose_t.p.OUT("pOutputPose", ""),
		TrackedDevicePose_t.p.OUT("pOutputGamePose", "")
	)

	EVRCompositorError(
		"Submit",
		"",

		EVREye.IN("eEye", ""),
		const..Texture_t.p.IN("pTexture", ""),
		const..VRTextureBounds_t.p.IN("pBounds", ""),
		EVRSubmitFlags.IN("nSubmitFlags", "")
	)

	void(
		"ClearLastSubmittedFrame",
		""
	)

	void(
		"PostPresentHandoff",
		""
	)

	bool(
		"GetFrameTiming",
		"",

		Compositor_FrameTiming.p.OUT("pTiming", ""),
		uint32_t.IN("unFramesAgo", "")
	)

	uint32_t(
		"GetFrameTimings",
		"",

		Compositor_FrameTiming.p.OUT("pTiming", ""),
		uint32_t.IN("nFrames", "")
	)

	float(
		"GetFrameTimeRemaining",
		""
	)

	void(
		"GetCumulativeStats",
		"",

		Compositor_CumulativeStats.p.OUT("pStats", ""),
		Expression("CompositorCumulativeStats.SIZEOF")..uint32_t.IN("nStatsSizeInBytes", "")
	)

	void(
		"FadeToColor",
		"",

		float.IN("fSeconds", ""),
		float.IN("fRed", ""),
		float.IN("fGreen", ""),
		float.IN("fBlue", ""),
		float.IN("fAlpha", ""),
		bool.IN("bBackground", "")
	)

	HmdColor_t(
		"GetCurrentFadeColor",
		"",

		bool.IN("bBackground", "")
	)

	void(
		"FadeGrid",
		"",

		float.IN("fSeconds", ""),
		bool.IN("bFadeIn", "")
	)

	float(
		"GetCurrentGridAlpha",
		""
	)

	void(
		"ClearSkyboxOverride",
		""
	)

	void(
		"CompositorBringToFront",
		""
	)

	void(
		"CompositorGoToBack",
		""
	)

	void(
		"CompositorQuit",
		""
	)

	bool(
		"IsFullscreen",
		""
	)

	uint32_t(
		"GetCurrentSceneFocusProcess",
		""
	)

	uint32_t(
		"GetLastFrameRenderer",
		""
	)

	bool(
		"CanRenderScene",
		""
	)

	void(
		"ShowMirrorWindow",
		""
	)

	void(
		"HideMirrorWindow",
		""
	)

	bool(
		"IsMirrorWindowVisible",
		""
	)

	void(
		"CompositorDumpImages",
		""
	)

	bool(
		"ShouldAppRenderWithLowResources",
		""
	)

	void(
		"ForceInterleavedReprojectionOn",
		"",

		bool.IN("bOverride", "")
	)

	void(
		"ForceReconnectProcess",
		""
	)

	void(
		"SuspendRendering",
		"",

		bool.IN("bSuspend", "")
	)

	EVRCompositorError(
		"GetMirrorTextureD3D11",
		"",

		EVREye.IN("eEye", ""),
		voidptr.IN("pD3D11DeviceOrResource", ""),
		Check(1)..void_pp.OUT("ppD3D11ShaderResourceView", "")
	)

	EVRCompositorError(
		"GetMirrorTextureGL",
		"",

		EVREye.IN("eEye", ""),
		Check(1)..glUInt_t.p.OUT("pglTextureId", ""),
		Check(1)..glSharedTextureHandle_t.p.OUT("pglSharedTextureHandle", "")
	)

	bool(
		"ReleaseSharedGLTexture",
		"",

		glUInt_t.IN("glTextureId", ""),
		glSharedTextureHandle_t.IN("glSharedTextureHandle", "")
	)

	void(
		"LockGLSharedTextureForAccess",
		"",

		glSharedTextureHandle_t.IN("glSharedTextureHandle", "")
	)

	void(
		"UnlockGLSharedTextureForAccess",
		"",

		glSharedTextureHandle_t.IN("glSharedTextureHandle", "")
	)

	uint32_t(
		"GetVulkanInstanceExtensionsRequired",
		"",

		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchValue", ""),
		AutoSize("pchValue")..uint32_t.IN("unBufferSize", "")
	)

	uint32_t(
		"GetVulkanDeviceExtensionsRequired",
		"",

		VkPhysicalDevice_T.IN("pPhysicalDevice", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchValue", ""),
		AutoSize("pchValue")..uint32_t.IN("unBufferSize", "")
	)
}