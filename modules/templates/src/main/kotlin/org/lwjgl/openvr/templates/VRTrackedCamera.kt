/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRTrackedCamera = "VRTrackedCamera".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRTrackedCamera_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	const..charASCII_p(
		"GetCameraErrorNameFromEnum",
		"",

		EVRTrackedCameraError.IN("eCameraError", "")
	)

	EVRTrackedCameraError(
		"HasCamera",
		"",

		TrackedDeviceIndex_t.IN("nDeviceIndex", ""),
		Check(1)..bool_p.OUT("pHasCamera", "")
	)

	EVRTrackedCameraError(
		"GetCameraFrameSize",
		"",

		TrackedDeviceIndex_t.IN("nDeviceIndex", ""),
		EVRTrackedCameraFrameType.IN("eFrameType", ""),
		Check(1)..uint32_t_p.OUT("pnWidth", ""),
		Check(1)..uint32_t_p.OUT("pnHeight", ""),
		Check(1)..uint32_t_p.OUT("pnFrameBufferSize", "")
	)

	EVRTrackedCameraError(
		"GetCameraIntrinsics",
		"",

		TrackedDeviceIndex_t.IN("nDeviceIndex", ""),
		EVRTrackedCameraFrameType.IN("eFrameType", ""),
		Check(1)..HmdVector2_t.p.OUT("pFocalLength", ""),
		Check(1)..HmdVector2_t.p.OUT("pCenter", "")
	)

	EVRTrackedCameraError(
		"GetCameraProjection",
		"",

		TrackedDeviceIndex_t.IN("nDeviceIndex", ""),
		EVRTrackedCameraFrameType.IN("eFrameType", ""),
		float.IN("flZNear", ""),
		float.IN("flZFar", ""),
		HmdMatrix44_t.p.OUT("pProjection", "")
	)

	EVRTrackedCameraError(
		"AcquireVideoStreamingService",
		"",

		TrackedDeviceIndex_t.IN("nDeviceIndex", ""),
		Check(1)..TrackedCameraHandle_t.p.OUT("pHandle", "")
	)

	EVRTrackedCameraError(
		"ReleaseVideoStreamingService",
		"",

		TrackedCameraHandle_t.IN("hTrackedCamera", "")
	)

	EVRTrackedCameraError(
		"GetVideoStreamFrameBuffer",
		"",

		TrackedCameraHandle_t.IN("hTrackedCamera", ""),
		EVRTrackedCameraFrameType.IN("eFrameType", ""),
		void_p.OUT("pFrameBuffer", ""),
		AutoSize("pFrameBuffer")..uint32_t.IN("nFrameBufferSize", ""),
		CameraVideoStreamFrameHeader_t.p.OUT("pFrameHeader", ""),
		Expression("CameraVideoStreamFrameHeader.SIZEOF")..uint32_t.IN("nFrameHeaderSize", "")
	)

	EVRTrackedCameraError(
		"GetVideoStreamTextureSize",
		"",

		TrackedDeviceIndex_t.IN("nDeviceIndex", ""),
		EVRTrackedCameraFrameType.IN("eFrameType", ""),
		VRTextureBounds_t.p.OUT("pTextureBounds", ""),
		Check(1)..uint32_t_p.OUT("pnWidth", ""),
		Check(1)..uint32_t_p.OUT("pnHeight", "")
	)

	EVRTrackedCameraError(
		"GetVideoStreamTextureD3D11",
		"",

		TrackedCameraHandle_t.IN("hTrackedCamera", ""),
		EVRTrackedCameraFrameType.IN("eFrameType", ""),
		voidptr.IN("pD3D11DeviceOrResource", ""),
		Check(1)..void_pp.OUT("ppD3D11ShaderResourceView", ""),
		CameraVideoStreamFrameHeader_t.p.OUT("pFrameHeader", ""),
		Expression("CameraVideoStreamFrameHeader.SIZEOF")..uint32_t.IN("nFrameHeaderSize", "")
	)

	EVRTrackedCameraError(
		"GetVideoStreamTextureGL",
		"",

		TrackedCameraHandle_t.IN("hTrackedCamera", ""),
		EVRTrackedCameraFrameType.IN("eFrameType", ""),
		Check(1)..glUInt_t.p.OUT("pglTextureId", ""),
		CameraVideoStreamFrameHeader_t.p.OUT("pFrameHeader", ""),
		Expression("CameraVideoStreamFrameHeader.SIZEOF")..uint32_t.IN("nFrameHeaderSize", "")
	)

	EVRTrackedCameraError(
		"ReleaseVideoStreamTextureGL",
		"",

		TrackedCameraHandle_t.IN("hTrackedCamera", ""),
		glUInt_t.IN("glTextureId", "")
	)
}