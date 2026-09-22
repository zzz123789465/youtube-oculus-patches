# YouTube Oculus Patches

Experimental, open-source patches for the Meta Quest build of YouTube VR. This project is compatible with Morphe but is independent from, and is not endorsed by, the Morphe project or Google.

[繁體中文說明](README.zh-TW.md) · [Installation guide](docs/INSTALLATION.md) · [Technical notes](docs/TECHNICAL.md)

> [!IMPORTANT]
> This repository distributes patch source code only. It does not distribute original or pre-patched YouTube APK files. Obtain the original app through a source you are legally permitted to use.

## Add this source to Morphe

[Add YouTube Oculus Patches to Morphe](https://morphe.software/add-source?github=zzz123789465/youtube-oculus-patches)

Development releases are published from the `dev` branch. Enable pre-releases for this patch source in Morphe Manager while the target remains experimental.

## Supported target

| App | Package | Version | Version code | ABI | Status |
| --- | --- | --- | ---: | --- | --- |
| YouTube VR for Meta Quest | `com.google.android.apps.youtube.vr.oculus` | `1.85.11` | `18511000` | `arm64-v8a` | Experimental |

The original APK must be signed with Google's expected certificate. The patch metadata checks its SHA-256 signing certificate before patching.

## Patches

<!-- PATCHES_START EXPANDED -->

<!-- Do not edit this block manually. The release workflow generates it. -->

The patch list will be generated after the first release.

<!-- PATCHES_END -->

### Block video ads

Stops the two in-player advertising paths used for ad trigger dispatch and `PlayerBytes` ad-layout construction. These fingerprints are adapted from Morphe's existing YouTube ad patch and uniquely match YouTube VR `1.85.11`.

The more invasive synchronous `AdBreak` fetch hook used during initial research is deliberately excluded from the public release because full playback regression testing is not yet complete.

## Validation status

- Patch bundle builds successfully and targets only the exact Quest package, version, version code, ABI, and original signing certificate.
- Five DEX files and 27,462 classes passed bytecode and cross-DEX hierarchy validation in the research build.
- A patched build cold-launched successfully on a Meta Quest 3S running Android 14 / API 34.
- OpenXR accepted the locally signed build, and no app crash, ANR, or verifier error was observed during the launch test.
- Wider testing of signed-in playback, 180°/360° content, and real ad inventory is still required.

Please report playback results through [GitHub Issues](https://github.com/zzz123789465/youtube-oculus-patches/issues) without attaching any APK.

## Building

```text
./gradlew :patches:buildAndroid
```

The bundle is written to `patches/build/libs/patches-*.mpp`. For complete patching and installation instructions, see [docs/INSTALLATION.md](docs/INSTALLATION.md).

## Contributing

Work on the `dev` branch and use semantic commit prefixes (`feat:`, `fix:`, or `chore:`). See [CONTRIBUTING.md](CONTRIBUTING.md).

## License and attribution

Licensed under [GPL-3.0](LICENSE), subject to the additional notices in [NOTICE](NOTICE). Fingerprints derived from Morphe retain their original attribution. “Morphe” is used only to describe compatibility and does not imply authorship or endorsement.
