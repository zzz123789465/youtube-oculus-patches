# Contributing

## Branches

- Make normal changes on `dev`.
- Stable releases are produced by merging `dev` into `main` without squashing.
- Do not force-push release commits.

## Commits

Use one of the semantic prefixes expected by the release workflow:

- `feat:` for a user-visible feature.
- `fix:` for a user-visible correction.
- `chore:` for maintenance that should not create release notes.

## Pull requests

1. Keep APKs, keystores, signing keys, and decompiled proprietary source out of commits.
2. Explain the target package, exact version, version code, ABI, and signer used for testing.
3. Prefer fingerprints based on multiple stable characteristics and document their uniqueness.
4. Build with `./gradlew :patches:buildAndroid`.
5. Test cold launch and relevant playback behavior on a Quest device when possible.
6. Include sanitized logs for failures; never attach an original or patched APK.

By contributing, you agree that your contribution is licensed under this repository's GPL-3.0 license and applicable NOTICE terms.
