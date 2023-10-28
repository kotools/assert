# Kotools Assert - Changelog

All notable changes to this project will be documented in this file.

> The format of this file is based on [Keep a Changelog][keep-a-changelog] and
> this project adheres to [Semantic Versioning][semantic-versioning].

## Types of changes

- `Added` for new features.
- `Changed` for changes in existing functionality.
- `Deprecated` for soon-to-be removed features.
- `Removed` for now removed features.
- `Fixed` for any bug fixes.
- `Security` in case of vulnerabilities.

## Unreleased

## v3.0.2

_Release date: 2022-09-10 | Commits: [v3.0.1...v3.0.2]._

### Fixed

- Correct the publication of artifacts for macOS and MinGW platforms (issue
  [#33]).

## v3.0.1

_Release date: 2022-09-09 | Commits: [v3.0.0...v3.0.1]._

### Fixed

- Correct value in versioning annotations for indicating the first version of
  Kotools Assert where a given declaration has appeared (issue [#26]).

## v3.0.0

_Release date: 2022-09-07 | Commits: [v2.1.0...v3.0.0]._

### Added

- Support for the following platforms: [Kotlin/JS] and
  [Kotlin Native][kotlin-native] for Linux x64, macOS x64 and MinGW x64 systems
  (issue [#21]).
- Functions `assertTrue`, `assertFalse`, `assertEquals`, `assertNotEquals`,
  `assertFails`, `assertFailsWith`, `assertNull` and `assertNotNull` for all
  platforms (issue [#21]).

### Removed

- Deprecated assertions in the `io.github.kotools.assert` package (issue [#19]).

## Version 2.1.0 - 2022/08/03

### Added

- Create and apply the `@SinceKotoolsAssert` annotation on every declaration
  ([#16](https://github.com/kotools/assert/issues/16)).
- Add boolean, nullability, equality and failure assertions in the
  `kotools.assert` package ([#15](https://github.com/kotools/assert/issues/15)).
- Add `@Test` and `@Nested` annotations
  ([#20](https://github.com/kotools/assert/issues/20)).

### Deprecated

Deprecate assertions in the `io.github.kotools.assert` package
([#15](https://github.com/kotools/assert/issues/15)).

## Version 2.0.0 - 2022/04/11

### Removed

Equality and nullability assertions with lazy messages
([#11](https://github.com/kotools/assert/issues/11)).

## Version 1.2.0 - 2022/04/09

### Changed

Split specific failure assertions `assertFailsWith` from untyped failure
assertions `assertFails` ([#5](https://github.com/kotools/assert/issues/5)).

### Deprecated

Equality and nullability assertions with lazy messages
([#5](https://github.com/kotools/assert/issues/5)).

### Removed

Default messages from equality assertions
([#10](https://github.com/kotools/assert/issues/10)).

## Version 1.1.0 - 2022/02/12

### Added

Failure assertions with `assertFails`
([#1](https://github.com/kotools/assert/issues/1)).

## Version 1.0.0 - 2022/02/12

### Added

- Equality assertions with `assertEquals` and `assertNotEquals`.
- Nullability assertions with `assertNull` and `assertNotNull`.

[#19]: https://github.com/kotools/assert/issues/19
[#21]: https://github.com/kotools/assert/issues/21
[#26]: https://github.com/kotools/assert/issues/26
[#33]: https://github.com/kotools/assert/issues/33
[keep-a-changelog]: https://keepachangelog.com/en
[kotlin/js]: https://kotlinlang.org/docs/js-overview.html
[kotlin-native]: https://kotlinlang.org/docs/native-overview.html
[semantic-versioning]: https://semver.org
[v3.0.1...v3.0.2]: https://github.com/kotools/assert/compare/v3.0.1...v3.0.2
[v3.0.0...v3.0.1]: https://github.com/kotools/assert/compare/v3.0.0...v3.0.1
[v2.1.0...v3.0.0]: https://github.com/kotools/assert/compare/v2.1.0...v3.0.0
