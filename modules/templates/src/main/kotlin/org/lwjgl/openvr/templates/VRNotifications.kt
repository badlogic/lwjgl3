/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VRNotifications = "VRNotifications".nativeClass(
	packageName = OPENVR_PACKAGE,
	prefixMethod = "VRNotifications_",
	library = OPENVR_LIBRARY,
	binding = OPENVR_FNTABLE_BINDING
) {
	documentation =
		"""
		"""

	EVRNotificationError(
		"CreateNotification",
		"",

		VROverlayHandle_t.IN("ulOverlayHandle", ""),
		uint64_t.IN("ulUserValue", ""),
		EVRNotificationType.IN("type", ""),
		const..charASCII_p.IN("pchText", ""),
		EVRNotificationStyle.IN("style", ""),
		const..NotificationBitmap_t.p.IN("pImage", ""),
		Check(1)..VRNotificationId.p.OUT("pNotificationId", "")
	)

	EVRNotificationError(
		"RemoveNotification",
		"",

		VRNotificationId.IN("notificationId", "")
	)
}