package com.myunidays.kiterable.models

import com.myunidays.kiterable.IterableApiInterface
import platform.UIKit.UIApplicationLaunchOptionsKey

actual data class IterableInitializationOptions(
    actual val iterableConfig: IterableConfig,
    val launchOptions: Map<UIApplicationLaunchOptionsKey, Any>,
    val iosNativeInstance: IterableApiInterface
)
