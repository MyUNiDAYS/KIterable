package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableConfig
import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableInitializationOptions
import com.myunidays.kiterable.models.IterableUrlCallback
import com.myunidays.kiterable.models.PayloadData
import platform.Foundation.NSData
import platform.UIKit.UIApplicationLaunchOptionsKey

val shared: IterableApi get() = IterableApi.getInstance()
val optionalShared: IterableApi? get() = IterableApi.getOptionalInstance()

private var internalInstance: IterableApiInterface? = null
actual class IterableApi internal constructor(private val ios: IterableApiInterface) {
    actual companion object {
        actual fun initialize(apiKey: String, initializationOptions: IterableInitializationOptions): IterableApi {
            internalInstance = initializationOptions.iosNativeInstance
            internalInstance!!.initialize(apiKey, initializationOptions.launchOptions, initializationOptions.iterableConfig)
            return instance
        }

        actual fun getInstance(): IterableApi = instance

        fun getOptionalInstance(): IterableApi? = if (internalInstance != null) instance else null

        private val instance: IterableApi by lazy {
            IterableApi(internalInstance!!)
        }
    }
    actual val payloadData: PayloadData?
        get() = ios.getPayloadData()
    actual val inAppManager: IterableInAppManager
        get() = ios.inAppManager
    actual fun setUserId(userId: String?) = ios.setUserId(userId)
    actual fun setEmail(email: String?) = ios.setEmail(email)
    actual fun getPayloadData(key: String): String? = ios.getPayloadData(key)
    actual fun getMessages(): List<IterableInAppMessage> = inAppManager.messages
    actual fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage? = getMessages().firstOrNull(predicate)
    actual fun showMessage(
        message: IterableInAppMessage,
        consume: Boolean,
        onClick: IterableUrlCallback?,
    ) = inAppManager.showMessage(message, consume, onClick)
    actual fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler) = ios.getAndTrackDeepLink(uri, onCallback)
    fun register(token: NSData) = ios.register(token)
    actual fun disableDeviceForCurrentUser() = ios.disableDeviceForCurrentUser()
    actual fun setAutoDisplayPaused(paused: Boolean) = ios.inAppManager.setAutoDisplayPaused(paused)
}

interface IterableApiInterface {
    val inAppManager: IterableInAppManager
    fun initialize(apiKey: String, launchOptions: Map<UIApplicationLaunchOptionsKey, Any>?, config: IterableConfig)
    fun setUserId(userId: String?)
    fun setEmail(email: String?)
    fun getPayloadData(): PayloadData?
    fun getPayloadData(key: String): String?
    fun getMessages(): List<IterableInAppMessage>
    fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler)
    fun register(token: NSData)
    fun disableDeviceForCurrentUser()
}
