package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableConfig
import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.PayloadData
import platform.Foundation.NSData
import platform.UIKit.UIApplicationLaunchOptionsKey

interface IosIterableApiInterface {
    val inAppManager: IterableInAppManager
    fun initialize(apiKey: String, launchOptions: Map<UIApplicationLaunchOptionsKey, Any>?, config: IterableConfig)
    fun setUserId(userId: String?)
    fun setEmail(email: String?)
    fun getPayloadData(): PayloadData?
    fun getPayloadData(key: String): String?
    fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler)
    fun register(token: NSData)
    fun disableDeviceForCurrentUser()
}
