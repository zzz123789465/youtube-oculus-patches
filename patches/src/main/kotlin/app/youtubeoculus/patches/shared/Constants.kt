/*
 * SPDX-License-Identifier: GPL-3.0-only
 */

package app.youtubeoculus.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility
import app.morphe.patcher.patch.SupportedAbi

object Constants {
    val YOUTUBE_VR_COMPATIBILITY = Compatibility(
        name = "YouTube VR (Meta Quest)",
        packageName = "com.google.android.apps.youtube.vr.oculus",
        apkFileType = ApkFileType.APK_REQUIRED,
        appIconColor = 0xFF0033,
        signatures = setOf(
            "8027b7a6ab434237c401541aa1b9dfc99a8fcadc7e5e3a27402a318825b34754",
        ),
        targets = listOf(
            AppTarget(
                version = "1.85.11",
                versionCodes = mapOf(
                    SupportedAbi.ARM64_V8A to 18511000,
                ),
                isExperimental = true,
                minSdk = 26,
                description = "Cold-launch tested on Meta Quest 3S; ad playback still needs wider testing.",
            ),
        ),
    )
}
