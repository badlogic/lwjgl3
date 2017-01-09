/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.openvr.templates

import org.lwjgl.generator.*
import org.lwjgl.openvr.*

val VR = "VR".nativeClass(packageName = OPENVR_PACKAGE, prefixMethod = "VR_", binding = OPENVR_API_BINDING) {
	documentation =
		"""
		Because the OpenVR API causes the game to connect to any attached VR hardware, it is not initialized automatically. To initialize the API and get
		access to the {@code IVRSystem} interface call the #InitInternal() function and pass the returned token to OpenVR#create(). To close down your
		connection to the hardware and release your {@code IVRSystem} interface, call #ShutdownInternal().
		"""
	
	IntConstant(
		"OpenVR constants.",

		"k_unMaxDriverDebugResponseSize".."32768",
		"k_unTrackedDeviceIndex_Hmd".."0",
		"k_unMaxTrackedDeviceCount".."16",
		"k_unTrackedDeviceIndexOther".."0xFFFFFFFE",
		"k_unTrackedDeviceIndexInvalid".."0xFFFFFFFF",
		"k_unMaxPropertyStringSize".."32768",
		"k_unControllerStateAxisCount".."5",
		"k_unScreenshotHandleInvalid".."0",
		"k_unMaxApplicationKeyLength".."128",
		"k_unVROverlayMaxKeyLength".."128",
		"k_unVROverlayMaxNameLength".."128",
		"k_unMaxOverlayCount".."64",
		"k_unMaxOverlayIntersectionMaskPrimitivesCount".."32",
		"k_unNotificationTextMaxSize".."256",
		"k_unMaxSettingsKeyLength".."128"
	)

	LongConstant(
		"OpenVR constants.",

		"k_ulOverlayHandleInvalid".."0L"
	)

	StringConstant(
		"OpenVR constants.",

		"IVRSystem_Version".."IVRSystem_015",
		"IVRExtendedDisplay_Version".."IVRExtendedDisplay_001",
		"IVRTrackedCamera_Version".."IVRTrackedCamera_003",
		"k_pch_MimeType_HomeApp".."vr/home",
		"k_pch_MimeType_GameTheater".."vr/game_theater",
		"IVRApplications_Version".."IVRApplications_006",
		"IVRChaperone_Version".."IVRChaperone_003",
		"IVRChaperoneSetup_Version".."IVRChaperoneSetup_005",
		"IVRCompositor_Version".."IVRCompositor_019",
		"IVROverlay_Version".."IVROverlay_014",
		"k_pch_Controller_Component_GDC2015".."gdc2015",
		"k_pch_Controller_Component_Base".."base",
		"k_pch_Controller_Component_Tip".."tip",
		"k_pch_Controller_Component_HandGrip".."handgrip",
		"k_pch_Controller_Component_Status".."status",
		"IVRRenderModels_Version".."IVRRenderModels_005",
		"IVRNotifications_Version".."IVRNotifications_002",
		"IVRSettings_Version".."IVRSettings_002",
		"k_pch_SteamVR_Section".."steamvr",
		"k_pch_SteamVR_RequireHmd_String".."requireHmd",
		"k_pch_SteamVR_ForcedDriverKey_String".."forcedDriver",
		"k_pch_SteamVR_ForcedHmdKey_String".."forcedHmd",
		"k_pch_SteamVR_DisplayDebug_Bool".."displayDebug",
		"k_pch_SteamVR_DebugProcessPipe_String".."debugProcessPipe",
		"k_pch_SteamVR_EnableDistortion_Bool".."enableDistortion",
		"k_pch_SteamVR_DisplayDebugX_Int32".."displayDebugX",
		"k_pch_SteamVR_DisplayDebugY_Int32".."displayDebugY",
		"k_pch_SteamVR_SendSystemButtonToAllApps_Bool".."sendSystemButtonToAllApps",
		"k_pch_SteamVR_LogLevel_Int32".."loglevel",
		"k_pch_SteamVR_IPD_Float".."ipd",
		"k_pch_SteamVR_Background_String".."background",
		"k_pch_SteamVR_BackgroundUseDomeProjection_Bool".."backgroundUseDomeProjection",
		"k_pch_SteamVR_BackgroundCameraHeight_Float".."backgroundCameraHeight",
		"k_pch_SteamVR_BackgroundDomeRadius_Float".."backgroundDomeRadius",
		"k_pch_SteamVR_GridColor_String".."gridColor",
		"k_pch_SteamVR_PlayAreaColor_String".."playAreaColor",
		"k_pch_SteamVR_ShowStage_Bool".."showStage",
		"k_pch_SteamVR_ActivateMultipleDrivers_Bool".."activateMultipleDrivers",
		"k_pch_SteamVR_DirectMode_Bool".."directMode",
		"k_pch_SteamVR_DirectModeEdidVid_Int32".."directModeEdidVid",
		"k_pch_SteamVR_DirectModeEdidPid_Int32".."directModeEdidPid",
		"k_pch_SteamVR_UsingSpeakers_Bool".."usingSpeakers",
		"k_pch_SteamVR_SpeakersForwardYawOffsetDegrees_Float".."speakersForwardYawOffsetDegrees",
		"k_pch_SteamVR_BaseStationPowerManagement_Bool".."basestationPowerManagement",
		"k_pch_SteamVR_NeverKillProcesses_Bool".."neverKillProcesses",
		"k_pch_SteamVR_RenderTargetMultiplier_Float".."renderTargetMultiplier",
		"k_pch_SteamVR_AllowAsyncReprojection_Bool".."allowAsyncReprojection",
		"k_pch_SteamVR_AllowReprojection_Bool".."allowInterleavedReprojection",
		"k_pch_SteamVR_ForceReprojection_Bool".."forceReprojection",
		"k_pch_SteamVR_ForceFadeOnBadTracking_Bool".."forceFadeOnBadTracking",
		"k_pch_SteamVR_DefaultMirrorView_Int32".."defaultMirrorView",
		"k_pch_SteamVR_ShowMirrorView_Bool".."showMirrorView",
		"k_pch_SteamVR_MirrorViewGeometry_String".."mirrorViewGeometry",
		"k_pch_SteamVR_StartMonitorFromAppLaunch".."startMonitorFromAppLaunch",
		"k_pch_SteamVR_StartCompositorFromAppLaunch_Bool".."startCompositorFromAppLaunch",
		"k_pch_SteamVR_StartDashboardFromAppLaunch_Bool".."startDashboardFromAppLaunch",
		"k_pch_SteamVR_StartOverlayAppsFromDashboard_Bool".."startOverlayAppsFromDashboard",
		"k_pch_SteamVR_EnableHomeApp".."enableHomeApp",
		"k_pch_SteamVR_SetInitialDefaultHomeApp".."setInitialDefaultHomeApp",
		"k_pch_SteamVR_CycleBackgroundImageTimeSec_Int32".."CycleBackgroundImageTimeSec",
		"k_pch_SteamVR_RetailDemo_Bool".."retailDemo",
		"k_pch_SteamVR_IpdOffset_Float".."ipdOffset",
		"k_pch_Lighthouse_Section".."driver_lighthouse",
		"k_pch_Lighthouse_DisableIMU_Bool".."disableimu",
		"k_pch_Lighthouse_UseDisambiguation_String".."usedisambiguation",
		"k_pch_Lighthouse_DisambiguationDebug_Int32".."disambiguationdebug",
		"k_pch_Lighthouse_PrimaryBasestation_Int32".."primarybasestation",
		"k_pch_Lighthouse_DBHistory_Bool".."dbhistory",
		"k_pch_Null_Section".."driver_null",
		"k_pch_Null_EnableNullDriver_Bool".."enable",
		"k_pch_Null_SerialNumber_String".."serialNumber",
		"k_pch_Null_ModelNumber_String".."modelNumber",
		"k_pch_Null_WindowX_Int32".."windowX",
		"k_pch_Null_WindowY_Int32".."windowY",
		"k_pch_Null_WindowWidth_Int32".."windowWidth",
		"k_pch_Null_WindowHeight_Int32".."windowHeight",
		"k_pch_Null_RenderWidth_Int32".."renderWidth",
		"k_pch_Null_RenderHeight_Int32".."renderHeight",
		"k_pch_Null_SecondsFromVsyncToPhotons_Float".."secondsFromVsyncToPhotons",
		"k_pch_Null_DisplayFrequency_Float".."displayFrequency",
		"k_pch_UserInterface_Section".."userinterface",
		"k_pch_UserInterface_StatusAlwaysOnTop_Bool".."StatusAlwaysOnTop",
		"k_pch_UserInterface_MinimizeToTray_Bool".."MinimizeToTray",
		"k_pch_UserInterface_Screenshots_Bool".."screenshots",
		"k_pch_UserInterface_ScreenshotType_Int".."screenshotType",
		"k_pch_Notifications_Section".."notifications",
		"k_pch_Notifications_DoNotDisturb_Bool".."DoNotDisturb",
		"k_pch_Keyboard_Section".."keyboard",
		"k_pch_Keyboard_TutorialCompletions".."TutorialCompletions",
		"k_pch_Keyboard_ScaleX".."ScaleX",
		"k_pch_Keyboard_ScaleY".."ScaleY",
		"k_pch_Keyboard_OffsetLeftX".."OffsetLeftX",
		"k_pch_Keyboard_OffsetRightX".."OffsetRightX",
		"k_pch_Keyboard_OffsetY".."OffsetY",
		"k_pch_Keyboard_Smoothing".."Smoothing",
		"k_pch_Perf_Section".."perfcheck",
		"k_pch_Perf_HeuristicActive_Bool".."heuristicActive",
		"k_pch_Perf_NotifyInHMD_Bool".."warnInHMD",
		"k_pch_Perf_NotifyOnlyOnce_Bool".."warnOnlyOnce",
		"k_pch_Perf_AllowTimingStore_Bool".."allowTimingStore",
		"k_pch_Perf_SaveTimingsOnExit_Bool".."saveTimingsOnExit",
		"k_pch_Perf_TestData_Float".."perfTestData",
		"k_pch_CollisionBounds_Section".."collisionBounds",
		"k_pch_CollisionBounds_Style_Int32".."CollisionBoundsStyle",
		"k_pch_CollisionBounds_GroundPerimeterOn_Bool".."CollisionBoundsGroundPerimeterOn",
		"k_pch_CollisionBounds_CenterMarkerOn_Bool".."CollisionBoundsCenterMarkerOn",
		"k_pch_CollisionBounds_PlaySpaceOn_Bool".."CollisionBoundsPlaySpaceOn",
		"k_pch_CollisionBounds_FadeDistance_Float".."CollisionBoundsFadeDistance",
		"k_pch_CollisionBounds_ColorGammaR_Int32".."CollisionBoundsColorGammaR",
		"k_pch_CollisionBounds_ColorGammaG_Int32".."CollisionBoundsColorGammaG",
		"k_pch_CollisionBounds_ColorGammaB_Int32".."CollisionBoundsColorGammaB",
		"k_pch_CollisionBounds_ColorGammaA_Int32".."CollisionBoundsColorGammaA",
		"k_pch_Camera_Section".."camera",
		"k_pch_Camera_EnableCamera_Bool".."enableCamera",
		"k_pch_Camera_EnableCameraInDashboard_Bool".."enableCameraInDashboard",
		"k_pch_Camera_EnableCameraForCollisionBounds_Bool".."enableCameraForCollisionBounds",
		"k_pch_Camera_EnableCameraForRoomView_Bool".."enableCameraForRoomView",
		"k_pch_Camera_BoundsColorGammaR_Int32".."cameraBoundsColorGammaR",
		"k_pch_Camera_BoundsColorGammaG_Int32".."cameraBoundsColorGammaG",
		"k_pch_Camera_BoundsColorGammaB_Int32".."cameraBoundsColorGammaB",
		"k_pch_Camera_BoundsColorGammaA_Int32".."cameraBoundsColorGammaA",
		"k_pch_Camera_BoundsStrength_Int32".."cameraBoundsStrength",
		"k_pch_audio_Section".."audio",
		"k_pch_audio_OnPlaybackDevice_String".."onPlaybackDevice",
		"k_pch_audio_OnRecordDevice_String".."onRecordDevice",
		"k_pch_audio_OnPlaybackMirrorDevice_String".."onPlaybackMirrorDevice",
		"k_pch_audio_OffPlaybackDevice_String".."offPlaybackDevice",
		"k_pch_audio_OffRecordDevice_String".."offRecordDevice",
		"k_pch_audio_VIVEHDMIGain".."viveHDMIGain",
		"k_pch_Power_Section".."power",
		"k_pch_Power_PowerOffOnExit_Bool".."powerOffOnExit",
		"k_pch_Power_TurnOffScreensTimeout_Float".."turnOffScreensTimeout",
		"k_pch_Power_TurnOffControllersTimeout_Float".."turnOffControllersTimeout",
		"k_pch_Power_ReturnToWatchdogTimeout_Float".."returnToWatchdogTimeout",
		"k_pch_Power_AutoLaunchSteamVROnButtonPress".."autoLaunchSteamVROnButtonPress",
		"k_pch_Dashboard_Section".."dashboard",
		"k_pch_Dashboard_EnableDashboard_Bool".."enableDashboard",
		"k_pch_Dashboard_ArcadeMode_Bool".."arcadeMode",
		"k_pch_modelskin_Section".."modelskins",
		"IVRScreenshots_Version".."IVRScreenshots_001",
		"IVRResources_Version".."IVRResources_001"
	)
	
	// OpenVR Enums

	EnumConstant(
		"EVREye",

		"EVREye_Eye_Left".enum("", "0"),
		"EVREye_Eye_Right".enum("", "1")
	)

	EnumConstant(
		"ETextureType",

		"ETextureType_TextureType_DirectX".enum("Handle is an ID3D11Texture.", "0"),
		"ETextureType_TextureType_OpenGL".enum("Handle is an OpenGL texture name or an OpenGL render buffer name, depending on submit flags.", "1"),
		"ETextureType_TextureType_Vulkan".enum("Handle is a pointer to a VRVulkanTextureData_t structure.", "2")
	)

	EnumConstant(
		"EColorSpace",

		"EColorSpace_ColorSpace_Auto".enum(
			"Assumes 'gamma' for 8-bit per component formats, otherwise 'linear'. This mirrors the DXGI formats which have _SRGB variants.",
			"0"
		),
		"EColorSpace_ColorSpace_Gamma".enum(
			"Texture data can be displayed directly on the display without any conversion (a.k.a. display native format).",
			"1"
		),
		"EColorSpace_ColorSpace_Linear".enum("Same as gamma but has been converted to a linear representation using DXGI's sRGB conversion algorithm.", "2")
	)

	EnumConstant(
		"ETrackingResult",

		"ETrackingResult_TrackingResult_Uninitialized".enum("", "1"),
		"ETrackingResult_TrackingResult_Calibrating_InProgress".enum("", "100"),
		"ETrackingResult_TrackingResult_Calibrating_OutOfRange".enum("", "101"),
		"ETrackingResult_TrackingResult_Running_OK".enum("", "200"),
		"ETrackingResult_TrackingResult_Running_OutOfRange".enum("", "201")
	)

	EnumConstant(
		"{@code ETrackedDeviceClass}: Describes what kind of object is being tracked at a given ID.",

		"ETrackedDeviceClass_TrackedDeviceClass_Invalid".enum("The ID was not valid.", "0"),
		"ETrackedDeviceClass_TrackedDeviceClass_HMD".enum("Head-Mounted Displays.", "1"),
		"ETrackedDeviceClass_TrackedDeviceClass_Controller".enum("Tracked controllers.", "2"),
		"ETrackedDeviceClass_TrackedDeviceClass_GenericTracker".enum("Generic trackers, similar to controllers.", "3"),
		"ETrackedDeviceClass_TrackedDeviceClass_TrackingReference".enum("Camera and base stations that serve as tracking reference points.", "4")
	)

	EnumConstant(
		"{@code ETrackedControllerRole}: Describes what specific role associated with a tracked device.",

		"ETrackedControllerRole_TrackedControllerRole_Invalid".enum("Invalid value for controller type.", "0"),
		"ETrackedControllerRole_TrackedControllerRole_LeftHand".enum("Tracked device associated with the left hand.", "1"),
		"ETrackedControllerRole_TrackedControllerRole_RightHand".enum("Tracked device associated with the right hand.", "2")
	)

	EnumConstant(
		"{@code ETrackingUniverseOrigin}: Identifies which style of tracking origin the application wants to use for the poses it is requesting.",

		"ETrackingUniverseOrigin_TrackingUniverseSeated".enum("Poses are provided relative to the seated zero pose.", "0"),
		"ETrackingUniverseOrigin_TrackingUniverseStanding".enum("Poses are provided relative to the safe bounds configured by the user.", "1"),
		"ETrackingUniverseOrigin_TrackingUniverseRawAndUncalibrated".enum(
			"""
			Poses are provided in the coordinate system defined by the driver.  It has Y up and is unified for devices of the same driver. You usually don't
			want this one.
			""",
			"2"
		)
	)

	EnumConstant(
		"{@code ETrackedDeviceProperty}: Each entry in this enum represents a property that can be retrieved about a tracked device. Many fields are only valid for one {@code ETrackedDeviceClass}.",

		"ETrackedDeviceProperty_Prop_Invalid".enum("", "0"),
		"ETrackedDeviceProperty_Prop_TrackingSystemName_String".enum("", "1000"),
		"ETrackedDeviceProperty_Prop_ModelNumber_String".enum("", "1001"),
		"ETrackedDeviceProperty_Prop_SerialNumber_String".enum("", "1002"),
		"ETrackedDeviceProperty_Prop_RenderModelName_String".enum("", "1003"),
		"ETrackedDeviceProperty_Prop_WillDriftInYaw_Bool".enum("", "1004"),
		"ETrackedDeviceProperty_Prop_ManufacturerName_String".enum("", "1005"),
		"ETrackedDeviceProperty_Prop_TrackingFirmwareVersion_String".enum("", "1006"),
		"ETrackedDeviceProperty_Prop_HardwareRevision_String".enum("", "1007"),
		"ETrackedDeviceProperty_Prop_AllWirelessDongleDescriptions_String".enum("", "1008"),
		"ETrackedDeviceProperty_Prop_ConnectedWirelessDongle_String".enum("", "1009"),
		"ETrackedDeviceProperty_Prop_DeviceIsWireless_Bool".enum("", "1010"),
		"ETrackedDeviceProperty_Prop_DeviceIsCharging_Bool".enum("", "1011"),
		"ETrackedDeviceProperty_Prop_DeviceBatteryPercentage_Float".enum("0 is empty, 1 is full", "1012"),
		"ETrackedDeviceProperty_Prop_StatusDisplayTransform_Matrix34".enum("", "1013"),
		"ETrackedDeviceProperty_Prop_Firmware_UpdateAvailable_Bool".enum("", "1014"),
		"ETrackedDeviceProperty_Prop_Firmware_ManualUpdate_Bool".enum("", "1015"),
		"ETrackedDeviceProperty_Prop_Firmware_ManualUpdateURL_String".enum("", "1016"),
		"ETrackedDeviceProperty_Prop_HardwareRevision_Uint64".enum("", "1017"),
		"ETrackedDeviceProperty_Prop_FirmwareVersion_Uint64".enum("", "1018"),
		"ETrackedDeviceProperty_Prop_FPGAVersion_Uint64".enum("", "1019"),
		"ETrackedDeviceProperty_Prop_VRCVersion_Uint64".enum("", "1020"),
		"ETrackedDeviceProperty_Prop_RadioVersion_Uint64".enum("", "1021"),
		"ETrackedDeviceProperty_Prop_DongleVersion_Uint64".enum("", "1022"),
		"ETrackedDeviceProperty_Prop_BlockServerShutdown_Bool".enum("", "1023"),
		"ETrackedDeviceProperty_Prop_CanUnifyCoordinateSystemWithHmd_Bool".enum("", "1024"),
		"ETrackedDeviceProperty_Prop_ContainsProximitySensor_Bool".enum("", "1025"),
		"ETrackedDeviceProperty_Prop_DeviceProvidesBatteryStatus_Bool".enum("", "1026"),
		"ETrackedDeviceProperty_Prop_DeviceCanPowerOff_Bool".enum("", "1027"),
		"ETrackedDeviceProperty_Prop_Firmware_ProgrammingTarget_String".enum("", "1028"),
		"ETrackedDeviceProperty_Prop_DeviceClass_Int32".enum("", "1029"),
		"ETrackedDeviceProperty_Prop_HasCamera_Bool".enum("", "1030"),
		"ETrackedDeviceProperty_Prop_DriverVersion_String".enum("", "1031"),
		"ETrackedDeviceProperty_Prop_Firmware_ForceUpdateRequired_Bool".enum("", "1032"),
		"ETrackedDeviceProperty_Prop_ViveSystemButtonFixRequired_Bool".enum("", "1033"),
		"ETrackedDeviceProperty_Prop_ReportsTimeSinceVSync_Bool".enum("", "2000"),
		"ETrackedDeviceProperty_Prop_SecondsFromVsyncToPhotons_Float".enum("", "2001"),
		"ETrackedDeviceProperty_Prop_DisplayFrequency_Float".enum("", "2002"),
		"ETrackedDeviceProperty_Prop_UserIpdMeters_Float".enum("", "2003"),
		"ETrackedDeviceProperty_Prop_CurrentUniverseId_Uint64".enum("", "2004"),
		"ETrackedDeviceProperty_Prop_PreviousUniverseId_Uint64".enum("", "2005"),
		"ETrackedDeviceProperty_Prop_DisplayFirmwareVersion_Uint64".enum("", "2006"),
		"ETrackedDeviceProperty_Prop_IsOnDesktop_Bool".enum("", "2007"),
		"ETrackedDeviceProperty_Prop_DisplayMCType_Int32".enum("", "2008"),
		"ETrackedDeviceProperty_Prop_DisplayMCOffset_Float".enum("", "2009"),
		"ETrackedDeviceProperty_Prop_DisplayMCScale_Float".enum("", "2010"),
		"ETrackedDeviceProperty_Prop_EdidVendorID_Int32".enum("", "2011"),
		"ETrackedDeviceProperty_Prop_DisplayMCImageLeft_String".enum("", "2012"),
		"ETrackedDeviceProperty_Prop_DisplayMCImageRight_String".enum("", "2013"),
		"ETrackedDeviceProperty_Prop_DisplayGCBlackClamp_Float".enum("", "2014"),
		"ETrackedDeviceProperty_Prop_EdidProductID_Int32".enum("", "2015"),
		"ETrackedDeviceProperty_Prop_CameraToHeadTransform_Matrix34".enum("", "2016"),
		"ETrackedDeviceProperty_Prop_DisplayGCType_Int32".enum("", "2017"),
		"ETrackedDeviceProperty_Prop_DisplayGCOffset_Float".enum("", "2018"),
		"ETrackedDeviceProperty_Prop_DisplayGCScale_Float".enum("", "2019"),
		"ETrackedDeviceProperty_Prop_DisplayGCPrescale_Float".enum("", "2020"),
		"ETrackedDeviceProperty_Prop_DisplayGCImage_String".enum("", "2021"),
		"ETrackedDeviceProperty_Prop_LensCenterLeftU_Float".enum("", "2022"),
		"ETrackedDeviceProperty_Prop_LensCenterLeftV_Float".enum("", "2023"),
		"ETrackedDeviceProperty_Prop_LensCenterRightU_Float".enum("", "2024"),
		"ETrackedDeviceProperty_Prop_LensCenterRightV_Float".enum("", "2025"),
		"ETrackedDeviceProperty_Prop_UserHeadToEyeDepthMeters_Float".enum("", "2026"),
		"ETrackedDeviceProperty_Prop_CameraFirmwareVersion_Uint64".enum("", "2027"),
		"ETrackedDeviceProperty_Prop_CameraFirmwareDescription_String".enum("", "2028"),
		"ETrackedDeviceProperty_Prop_DisplayFPGAVersion_Uint64".enum("", "2029"),
		"ETrackedDeviceProperty_Prop_DisplayBootloaderVersion_Uint64".enum("", "2030"),
		"ETrackedDeviceProperty_Prop_DisplayHardwareVersion_Uint64".enum("", "2031"),
		"ETrackedDeviceProperty_Prop_AudioFirmwareVersion_Uint64".enum("", "2032"),
		"ETrackedDeviceProperty_Prop_CameraCompatibilityMode_Int32".enum("", "2033"),
		"ETrackedDeviceProperty_Prop_ScreenshotHorizontalFieldOfViewDegrees_Float".enum("", "2034"),
		"ETrackedDeviceProperty_Prop_ScreenshotVerticalFieldOfViewDegrees_Float".enum("", "2035"),
		"ETrackedDeviceProperty_Prop_DisplaySuppressed_Bool".enum("", "2036"),
		"ETrackedDeviceProperty_Prop_DisplayAllowNightMode_Bool".enum("", "2037"),
		"ETrackedDeviceProperty_Prop_AttachedDeviceId_String".enum("", "3000"),
		"ETrackedDeviceProperty_Prop_SupportedButtons_Uint64".enum("", "3001"),
		"ETrackedDeviceProperty_Prop_Axis0Type_Int32".enum("", "3002"),
		"ETrackedDeviceProperty_Prop_Axis1Type_Int32".enum("", "3003"),
		"ETrackedDeviceProperty_Prop_Axis2Type_Int32".enum("", "3004"),
		"ETrackedDeviceProperty_Prop_Axis3Type_Int32".enum("", "3005"),
		"ETrackedDeviceProperty_Prop_Axis4Type_Int32".enum("", "3006"),
		"ETrackedDeviceProperty_Prop_ControllerRoleHint_Int32".enum("", "3007"),
		"ETrackedDeviceProperty_Prop_FieldOfViewLeftDegrees_Float".enum("", "4000"),
		"ETrackedDeviceProperty_Prop_FieldOfViewRightDegrees_Float".enum("", "4001"),
		"ETrackedDeviceProperty_Prop_FieldOfViewTopDegrees_Float".enum("", "4002"),
		"ETrackedDeviceProperty_Prop_FieldOfViewBottomDegrees_Float".enum("", "4003"),
		"ETrackedDeviceProperty_Prop_TrackingRangeMinimumMeters_Float".enum("", "4004"),
		"ETrackedDeviceProperty_Prop_TrackingRangeMaximumMeters_Float".enum("", "4005"),
		"ETrackedDeviceProperty_Prop_ModeLabel_String".enum("", "4006"),
		"ETrackedDeviceProperty_Prop_IconPathName_String".enum("usually a directory named \"icons\"", "5000"),
		"ETrackedDeviceProperty_Prop_NamedIconPathDeviceOff_String".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "5001"),
		"ETrackedDeviceProperty_Prop_NamedIconPathDeviceSearching_String".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "5002"),
		"ETrackedDeviceProperty_Prop_NamedIconPathDeviceSearchingAlert_String".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "5003"),
		"ETrackedDeviceProperty_Prop_NamedIconPathDeviceReady_String".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "5004"),
		"ETrackedDeviceProperty_Prop_NamedIconPathDeviceReadyAlert_String".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "5005"),
		"ETrackedDeviceProperty_Prop_NamedIconPathDeviceNotReady_String".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "5006"),
		"ETrackedDeviceProperty_Prop_NamedIconPathDeviceStandby_String".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "5007"),
		"ETrackedDeviceProperty_Prop_NamedIconPathDeviceAlertLow_String".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "5008"),
		"ETrackedDeviceProperty_Prop_VendorSpecific_Reserved_Start".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "10000"),
		"ETrackedDeviceProperty_Prop_VendorSpecific_Reserved_End".enum("PNG for static icon, or GIF for animation, 50x32 for headsets and 32x32 for others", "10999")
	)

	EnumConstant(
		"{@code ETrackedPropertyError}: Used to return errors that occur when reading properties.",

		"ETrackedPropertyError_TrackedProp_Success".enum("", "0"),
		"ETrackedPropertyError_TrackedProp_WrongDataType".enum("", "1"),
		"ETrackedPropertyError_TrackedProp_WrongDeviceClass".enum("", "2"),
		"ETrackedPropertyError_TrackedProp_BufferTooSmall".enum("", "3"),
		"ETrackedPropertyError_TrackedProp_UnknownProperty".enum("", "4"),
		"ETrackedPropertyError_TrackedProp_InvalidDevice".enum("", "5"),
		"ETrackedPropertyError_TrackedProp_CouldNotContactServer".enum("", "6"),
		"ETrackedPropertyError_TrackedProp_ValueNotProvidedByDevice".enum("", "7"),
		"ETrackedPropertyError_TrackedProp_StringExceedsMaximumLength".enum("", "8"),
		"ETrackedPropertyError_TrackedProp_NotYetAvailable".enum("The property value isn't known yet, but is expected soon. Call again later.", "9"),
		"ETrackedPropertyError_TrackedProp_PermissionDenied".enum("", "10")
	)

	EnumConstant(
		"{@code EVRSubmitFlags}: Allows the application to control how scene textures are used by the compositor when calling #Submit().",

		"EVRSubmitFlags_Submit_Default".enum(
			"Simple render path. App submits rendered left and right eye images with no lens distortion correction applied.",
			"0"
		),
		"EVRSubmitFlags_Submit_LensDistortionAlreadyApplied".enum(
			"""
			App submits final left and right eye images with lens distortion already applied (lens distortion makes the images appear barrel distorted with
			chromatic aberration correction applied). The app would have used the data returned by #ComputeDistortion() to apply the correct distortion to the
			rendered images before calling #Submit().
			""",
			"1"
		),
		"EVRSubmitFlags_Submit_GlRenderBuffer".enum(
			"If the texture pointer passed in is actually a renderbuffer (e.g. for MSAA in OpenGL) then set this flag.",
			"2"
		),
		"EVRSubmitFlags_Submit_Reserved".enum("Do not use.", "4")
	)

	EnumConstant(
		"{@code EVRState}: Status of the overall system or tracked objects.",

		"EVRState_VRState_Undefined".enum("", "-1"),
		"EVRState_VRState_Off".enum("", "0"),
		"EVRState_VRState_Searching".enum("", "1"),
		"EVRState_VRState_Searching_Alert".enum("", "2"),
		"EVRState_VRState_Ready".enum("", "3"),
		"EVRState_VRState_Ready_Alert".enum("", "4"),
		"EVRState_VRState_NotReady".enum("", "5"),
		"EVRState_VRState_Standby".enum("", "6"),
		"EVRState_VRState_Ready_Alert_Low".enum("", "7")
	)

	EnumConstant(
		"EVREventType",

		"EVREventType_VREvent_None".enum("", "0"),
		"EVREventType_VREvent_TrackedDeviceActivated".enum("", "100"),
		"EVREventType_VREvent_TrackedDeviceDeactivated".enum("", "101"),
		"EVREventType_VREvent_TrackedDeviceUpdated".enum("", "102"),
		"EVREventType_VREvent_TrackedDeviceUserInteractionStarted".enum("", "103"),
		"EVREventType_VREvent_TrackedDeviceUserInteractionEnded".enum("", "104"),
		"EVREventType_VREvent_IpdChanged".enum("", "105"),
		"EVREventType_VREvent_EnterStandbyMode".enum("", "106"),
		"EVREventType_VREvent_LeaveStandbyMode".enum("", "107"),
		"EVREventType_VREvent_TrackedDeviceRoleChanged".enum("", "108"),
		"EVREventType_VREvent_WatchdogWakeUpRequested".enum("", "109"),
		"EVREventType_VREvent_LensDistortionChanged".enum("", "110"),
		"EVREventType_VREvent_ButtonPress".enum("", "200"),
		"EVREventType_VREvent_ButtonUnpress".enum("", "201"),
		"EVREventType_VREvent_ButtonTouch".enum("", "202"),
		"EVREventType_VREvent_ButtonUntouch".enum("", "203"),
		"EVREventType_VREvent_MouseMove".enum("", "300"),
		"EVREventType_VREvent_MouseButtonDown".enum("", "301"),
		"EVREventType_VREvent_MouseButtonUp".enum("", "302"),
		"EVREventType_VREvent_FocusEnter".enum("", "303"),
		"EVREventType_VREvent_FocusLeave".enum("", "304"),
		"EVREventType_VREvent_Scroll".enum("", "305"),
		"EVREventType_VREvent_TouchPadMove".enum("", "306"),
		"EVREventType_VREvent_OverlayFocusChanged".enum("", "307"),
		"EVREventType_VREvent_InputFocusCaptured".enum("", "400"),
		"EVREventType_VREvent_InputFocusReleased".enum("", "401"),
		"EVREventType_VREvent_SceneFocusLost".enum("", "402"),
		"EVREventType_VREvent_SceneFocusGained".enum("", "403"),
		"EVREventType_VREvent_SceneApplicationChanged".enum("", "404"),
		"EVREventType_VREvent_SceneFocusChanged".enum("", "405"),
		"EVREventType_VREvent_InputFocusChanged".enum("", "406"),
		"EVREventType_VREvent_SceneApplicationSecondaryRenderingStarted".enum("", "407"),
		"EVREventType_VREvent_HideRenderModels".enum("", "410"),
		"EVREventType_VREvent_ShowRenderModels".enum("", "411"),
		"EVREventType_VREvent_OverlayShown".enum("", "500"),
		"EVREventType_VREvent_OverlayHidden".enum("", "501"),
		"EVREventType_VREvent_DashboardActivated".enum("", "502"),
		"EVREventType_VREvent_DashboardDeactivated".enum("", "503"),
		"EVREventType_VREvent_DashboardThumbSelected".enum("", "504"),
		"EVREventType_VREvent_DashboardRequested".enum("", "505"),
		"EVREventType_VREvent_ResetDashboard".enum("", "506"),
		"EVREventType_VREvent_RenderToast".enum("", "507"),
		"EVREventType_VREvent_ImageLoaded".enum("", "508"),
		"EVREventType_VREvent_ShowKeyboard".enum("", "509"),
		"EVREventType_VREvent_HideKeyboard".enum("", "510"),
		"EVREventType_VREvent_OverlayGamepadFocusGained".enum("", "511"),
		"EVREventType_VREvent_OverlayGamepadFocusLost".enum("", "512"),
		"EVREventType_VREvent_OverlaySharedTextureChanged".enum("", "513"),
		"EVREventType_VREvent_DashboardGuideButtonDown".enum("", "514"),
		"EVREventType_VREvent_DashboardGuideButtonUp".enum("", "515"),
		"EVREventType_VREvent_ScreenshotTriggered".enum("", "516"),
		"EVREventType_VREvent_ImageFailed".enum("", "517"),
		"EVREventType_VREvent_DashboardOverlayCreated".enum("", "518"),
		"EVREventType_VREvent_RequestScreenshot".enum("", "520"),
		"EVREventType_VREvent_ScreenshotTaken".enum("", "521"),
		"EVREventType_VREvent_ScreenshotFailed".enum("", "522"),
		"EVREventType_VREvent_SubmitScreenshotToDashboard".enum("", "523"),
		"EVREventType_VREvent_ScreenshotProgressToDashboard".enum("", "524"),
		"EVREventType_VREvent_Notification_Shown".enum("", "600"),
		"EVREventType_VREvent_Notification_Hidden".enum("", "601"),
		"EVREventType_VREvent_Notification_BeginInteraction".enum("", "602"),
		"EVREventType_VREvent_Notification_Destroyed".enum("", "603"),
		"EVREventType_VREvent_Quit".enum("", "700"),
		"EVREventType_VREvent_ProcessQuit".enum("", "701"),
		"EVREventType_VREvent_QuitAborted_UserPrompt".enum("", "702"),
		"EVREventType_VREvent_QuitAcknowledged".enum("", "703"),
		"EVREventType_VREvent_DriverRequestedQuit".enum("", "704"),
		"EVREventType_VREvent_ChaperoneDataHasChanged".enum("", "800"),
		"EVREventType_VREvent_ChaperoneUniverseHasChanged".enum("", "801"),
		"EVREventType_VREvent_ChaperoneTempDataHasChanged".enum("", "802"),
		"EVREventType_VREvent_ChaperoneSettingsHaveChanged".enum("", "803"),
		"EVREventType_VREvent_SeatedZeroPoseReset".enum("", "804"),
		"EVREventType_VREvent_AudioSettingsHaveChanged".enum("", "820"),
		"EVREventType_VREvent_BackgroundSettingHasChanged".enum("", "850"),
		"EVREventType_VREvent_CameraSettingsHaveChanged".enum("", "851"),
		"EVREventType_VREvent_ReprojectionSettingHasChanged".enum("", "852"),
		"EVREventType_VREvent_ModelSkinSettingsHaveChanged".enum("", "853"),
		"EVREventType_VREvent_EnvironmentSettingsHaveChanged".enum("", "854"),
		"EVREventType_VREvent_PowerSettingsHaveChanged".enum("", "855"),
		"EVREventType_VREvent_StatusUpdate".enum("", "900"),
		"EVREventType_VREvent_MCImageUpdated".enum("", "1000"),
		"EVREventType_VREvent_FirmwareUpdateStarted".enum("", "1100"),
		"EVREventType_VREvent_FirmwareUpdateFinished".enum("", "1101"),
		"EVREventType_VREvent_KeyboardClosed".enum("", "1200"),
		"EVREventType_VREvent_KeyboardCharInput".enum("", "1201"),
		"EVREventType_VREvent_KeyboardDone".enum("", "1202"),
		"EVREventType_VREvent_ApplicationTransitionStarted".enum("", "1300"),
		"EVREventType_VREvent_ApplicationTransitionAborted".enum("", "1301"),
		"EVREventType_VREvent_ApplicationTransitionNewAppStarted".enum("", "1302"),
		"EVREventType_VREvent_ApplicationListUpdated".enum("", "1303"),
		"EVREventType_VREvent_ApplicationMimeTypeLoad".enum("", "1304"),
		"EVREventType_VREvent_Compositor_MirrorWindowShown".enum("", "1400"),
		"EVREventType_VREvent_Compositor_MirrorWindowHidden".enum("", "1401"),
		"EVREventType_VREvent_Compositor_ChaperoneBoundsShown".enum("", "1410"),
		"EVREventType_VREvent_Compositor_ChaperoneBoundsHidden".enum("", "1411"),
		"EVREventType_VREvent_TrackedCamera_StartVideoStream".enum("", "1500"),
		"EVREventType_VREvent_TrackedCamera_StopVideoStream".enum("", "1501"),
		"EVREventType_VREvent_TrackedCamera_PauseVideoStream".enum("", "1502"),
		"EVREventType_VREvent_TrackedCamera_ResumeVideoStream".enum("", "1503"),
		"EVREventType_VREvent_TrackedCamera_EditingSurface".enum("", "1550"),
		"EVREventType_VREvent_PerformanceTest_EnableCapture".enum("", "1600"),
		"EVREventType_VREvent_PerformanceTest_DisableCapture".enum("", "1601"),
		"EVREventType_VREvent_PerformanceTest_FidelityLevel".enum("", "1602"),
		"EVREventType_VREvent_MessageOverlay_Closed".enum("", "1650"),
		"EVREventType_VREvent_VendorSpecific_Reserved_Start".enum("", "10000"),
		"EVREventType_VREvent_VendorSpecific_Reserved_End".enum("", "19999")
	)

	EnumConstant(
		"EDeviceActivityLevel",

		"EDeviceActivityLevel_k_EDeviceActivityLevel_Unknown".enum("", "-1"),
		"EDeviceActivityLevel_k_EDeviceActivityLevel_Idle".enum("", "0"),
		"EDeviceActivityLevel_k_EDeviceActivityLevel_UserInteraction".enum("", "1"),
		"EDeviceActivityLevel_k_EDeviceActivityLevel_UserInteraction_Timeout".enum("", "2"),
		"EDeviceActivityLevel_k_EDeviceActivityLevel_Standby".enum("", "3")
	)

	EnumConstant(
		"EVRButtonId",

		"EVRButtonId_k_EButton_System".enum("", "0"),
		"EVRButtonId_k_EButton_ApplicationMenu".enum("", "1"),
		"EVRButtonId_k_EButton_Grip".enum("", "2"),
		"EVRButtonId_k_EButton_DPad_Left".enum("", "3"),
		"EVRButtonId_k_EButton_DPad_Up".enum("", "4"),
		"EVRButtonId_k_EButton_DPad_Right".enum("", "5"),
		"EVRButtonId_k_EButton_DPad_Down".enum("", "6"),
		"EVRButtonId_k_EButton_A".enum("", "7"),
		"EVRButtonId_k_EButton_ProximitySensor".enum("", "31"),
		"EVRButtonId_k_EButton_Axis0".enum("", "32"),
		"EVRButtonId_k_EButton_Axis1".enum("", "33"),
		"EVRButtonId_k_EButton_Axis2".enum("", "34"),
		"EVRButtonId_k_EButton_Axis3".enum("", "35"),
		"EVRButtonId_k_EButton_Axis4".enum("", "36"),
		"EVRButtonId_k_EButton_SteamVR_Touchpad".enum("", "32"),
		"EVRButtonId_k_EButton_SteamVR_Trigger".enum("", "33"),
		"EVRButtonId_k_EButton_Dashboard_Back".enum("", "2"),
		"EVRButtonId_k_EButton_Max".enum("", "64")
	)

	EnumConstant(
		"EVRMouseButton",

		"EVRMouseButton_VRMouseButton_Left".enum("", "1"),
		"EVRMouseButton_VRMouseButton_Right".enum("", "2"),
		"EVRMouseButton_VRMouseButton_Middle".enum("", "4")
	)

	EnumConstant(
		"EHiddenAreaMeshType",

		"EHiddenAreaMeshType_k_eHiddenAreaMesh_Standard".enum("", "0"),
		"EHiddenAreaMeshType_k_eHiddenAreaMesh_Inverse".enum("", "1"),
		"EHiddenAreaMeshType_k_eHiddenAreaMesh_LineLoop".enum("", "2")
	)

	EnumConstant(
		"EVRControllerAxisType",

		"EVRControllerAxisType_k_eControllerAxis_None".enum("", "0"),
		"EVRControllerAxisType_k_eControllerAxis_TrackPad".enum("", "1"),
		"EVRControllerAxisType_k_eControllerAxis_Joystick".enum("", "2"),
		"EVRControllerAxisType_k_eControllerAxis_Trigger".enum("", "3")
	)

	EnumConstant(
		"EVRControllerEventOutputType",

		"EVRControllerEventOutputType_ControllerEventOutput_OSEvents".enum("", "0"),
		"EVRControllerEventOutputType_ControllerEventOutput_VREvents".enum("", "1")
	)

	EnumConstant(
		"ECollisionBoundsStyle",

		"ECollisionBoundsStyle_COLLISION_BOUNDS_STYLE_BEGINNER".enum("", "0"),
		"ECollisionBoundsStyle_COLLISION_BOUNDS_STYLE_INTERMEDIATE".enum("", "1"),
		"ECollisionBoundsStyle_COLLISION_BOUNDS_STYLE_SQUARES".enum("", "2"),
		"ECollisionBoundsStyle_COLLISION_BOUNDS_STYLE_ADVANCED".enum("", "3"),
		"ECollisionBoundsStyle_COLLISION_BOUNDS_STYLE_NONE".enum("", "4"),
		"ECollisionBoundsStyle_COLLISION_BOUNDS_STYLE_COUNT".enum("", "5")
	)

	EnumConstant(
		"EVROverlayError",

		"EVROverlayError_VROverlayError_None".enum("", "0"),
		"EVROverlayError_VROverlayError_UnknownOverlay".enum("", "10"),
		"EVROverlayError_VROverlayError_InvalidHandle".enum("", "11"),
		"EVROverlayError_VROverlayError_PermissionDenied".enum("", "12"),
		"EVROverlayError_VROverlayError_OverlayLimitExceeded".enum("", "13"),
		"EVROverlayError_VROverlayError_WrongVisibilityType".enum("", "14"),
		"EVROverlayError_VROverlayError_KeyTooLong".enum("", "15"),
		"EVROverlayError_VROverlayError_NameTooLong".enum("", "16"),
		"EVROverlayError_VROverlayError_KeyInUse".enum("", "17"),
		"EVROverlayError_VROverlayError_WrongTransformType".enum("", "18"),
		"EVROverlayError_VROverlayError_InvalidTrackedDevice".enum("", "19"),
		"EVROverlayError_VROverlayError_InvalidParameter".enum("", "20"),
		"EVROverlayError_VROverlayError_ThumbnailCantBeDestroyed".enum("", "21"),
		"EVROverlayError_VROverlayError_ArrayTooSmall".enum("", "22"),
		"EVROverlayError_VROverlayError_RequestFailed".enum("", "23"),
		"EVROverlayError_VROverlayError_InvalidTexture".enum("", "24"),
		"EVROverlayError_VROverlayError_UnableToLoadFile".enum("", "25"),
		"EVROverlayError_VROverlayError_KeyboardAlreadyInUse".enum("", "26"),
		"EVROverlayError_VROverlayError_NoNeighbor".enum("", "27"),
		"EVROverlayError_VROverlayError_TooManyMaskPrimitives".enum("", "29"),
		"EVROverlayError_VROverlayError_BadMaskPrimitive".enum("", "30")
	)

	EnumConstant(
		"EVRApplicationType",

		"EVRApplicationType_VRApplication_Other".enum("", "0"),
		"EVRApplicationType_VRApplication_Scene".enum("", "1"),
		"EVRApplicationType_VRApplication_Overlay".enum("", "2"),
		"EVRApplicationType_VRApplication_Background".enum("", "3"),
		"EVRApplicationType_VRApplication_Utility".enum("", "4"),
		"EVRApplicationType_VRApplication_VRMonitor".enum("", "5"),
		"EVRApplicationType_VRApplication_SteamWatchdog".enum("", "6"),
		"EVRApplicationType_VRApplication_Max".enum("", "7")
	)

	EnumConstant(
		"EVRFirmwareError",

		"EVRFirmwareError_VRFirmwareError_None".enum("", "0"),
		"EVRFirmwareError_VRFirmwareError_Success".enum("", "1"),
		"EVRFirmwareError_VRFirmwareError_Fail".enum("", "2")
	)

	EnumConstant(
		"EVRNotificationError",

		"EVRNotificationError_VRNotificationError_OK".enum("", "0"),
		"EVRNotificationError_VRNotificationError_InvalidNotificationId".enum("", "100"),
		"EVRNotificationError_VRNotificationError_NotificationQueueFull".enum("", "101"),
		"EVRNotificationError_VRNotificationError_InvalidOverlayHandle".enum("", "102"),
		"EVRNotificationError_VRNotificationError_SystemWithUserValueAlreadyExists".enum("", "103")
	)

	EnumConstant(
		"EVRInitError",

		"EVRInitError_VRInitError_None".enum("", "0"),
		"EVRInitError_VRInitError_Unknown".enum("", "1"),
		"EVRInitError_VRInitError_Init_InstallationNotFound".enum("", "100"),
		"EVRInitError_VRInitError_Init_InstallationCorrupt".enum("", "101"),
		"EVRInitError_VRInitError_Init_VRClientDLLNotFound".enum("", "102"),
		"EVRInitError_VRInitError_Init_FileNotFound".enum("", "103"),
		"EVRInitError_VRInitError_Init_FactoryNotFound".enum("", "104"),
		"EVRInitError_VRInitError_Init_InterfaceNotFound".enum("", "105"),
		"EVRInitError_VRInitError_Init_InvalidInterface".enum("", "106"),
		"EVRInitError_VRInitError_Init_UserConfigDirectoryInvalid".enum("", "107"),
		"EVRInitError_VRInitError_Init_HmdNotFound".enum("", "108"),
		"EVRInitError_VRInitError_Init_NotInitialized".enum("", "109"),
		"EVRInitError_VRInitError_Init_PathRegistryNotFound".enum("", "110"),
		"EVRInitError_VRInitError_Init_NoConfigPath".enum("", "111"),
		"EVRInitError_VRInitError_Init_NoLogPath".enum("", "112"),
		"EVRInitError_VRInitError_Init_PathRegistryNotWritable".enum("", "113"),
		"EVRInitError_VRInitError_Init_AppInfoInitFailed".enum("", "114"),
		"EVRInitError_VRInitError_Init_Retry".enum("", "115"),
		"EVRInitError_VRInitError_Init_InitCanceledByUser".enum("", "116"),
		"EVRInitError_VRInitError_Init_AnotherAppLaunching".enum("", "117"),
		"EVRInitError_VRInitError_Init_SettingsInitFailed".enum("", "118"),
		"EVRInitError_VRInitError_Init_ShuttingDown".enum("", "119"),
		"EVRInitError_VRInitError_Init_TooManyObjects".enum("", "120"),
		"EVRInitError_VRInitError_Init_NoServerForBackgroundApp".enum("", "121"),
		"EVRInitError_VRInitError_Init_NotSupportedWithCompositor".enum("", "122"),
		"EVRInitError_VRInitError_Init_NotAvailableToUtilityApps".enum("", "123"),
		"EVRInitError_VRInitError_Init_Internal".enum("", "124"),
		"EVRInitError_VRInitError_Init_HmdDriverIdIsNone".enum("", "125"),
		"EVRInitError_VRInitError_Init_HmdNotFoundPresenceFailed".enum("", "126"),
		"EVRInitError_VRInitError_Init_VRMonitorNotFound".enum("", "127"),
		"EVRInitError_VRInitError_Init_VRMonitorStartupFailed".enum("", "128"),
		"EVRInitError_VRInitError_Init_LowPowerWatchdogNotSupported".enum("", "129"),
		"EVRInitError_VRInitError_Init_InvalidApplicationType".enum("", "130"),
		"EVRInitError_VRInitError_Init_NotAvailableToWatchdogApps".enum("", "131"),
		"EVRInitError_VRInitError_Init_WatchdogDisabledInSettings".enum("", "132"),
		"EVRInitError_VRInitError_Init_VRDashboardNotFound".enum("", "133"),
		"EVRInitError_VRInitError_Init_VRDashboardStartupFailed".enum("", "134"),
		"EVRInitError_VRInitError_Driver_Failed".enum("", "200"),
		"EVRInitError_VRInitError_Driver_Unknown".enum("", "201"),
		"EVRInitError_VRInitError_Driver_HmdUnknown".enum("", "202"),
		"EVRInitError_VRInitError_Driver_NotLoaded".enum("", "203"),
		"EVRInitError_VRInitError_Driver_RuntimeOutOfDate".enum("", "204"),
		"EVRInitError_VRInitError_Driver_HmdInUse".enum("", "205"),
		"EVRInitError_VRInitError_Driver_NotCalibrated".enum("", "206"),
		"EVRInitError_VRInitError_Driver_CalibrationInvalid".enum("", "207"),
		"EVRInitError_VRInitError_Driver_HmdDisplayNotFound".enum("", "208"),
		"EVRInitError_VRInitError_Driver_TrackedDeviceInterfaceUnknown".enum("", "209"),
		"EVRInitError_VRInitError_Driver_HmdDriverIdOutOfBounds".enum("", "211"),
		"EVRInitError_VRInitError_Driver_HmdDisplayMirrored".enum("", "212"),
		"EVRInitError_VRInitError_IPC_ServerInitFailed".enum("", "300"),
		"EVRInitError_VRInitError_IPC_ConnectFailed".enum("", "301"),
		"EVRInitError_VRInitError_IPC_SharedStateInitFailed".enum("", "302"),
		"EVRInitError_VRInitError_IPC_CompositorInitFailed".enum("", "303"),
		"EVRInitError_VRInitError_IPC_MutexInitFailed".enum("", "304"),
		"EVRInitError_VRInitError_IPC_Failed".enum("", "305"),
		"EVRInitError_VRInitError_IPC_CompositorConnectFailed".enum("", "306"),
		"EVRInitError_VRInitError_IPC_CompositorInvalidConnectResponse".enum("", "307"),
		"EVRInitError_VRInitError_IPC_ConnectFailedAfterMultipleAttempts".enum("", "308"),
		"EVRInitError_VRInitError_Compositor_Failed".enum("", "400"),
		"EVRInitError_VRInitError_Compositor_D3D11HardwareRequired".enum("", "401"),
		"EVRInitError_VRInitError_Compositor_FirmwareRequiresUpdate".enum("", "402"),
		"EVRInitError_VRInitError_Compositor_OverlayInitFailed".enum("", "403"),
		"EVRInitError_VRInitError_Compositor_ScreenshotsInitFailed".enum("", "404"),
		"EVRInitError_VRInitError_VendorSpecific_UnableToConnectToOculusRuntime".enum("", "1000"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_CantOpenDevice".enum("", "1101"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_UnableToRequestConfigStart".enum("", "1102"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_NoStoredConfig".enum("", "1103"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_ConfigTooBig".enum("", "1104"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_ConfigTooSmall".enum("", "1105"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_UnableToInitZLib".enum("", "1106"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_CantReadFirmwareVersion".enum("", "1107"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_UnableToSendUserDataStart".enum("", "1108"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_UnableToGetUserDataStart".enum("", "1109"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_UnableToGetUserDataNext".enum("", "1110"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_UserDataAddressRange".enum("", "1111"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_UserDataError".enum("", "1112"),
		"EVRInitError_VRInitError_VendorSpecific_HmdFound_ConfigFailedSanityCheck".enum("", "1113"),
		"EVRInitError_VRInitError_Steam_SteamInstallationNotFound".enum("", "2000")
	)

	EnumConstant(
		"EVRScreenshotType",

		"EVRScreenshotType_VRScreenshotType_None".enum("", "0"),
		"EVRScreenshotType_VRScreenshotType_Mono".enum("", "1"),
		"EVRScreenshotType_VRScreenshotType_Stereo".enum("", "2"),
		"EVRScreenshotType_VRScreenshotType_Cubemap".enum("", "3"),
		"EVRScreenshotType_VRScreenshotType_MonoPanorama".enum("", "4"),
		"EVRScreenshotType_VRScreenshotType_StereoPanorama".enum("", "5")
	)

	EnumConstant(
		"EVRScreenshotPropertyFilenames",

		"EVRScreenshotPropertyFilenames_VRScreenshotPropertyFilenames_Preview".enum("", "0"),
		"EVRScreenshotPropertyFilenames_VRScreenshotPropertyFilenames_VR".enum("", "1")
	)

	EnumConstant(
		"EVRTrackedCameraError",

		"EVRTrackedCameraError_VRTrackedCameraError_None".enum("", "0"),
		"EVRTrackedCameraError_VRTrackedCameraError_OperationFailed".enum("", "100"),
		"EVRTrackedCameraError_VRTrackedCameraError_InvalidHandle".enum("", "101"),
		"EVRTrackedCameraError_VRTrackedCameraError_InvalidFrameHeaderVersion".enum("", "102"),
		"EVRTrackedCameraError_VRTrackedCameraError_OutOfHandles".enum("", "103"),
		"EVRTrackedCameraError_VRTrackedCameraError_IPCFailure".enum("", "104"),
		"EVRTrackedCameraError_VRTrackedCameraError_NotSupportedForThisDevice".enum("", "105"),
		"EVRTrackedCameraError_VRTrackedCameraError_SharedMemoryFailure".enum("", "106"),
		"EVRTrackedCameraError_VRTrackedCameraError_FrameBufferingFailure".enum("", "107"),
		"EVRTrackedCameraError_VRTrackedCameraError_StreamSetupFailure".enum("", "108"),
		"EVRTrackedCameraError_VRTrackedCameraError_InvalidGLTextureId".enum("", "109"),
		"EVRTrackedCameraError_VRTrackedCameraError_InvalidSharedTextureHandle".enum("", "110"),
		"EVRTrackedCameraError_VRTrackedCameraError_FailedToGetGLTextureId".enum("", "111"),
		"EVRTrackedCameraError_VRTrackedCameraError_SharedTextureFailure".enum("", "112"),
		"EVRTrackedCameraError_VRTrackedCameraError_NoFrameAvailable".enum("", "113"),
		"EVRTrackedCameraError_VRTrackedCameraError_InvalidArgument".enum("", "114"),
		"EVRTrackedCameraError_VRTrackedCameraError_InvalidFrameBufferSize".enum("", "115")
	)

	EnumConstant(
		"EVRTrackedCameraFrameType",

		"EVRTrackedCameraFrameType_VRTrackedCameraFrameType_Distorted".enum("", "0"),
		"EVRTrackedCameraFrameType_VRTrackedCameraFrameType_Undistorted".enum("", "1"),
		"EVRTrackedCameraFrameType_VRTrackedCameraFrameType_MaximumUndistorted".enum("", "2"),
		"EVRTrackedCameraFrameType_MAX_CAMERA_FRAME_TYPES".enum("", "3")
	)

	EnumConstant(
		"EVRApplicationError",

		"EVRApplicationError_VRApplicationError_None".enum("", "0"),
		"EVRApplicationError_VRApplicationError_AppKeyAlreadyExists".enum("", "100"),
		"EVRApplicationError_VRApplicationError_NoManifest".enum("", "101"),
		"EVRApplicationError_VRApplicationError_NoApplication".enum("", "102"),
		"EVRApplicationError_VRApplicationError_InvalidIndex".enum("", "103"),
		"EVRApplicationError_VRApplicationError_UnknownApplication".enum("", "104"),
		"EVRApplicationError_VRApplicationError_IPCFailed".enum("", "105"),
		"EVRApplicationError_VRApplicationError_ApplicationAlreadyRunning".enum("", "106"),
		"EVRApplicationError_VRApplicationError_InvalidManifest".enum("", "107"),
		"EVRApplicationError_VRApplicationError_InvalidApplication".enum("", "108"),
		"EVRApplicationError_VRApplicationError_LaunchFailed".enum("", "109"),
		"EVRApplicationError_VRApplicationError_ApplicationAlreadyStarting".enum("", "110"),
		"EVRApplicationError_VRApplicationError_LaunchInProgress".enum("", "111"),
		"EVRApplicationError_VRApplicationError_OldApplicationQuitting".enum("", "112"),
		"EVRApplicationError_VRApplicationError_TransitionAborted".enum("", "113"),
		"EVRApplicationError_VRApplicationError_IsTemplate".enum("", "114"),
		"EVRApplicationError_VRApplicationError_BufferTooSmall".enum("", "200"),
		"EVRApplicationError_VRApplicationError_PropertyNotSet".enum("", "201"),
		"EVRApplicationError_VRApplicationError_UnknownProperty".enum("", "202"),
		"EVRApplicationError_VRApplicationError_InvalidParameter".enum("", "203")
	)

	EnumConstant(
		"EVRApplicationProperty",

		"EVRApplicationProperty_VRApplicationProperty_Name_String".enum("", "0"),
		"EVRApplicationProperty_VRApplicationProperty_LaunchType_String".enum("", "11"),
		"EVRApplicationProperty_VRApplicationProperty_WorkingDirectory_String".enum("", "12"),
		"EVRApplicationProperty_VRApplicationProperty_BinaryPath_String".enum("", "13"),
		"EVRApplicationProperty_VRApplicationProperty_Arguments_String".enum("", "14"),
		"EVRApplicationProperty_VRApplicationProperty_URL_String".enum("", "15"),
		"EVRApplicationProperty_VRApplicationProperty_Description_String".enum("", "50"),
		"EVRApplicationProperty_VRApplicationProperty_NewsURL_String".enum("", "51"),
		"EVRApplicationProperty_VRApplicationProperty_ImagePath_String".enum("", "52"),
		"EVRApplicationProperty_VRApplicationProperty_Source_String".enum("", "53"),
		"EVRApplicationProperty_VRApplicationProperty_IsDashboardOverlay_Bool".enum("", "60"),
		"EVRApplicationProperty_VRApplicationProperty_IsTemplate_Bool".enum("", "61"),
		"EVRApplicationProperty_VRApplicationProperty_IsInstanced_Bool".enum("", "62"),
		"EVRApplicationProperty_VRApplicationProperty_LastLaunchTime_Uint64".enum("", "70")
	)

	EnumConstant(
		"EVRApplicationTransitionState",

		"EVRApplicationTransitionState_VRApplicationTransition_None".enum("", "0"),
		"EVRApplicationTransitionState_VRApplicationTransition_OldAppQuitSent".enum("", "10"),
		"EVRApplicationTransitionState_VRApplicationTransition_WaitingForExternalLaunch".enum("", "11"),
		"EVRApplicationTransitionState_VRApplicationTransition_NewAppLaunched".enum("", "20")
	)

	EnumConstant(
		"ChaperoneCalibrationState",

		"ChaperoneCalibrationState_OK".enum("", "1"),
		"ChaperoneCalibrationState_Warning".enum("", "100"),
		"ChaperoneCalibrationState_Warning_BaseStationMayHaveMoved".enum("", "101"),
		"ChaperoneCalibrationState_Warning_BaseStationRemoved".enum("", "102"),
		"ChaperoneCalibrationState_Warning_SeatedBoundsInvalid".enum("", "103"),
		"ChaperoneCalibrationState_Error".enum("", "200"),
		"ChaperoneCalibrationState_Error_BaseStationUninitialized".enum("", "201"),
		"ChaperoneCalibrationState_Error_BaseStationConflict".enum("", "202"),
		"ChaperoneCalibrationState_Error_PlayAreaInvalid".enum("", "203"),
		"ChaperoneCalibrationState_Error_CollisionBoundsInvalid".enum("", "204")
	)

	EnumConstant(
		"EChaperoneConfigFile",

		"EChaperoneConfigFile_Live".enum("", "1"),
		"EChaperoneConfigFile_Temp".enum("", "2")
	)

	EnumConstant(
		"EChaperoneImportFlags",

		"EChaperoneImportFlags_EChaperoneImport_BoundsOnly".enum("", "1")
	)

	EnumConstant(
		"EVRCompositorError",

		"EVRCompositorError_VRCompositorError_None".enum("", "0"),
		"EVRCompositorError_VRCompositorError_RequestFailed".enum("", "1"),
		"EVRCompositorError_VRCompositorError_IncompatibleVersion".enum("", "100"),
		"EVRCompositorError_VRCompositorError_DoNotHaveFocus".enum("", "101"),
		"EVRCompositorError_VRCompositorError_InvalidTexture".enum("", "102"),
		"EVRCompositorError_VRCompositorError_IsNotSceneApplication".enum("", "103"),
		"EVRCompositorError_VRCompositorError_TextureIsOnWrongDevice".enum("", "104"),
		"EVRCompositorError_VRCompositorError_TextureUsesUnsupportedFormat".enum("", "105"),
		"EVRCompositorError_VRCompositorError_SharedTexturesNotSupported".enum("", "106"),
		"EVRCompositorError_VRCompositorError_IndexOutOfRange".enum("", "107"),
		"EVRCompositorError_VRCompositorError_AlreadySubmitted".enum("", "108")
	)

	EnumConstant(
		"VROverlayInputMethod",

		"VROverlayInputMethod_None".enum("", "0"),
		"VROverlayInputMethod_Mouse".enum("", "1")
	)

	EnumConstant(
		"VROverlayTransformType",

		"VROverlayTransformType_VROverlayTransform_Absolute".enum("", "0"),
		"VROverlayTransformType_VROverlayTransform_TrackedDeviceRelative".enum("", "1"),
		"VROverlayTransformType_VROverlayTransform_SystemOverlay".enum("", "2"),
		"VROverlayTransformType_VROverlayTransform_TrackedComponent".enum("", "3")
	)

	EnumConstant(
		"VROverlayFlags",

		"VROverlayFlags_None".enum("", "0"),
		"VROverlayFlags_Curved".enum("", "1"),
		"VROverlayFlags_RGSS4X".enum("", "2"),
		"VROverlayFlags_NoDashboardTab".enum("", "3"),
		"VROverlayFlags_AcceptsGamepadEvents".enum("", "4"),
		"VROverlayFlags_ShowGamepadFocus".enum("", "5"),
		"VROverlayFlags_SendVRScrollEvents".enum("", "6"),
		"VROverlayFlags_SendVRTouchpadEvents".enum("", "7"),
		"VROverlayFlags_ShowTouchPadScrollWheel".enum("", "8"),
		"VROverlayFlags_TransferOwnershipToInternalProcess".enum("", "9"),
		"VROverlayFlags_SideBySide_Parallel".enum("", "10"),
		"VROverlayFlags_SideBySide_Crossed".enum("", "11"),
		"VROverlayFlags_Panorama".enum("", "12"),
		"VROverlayFlags_StereoPanorama".enum("", "13"),
		"VROverlayFlags_SortWithNonSceneOverlays".enum("", "14"),
		"VROverlayFlags_VisibleInDashboard".enum("", "15")
	)

	EnumConstant(
		"VRMessageOverlayResponse",

		"VRMessageOverlayResponse_ButtonPress_0".enum("", "0"),
		"VRMessageOverlayResponse_ButtonPress_1".enum("", "1"),
		"VRMessageOverlayResponse_ButtonPress_2".enum("", "2"),
		"VRMessageOverlayResponse_ButtonPress_3".enum("", "3"),
		"VRMessageOverlayResponse_CouldntFindSystemOverlay".enum("", "4"),
		"VRMessageOverlayResponse_CouldntFindOrCreateClientOverlay".enum("", "5"),
		"VRMessageOverlayResponse_ApplicationQuit".enum("", "6")
	)

	EnumConstant(
		"EGamepadTextInputMode",

		"EGamepadTextInputMode_k_EGamepadTextInputModeNormal".enum("", "0"),
		"EGamepadTextInputMode_k_EGamepadTextInputModePassword".enum("", "1"),
		"EGamepadTextInputMode_k_EGamepadTextInputModeSubmit".enum("", "2")
	)

	EnumConstant(
		"EGamepadTextInputLineMode",

		"EGamepadTextInputLineMode_k_EGamepadTextInputLineModeSingleLine".enum("", "0"),
		"EGamepadTextInputLineMode_k_EGamepadTextInputLineModeMultipleLines".enum("", "1")
	)

	EnumConstant(
		"EOverlayDirection",

		"EOverlayDirection_OverlayDirection_Up".enum("", "0"),
		"EOverlayDirection_OverlayDirection_Down".enum("", "1"),
		"EOverlayDirection_OverlayDirection_Left".enum("", "2"),
		"EOverlayDirection_OverlayDirection_Right".enum("", "3"),
		"EOverlayDirection_OverlayDirection_Count".enum("", "4")
	)

	EnumConstant(
		"EVROverlayIntersectionMaskPrimitiveType",

		"EVROverlayIntersectionMaskPrimitiveType_OverlayIntersectionPrimitiveType_Rectangle".enum("", "0"),
		"EVROverlayIntersectionMaskPrimitiveType_OverlayIntersectionPrimitiveType_Circle".enum("", "1")
	)

	EnumConstant(
		"EVRRenderModelError",

		"EVRRenderModelError_VRRenderModelError_None".enum("", "0"),
		"EVRRenderModelError_VRRenderModelError_Loading".enum("", "100"),
		"EVRRenderModelError_VRRenderModelError_NotSupported".enum("", "200"),
		"EVRRenderModelError_VRRenderModelError_InvalidArg".enum("", "300"),
		"EVRRenderModelError_VRRenderModelError_InvalidModel".enum("", "301"),
		"EVRRenderModelError_VRRenderModelError_NoShapes".enum("", "302"),
		"EVRRenderModelError_VRRenderModelError_MultipleShapes".enum("", "303"),
		"EVRRenderModelError_VRRenderModelError_TooManyVertices".enum("", "304"),
		"EVRRenderModelError_VRRenderModelError_MultipleTextures".enum("", "305"),
		"EVRRenderModelError_VRRenderModelError_BufferTooSmall".enum("", "306"),
		"EVRRenderModelError_VRRenderModelError_NotEnoughNormals".enum("", "307"),
		"EVRRenderModelError_VRRenderModelError_NotEnoughTexCoords".enum("", "308"),
		"EVRRenderModelError_VRRenderModelError_InvalidTexture".enum("", "400")
	)

	EnumConstant(
		"EVRComponentProperty",

		"EVRComponentProperty_VRComponentProperty_IsStatic".enum("", "1"),
		"EVRComponentProperty_VRComponentProperty_IsVisible".enum("", "2"),
		"EVRComponentProperty_VRComponentProperty_IsTouched".enum("", "4"),
		"EVRComponentProperty_VRComponentProperty_IsPressed".enum("", "8"),
		"EVRComponentProperty_VRComponentProperty_IsScrolled".enum("", "16")
	)

	EnumConstant(
		"EVRNotificationType",

		"EVRNotificationType_Transient".enum("", "0"),
		"EVRNotificationType_Persistent".enum("", "1"),
		"EVRNotificationType_Transient_SystemWithUserValue".enum("", "2")
	)

	EnumConstant(
		"EVRNotificationStyle",

		"EVRNotificationStyle_None".enum("", "0"),
		"EVRNotificationStyle_Application".enum("", "100"),
		"EVRNotificationStyle_Contact_Disabled".enum("", "200"),
		"EVRNotificationStyle_Contact_Enabled".enum("", "201"),
		"EVRNotificationStyle_Contact_Active".enum("", "202")
	)

	EnumConstant(
		"EVRSettingsError",

		"EVRSettingsError_VRSettingsError_None".enum("", "0"),
		"EVRSettingsError_VRSettingsError_IPCFailed".enum("", "1"),
		"EVRSettingsError_VRSettingsError_WriteFailed".enum("", "2"),
		"EVRSettingsError_VRSettingsError_ReadFailed".enum("", "3"),
		"EVRSettingsError_VRSettingsError_JsonParseFailed".enum("", "4"),
		"EVRSettingsError_VRSettingsError_UnsetSettingHasNoDefault".enum("", "5")
	)

	EnumConstant(
		"EVRScreenshotError",

		"EVRScreenshotError_VRScreenshotError_None".enum("", "0"),
		"EVRScreenshotError_VRScreenshotError_RequestFailed".enum("", "1"),
		"EVRScreenshotError_VRScreenshotError_IncompatibleVersion".enum("", "100"),
		"EVRScreenshotError_VRScreenshotError_NotFound".enum("", "101"),
		"EVRScreenshotError_VRScreenshotError_BufferTooSmall".enum("", "102"),
		"EVRScreenshotError_VRScreenshotError_ScreenshotAlreadyInProgress".enum("", "108")
	)

	uint32_t(
		"InitInternal",
		"Initializes the connection to the VR hardware.",

		Check(1)..EVRInitError.p.OUT("peError", "a buffer in which to store the error code"),
		EVRApplicationType.IN("eType", "the application type", "EVRApplicationType_\\w+"),

		returnDoc = "a VR interface handles token"
	)

	void(
		"ShutdownInternal",
		"""
		Shuts down the connection to the VR hardware and cleans up the OpenVR API. The ##IVRSystem pointer returned by #InitInternal() will be invalid after
		this call is made.
		"""
	)

	bool(
		"IsHmdPresent",
		"""
		Returns true if the system believes that an HMD is present on the system. This function is much faster than initializing all of OpenVR just to check
		for an HMD. Use it when you have a piece of UI that you want to enable only for users with an HMD.

		This function will return true in situations where #InitInternal() will return $NULL. It is a quick way to eliminate users that have no VR hardware,
		but there are some startup conditions that can only be detected by starting the system.
		"""
	)

	intptr_t(
		"GetGenericInterface",
		"""
		Requests an interface by name from OpenVR. It will return $NULL and pass back an error in {@code peError} if the interface can't be found. It will
		always return $NULL if #InitInternal() has not been called successfully.
		""",

		const..charASCII_p.IN("pchInterfaceVersion", "the interface name and version"),
		Check(1)..EVRInitError.p.OUT("peError", "a buffer in which to store the error code")
	)

	bool(
		"IsRuntimeInstalled",
		"Returns true if the OpenVR runtime is installed on the system."
	)

	// TODO: deprecated?
	charASCII_p(
		"RuntimePath",
		"Returns where the OpenVR runtime is installed."
	)

	// TODO: deprecated?
	bool(
		"IsInterfaceVersionValid",
		"Returns whether the interface of the specified version exists.",

		const..charASCII_p.IN("pchInterfaceVersion", "the interface name and version")
	)

	// TODO: deprecated?
	uint32_t(
		"GetInitToken",
		"Returns a token that represents whether the VR interface handles need to be reloaded."
	)

	const..charASCII_p(
		"GetVRInitErrorAsSymbol",
		"Returns the {@code EVRInitError} enum value as a string. It can be called any time, regardless of whether the VR system is started up.",

		EVRInitError.IN("error", "the error code")
	)

	const..charASCII_p(
		"GetVRInitErrorAsEnglishDescription",
		"""
		Returns an english string for an {@code EVRInitError}.

		Applications should call #GetVRInitErrorAsSymbol() instead and use that as a key to look up their own localized error message. This function may be
		called outside of #InitInternal() / #ShutdownInternal().
		""",

		EVRInitError.IN("error", "the error code")
	)
}