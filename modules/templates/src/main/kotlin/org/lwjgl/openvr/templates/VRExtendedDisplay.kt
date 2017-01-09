/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRExtendedDisplay = "VRExtendedDisplay".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRExtendedDisplay_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	void(
		"GetWindowBounds",
		"",

		Check(1)..int32_t_p.OUT("pnX", ""),
		Check(1)..int32_t_p.OUT("pnY", ""),
		Check(1)..uint32_t_p.OUT("pnWidth", ""),
		Check(1)..uint32_t_p.OUT("pnHeight", "")
	)

	void(
		"GetEyeOutputViewport",
		"",

		EVREye.IN("eEye", ""),
		Check(1)..uint32_t_p.OUT("pnX", ""),
		Check(1)..uint32_t_p.OUT("pnY", ""),
		Check(1)..uint32_t_p.OUT("pnWidth", ""),
		Check(1)..uint32_t_p.OUT("pnHeight", "")
	)

	void(
		"GetDXGIOutputInfo",
		"",

		Check(1)..int32_t_p.OUT("pnAdapterIndex", ""),
		Check(1)..int32_t_p.OUT("pnAdapterOutputIndex", "")
	)
}