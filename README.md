<h1 align="left">KIterable Kotlin SDK <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/MyUNiDAYS/KIterable?style=flat-square"> <a href="https://git.live"><img src="https://img.shields.io/badge/collaborate-on%20gitlive-blueviolet?style=flat-square"></a></h1>

Iterable + Kotlin = KIterable

The KIterable Kotlin SDK is a Kotlin-first SDK for Iterable. Its API is similar to the <a href="https://github.com/Iterable/iterable-android-sdk">Iterable Android SDK</a> but also supports <b>multiplatform</b> projects, enabling you to use Iterable directly from your common source targeting <strong>iOS</strong> and <strong>Android</strong>.

## Installation

### KMM

```
implementation("com.myunidays:kiterable:0.0.13")
```

## How to use

### KMM

Initialise the lib, in the case for Android, context is ContextWrapper, which you get from application context.

```kotlin
IterableApi.initialize(context, apiKey = "123", config: IterableConfig())
```

Then call the api - its very similiar to the Android api.

```kotlin
IterableApi.getInstance().setUserId("billyBob")
```

### iOS

When using the library in iOS, you MUST implement the IterableApiInterface

```swift
class KiterableApi: IterableApiInterface {
```

Then you can call this file with the iterable api requests.

```swift
kiterableApi.setUserId(userId: "billyBob")
```

## Contributing

This project is set up as an open source project. As such, if there are any suggestions that you have for features, for improving the code itself, or you have come across any problems; you can raise them and/or suggest changes in implementation.

If you are interested in contributing to this codebase, please follow the contributing guidelines. This contains guides on both contributing directly and raising feature requests or bug reports. Please adhere to our code of conduct when doing any of the above.
