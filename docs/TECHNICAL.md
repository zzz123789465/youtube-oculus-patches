# Technical notes

## Target identity

- Package: `com.google.android.apps.youtube.vr.oculus`
- Version: `1.85.11`
- Version code: `18511000`
- Minimum SDK: 26
- ABI: `arm64-v8a`
- Original signer SHA-256: `8027b7a6ab434237c401541aa1b9dfc99a8fcadc7e5e3a27402a318825b34754`
- Original APK SHA-256 used during research: `F064F384392BD2F76956636945958C77BCC50B19CC4AF051BB6BABABA67593D6`

## Patch design

The public patch inserts `return-void` at the start of two methods located by stable diagnostic strings:

1. The activated ad-trigger and ping dispatcher, identified by both `TriggerBundle doesn't have the required metadata specified by the trigger ` and `Ping migration no associated ping bindings for activated trigger: `.
2. The `PlayerBytes` advertising layout builder, identified by `Bootstrapped layout construction resulted in non PlayerBytesLayout. PlayerAds count: `.

Both fingerprints are adapted from Morphe's phone YouTube ad patch. A full scan of all five DEX files in YouTube VR `1.85.11` found exactly one match for each fingerprint.

## Excluded research hook

Research also identified the synchronous `AdBreakFetcher` method. Its exception path and known caller handle a `null` result, but forcing every request to return `null` is more invasive and may cause retry loops or loading regressions in untested callers. It is intentionally excluded until broader playback testing supports it.

## Validation performed

- Morphe reported that the research patch applied successfully.
- Five DEX files compiled.
- 27,462 classes passed DEX verification and cross-DEX hierarchy checks.
- Decompiled output confirmed the intended early returns.
- The rebuilt APK passed ZIP, alignment, and APK Signature Scheme v2/v3 verification.
- The application cold-launched on Meta Quest 3S / Android 14 and entered an immersive OpenXR activity without an app crash, ANR, or verifier failure during the observation window.

This is not a claim that every playback and advertising path is validated. The target remains marked experimental until repeatable playback reports are available.
