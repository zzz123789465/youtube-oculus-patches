# Installation guide

## Requirements

- A Meta Quest headset with Developer Mode and USB debugging enabled.
- The unmodified YouTube VR `1.85.11` APK for package `com.google.android.apps.youtube.vr.oculus`, version code `18511000`.
- Morphe Manager or Morphe Desktop.
- Enough free space to unpack and rebuild an approximately 113 MB APK.

Only use an APK you are legally permitted to obtain and back up. This repository does not provide YouTube binaries.

## Morphe Manager

1. Add this source: `https://morphe.software/add-source?github=zzz123789465/youtube-oculus-patches`.
2. Enable pre-releases for the source while the patch is experimental.
3. Select the original YouTube VR `1.85.11` APK.
4. Enable **Block video ads** and start patching.
5. Export the resulting APK and install it using ADB or your normal Quest sideloading tool.

## Morphe Desktop

Download the `.mpp` bundle from this repository's GitHub release, then run:

```text
java -jar morphe-desktop-<version>-all.jar patch \
  --patches patches-<version>.mpp \
  --out YouTubeVR_1.85.11_patched.apk \
  YouTube_1.85.11.apk
```

The exact Desktop filename and bundle version vary by release.

## Installing on Quest

The patched APK is signed with a different key and cannot update the official Store build in place. Uninstalling clears the app's local data and signed-in state.

```text
adb uninstall com.google.android.apps.youtube.vr.oculus
adb install YouTubeVR_1.85.11_patched.apk
```

Open YouTube VR from the Quest app library or the Unknown Sources section. Test normal, 180°, and 360° videos, seeking, returning to the home screen, and several videos that normally contain pre-roll or mid-roll ads.

## Troubleshooting

- **`INSTALL_FAILED_UPDATE_INCOMPATIBLE`**: The official build is still installed. Uninstall it first.
- **Patch reports an incompatible APK**: Confirm package, version `1.85.11`, version code `18511000`, ARM64 ABI, and the original Google signature.
- **Black screen or endless loading**: Force-stop the app, relaunch once, then capture `adb logcat` and open an issue. Do not attach the APK.
- **Returning to the official app**: Uninstall the patched build, then reinstall YouTube VR from the Meta Quest Store.

## Security

Prefer bundles produced by this repository's GitHub Actions release workflow. Verify the release provenance/attestation when available. Never install a pre-patched APK from an unknown third party.
