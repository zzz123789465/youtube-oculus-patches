/*
 * Copyright 2026 Morphe.
 * https://github.com/MorpheApp/morphe-patches
 *
 * Adapted for the Meta Quest build of YouTube VR.
 * See the included NOTICE file for GPLv3 Section 7 terms.
 */

package app.youtubeoculus.patches.youtubevr.ad

import app.morphe.patcher.extensions.InstructionExtensions.addInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.youtubeoculus.patches.shared.Constants.YOUTUBE_VR_COMPATIBILITY

@Suppress("unused")
val blockVideoAdsPatch = bytecodePatch(
    name = "Block video ads",
    description = "Blocks in-player pre-roll and mid-roll video ads in YouTube VR for Meta Quest.",
    default = true,
) {
    compatibleWith(YOUTUBE_VR_COMPATIBILITY)

    execute {
        setOf(
            LoadVideoAdsFingerprint,
            PlayerBytesAdLayoutFingerprint,
        ).forEach { fingerprint ->
            fingerprint.method.addInstruction(0, "return-void")
        }
    }
}
