package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterableInitializationOptions
import com.myunidays.kiterable.models.IterablePushToken
import com.myunidays.kiterable.models.IterableUrlCallback
import com.myunidays.kiterable.models.PayloadData

val shared: IterableApiInterface get() = IterableApiInterface.getInstance()
val optionalShared: IterableApiInterface? get() = IterableApiInterface.getOptionalInstance()

private var internalInstance: IosIterableApiInterface? = null
actual interface IterableApiInterface {

    actual companion object {
        actual fun initialize(apiKey: String, initializationOptions: IterableInitializationOptions): IterableApiInterface {
            internalInstance = initializationOptions.iosNativeInstance
            internalInstance!!.initialize(apiKey, initializationOptions.launchOptions, initializationOptions.iterableConfig)
            return instance
        }

        actual fun getInstance(): IterableApiInterface = instance

        fun getOptionalInstance(): IterableApiInterface? = if (internalInstance != null) instance else null

        private val instance: IterableApiInterface by lazy {
            IterableApi(internalInstance!!)
        }
    }

    actual val payloadData: PayloadData?
    actual val inAppManager: IterableInAppManagerInterface
    actual fun register(token: IterablePushToken)
    actual fun setUserId(userId: String?)
    actual fun setEmail(email: String?)
    actual fun getPayloadData(key: String): String?
    actual fun getMessages(): List<IterableInAppMessageInterface>
    actual fun getMessage(predicate: (IterableInAppMessageInterface) -> Boolean): IterableInAppMessageInterface?
    actual fun showMessage(message: IterableInAppMessageInterface, consume: Boolean, onClick: IterableUrlCallback?)
    actual fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler)
    actual fun disableDeviceForCurrentUser()
    actual fun setAutoDisplayPaused(paused: Boolean)
}
