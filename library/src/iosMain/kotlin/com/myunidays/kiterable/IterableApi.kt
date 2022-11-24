package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.IterableConfig
import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.PayloadData
import platform.Foundation.NSData
import platform.UIKit.UIApplicationLaunchOptionsKey

val shared: IterableApi get() = IterableApi.getInstance()
val optionalShared: IterableApi? get() = IterableApi.getOptionalInstance()

private var internalInstance: IterableApiInterface? = null
actual class IterableApi internal constructor(private val ios: IterableApiInterface) {
    actual companion object {
        actual fun initialize(context: Context, apiKey: String, config: IterableConfig): IterableApi {
            throw Error("iOS needs to use the initialize method with IterableApiImpl being passed.")
        }

        fun initialize(ios: IterableApiInterface, apiKey: String, launchOptions: Map<UIApplicationLaunchOptionsKey, Any>, config: IterableConfig): IterableApi {
            internalInstance = ios
            internalInstance!!.initialize(apiKey, launchOptions, config)
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
        onClick: IterableHelper.IterableUrlCallback,
    ) = inAppManager.showMessage(message, consume, onClick)
    actual fun getAndTrackDeepLink(uri: String, onCallback: IterableHelper.IterableActionHandler?) = ios.getAndTrackDeepLink(uri, onCallback)
    fun register(token: NSData) = ios.register(token)
    fun disableDeviceForCurrentUser() = ios.disableDeviceForCurrentUser()
}

interface IterableApiInterface {
    val inAppManager: IterableInAppManager
    fun initialize(apiKey: String, launchOptions: Map<UIApplicationLaunchOptionsKey, Any>?, config: IterableConfig)
    fun setUserId(userId: String?)
    fun setEmail(email: String?)
    fun getPayloadData(): PayloadData?
    fun getPayloadData(key: String): String?
    fun getMessages(): List<IterableInAppMessage>
    fun getAndTrackDeepLink(uri: String, onCallback: IterableHelper.IterableActionHandler?)
    fun register(token: NSData)
    fun disableDeviceForCurrentUser()
}
