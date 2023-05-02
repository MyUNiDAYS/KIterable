package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterableInitializationOptions
import com.myunidays.kiterable.models.IterablePushToken
import com.myunidays.kiterable.models.IterableUrlCallback
import com.myunidays.kiterable.models.PayloadData

actual interface IterableApiInterface {

    actual companion object {
        actual fun initialize(apiKey: String, initializationOptions: IterableInitializationOptions): IterableApiInterface {
            com.iterable.iterableapi.IterableApi.initialize(initializationOptions.context.applicationContext, apiKey, initializationOptions.iterableConfig)
            return internalInstance
        }
        fun initialize(context: Context, apiKey: String, config: IterableConfigBuilder): IterableApiInterface =
            initialize(apiKey, IterableInitializationOptions(iterableConfig = config.build(), context))

        actual fun getInstance(): IterableApiInterface = internalInstance

        private val internalInstance: IterableApiInterface by lazy {
            IterableApi(com.iterable.iterableapi.IterableApi.getInstance())
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
