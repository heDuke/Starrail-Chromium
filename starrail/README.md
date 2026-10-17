# Starrail Chromium source module

This public repository contains the Chromium source available in the local
Starrail development checkout, pinned to **153.0.8010.27**,
`ac9b84a0b321cc741e9eb650f29e7177b68f0f48`.

The import is in progress. `source-manifest.json` records the actual local
commits of Chromium and every checked-out Git dependency. Dependencies are
vendored as ordinary files so their source can be browsed here. Upstream
dependencies that were absent locally, including optional Google-internal
dependencies, are listed as Git links in the manifest; their source is not
claimed to be included. Original Git link configuration is archived in
`upstream-gitmodules`; use the upstream `DEPS` for platform-specific tools.

Build outputs, caches, Git databases, and downloaded compiler/SDK tools are
excluded. Large upstream source/test fixtures use Git LFS. Installed npm
source packages will be imported separately.

The private Starrail application references `starrail/engine` as its Android
library module. That library currently defines the embedding interface and
an explicit unavailable placeholder; it does not yet render webpages.
The Chromium ContentShell Android ARM build is being prepared separately.

## License

Chromium's root `LICENSE` and third-party license files remain unchanged.
They permit use, modification, and redistribution under their respective
terms. Starrail-authored code in this directory uses the BSD 3-Clause license
in `LICENSE`. These terms do not replace third-party licenses or grant rights
to trademarks, proprietary services, or absent internal source.

## Checkout

Clone this repository with Git LFS installed, then run `git lfs pull` to fetch
large fixtures. The private application pins a specific public module commit.
Subsequent upstream synchronization must preserve the pinned manifest and
explicitly review any source changes.
