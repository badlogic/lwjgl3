/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRRenderModels = "VRRenderModels".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRRenderModels_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	EVRRenderModelError(
		"LoadRenderModel_Async",
		"",

		const..charASCII_p.IN("pchRenderModelName", ""),
		Check(1)..RenderModel_t.p.p.OUT("ppRenderModel", "")
	)

	void(
		"FreeRenderModel",
		"",

		RenderModel_t.p.IN("pRenderModel", "")
	)

	EVRRenderModelError(
		"LoadTexture_Async",
		"",

		TextureID_t.IN("textureId", ""),
		Check(1)..RenderModel_TextureMap_t.p.p.OUT("ppTexture", "")
	)

	void(
		"FreeTexture",
		"",

		RenderModel_TextureMap_t.p.IN("pTexture", "")
	)

	EVRRenderModelError(
		"LoadTextureD3D11_Async",
		"",

		TextureID_t.IN("textureId", ""),
		voidptr.IN("pD3D11Device", ""),
		Check(1)..void_pp.OUT("ppD3D11Texture2D", "")
	)

	EVRRenderModelError(
		"LoadIntoTextureD3D11_Async",
		"",

		TextureID_t.IN("textureId", ""),
		voidptr.IN("pDstTexture", "")
	)

	void(
		"FreeTextureD3D11",
		"",

		voidptr.IN("pD3D11Texture2D", "")
	)

	uint32_t(
		"GetRenderModelName",
		"",

		uint32_t.IN("unRenderModelIndex", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchRenderModelName", ""),
		AutoSize("pchRenderModelName")..uint32_t.IN("unRenderModelNameLen", "")
	)

	uint32_t(
		"GetRenderModelCount",
		""
	)

	uint32_t(
		"GetComponentCount",
		"",

		const..charASCII_p.IN("pchRenderModelName", "")
	)

	uint32_t(
		"GetComponentName",
		"",

		const..charASCII_p.IN("pchRenderModelName", ""),
		uint32_t.IN("unComponentIndex", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchComponentName", ""),
		AutoSize("pchComponentName")..uint32_t.IN("unComponentNameLen", "")
	)

	uint64_t(
		"GetComponentButtonMask",
		"",

		const..charASCII_p.IN("pchRenderModelName", ""),
		const..charASCII_p.IN("pchComponentName", "")
	)

	uint32_t(
		"GetComponentRenderModelName",
		"",

		const..charASCII_p.IN("pchRenderModelName", ""),
		const..charASCII_p.IN("pchComponentName", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchComponentRenderModelName", ""),
		AutoSize("pchComponentRenderModelName")..uint32_t.IN("unComponentRenderModelNameLen", "")
	)

	bool(
		"GetComponentState",
		"",

		const..charASCII_p.IN("pchRenderModelName", ""),
		const..charASCII_p.IN("pchComponentName", ""),
		const..VRControllerState_t.p.IN("pControllerState", ""),
		const..RenderModel_ControllerMode_State_t.p.IN("pState", ""),
		RenderModel_ComponentState_t.p.OUT("pComponentState", "")
	)

	bool(
		"RenderModelHasComponent",
		"",

		const..charASCII_p.IN("pchRenderModelName", ""),
		const..charASCII_p.IN("pchComponentName", "")
	)

	uint32_t(
		"GetRenderModelThumbnailURL",
		"",

		const..charASCII_p.IN("pchRenderModelName", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchThumbnailURL", ""),
		AutoSize("pchThumbnailURL")..uint32_t.IN("unThumbnailURLLen", ""),
		Check(1)..EVRRenderModelError.p.OUT("peError", "")
	)

	uint32_t(
		"GetRenderModelOriginalPath",
		"",

		const..charASCII_p.IN("pchRenderModelName", ""),
		Return(RESULT, includesNT = true)..nullable..charASCII_p.OUT("pchOriginalPath", ""),
		AutoSize("pchOriginalPath")..uint32_t.IN("unOriginalPathLen", ""),
		Check(1)..EVRRenderModelError.p.OUT("peError", "")
	)

	const..charASCII_p(
		"GetRenderModelErrorNameFromEnum",
		"",

		EVRRenderModelError.IN("error", "")
	)
}