package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableInitializationOptions
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
    actual fun setUserId(userId: String?)
    actual fun setEmail(email: String?)
    actual fun getPayloadData(key: String): String?
    actual fun getMessages(): List<IterableInAppMessage>
    actual fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage?
    actual fun showMessage(message: IterableInAppMessage, consume: Boolean, onClick: IterableUrlCallback?)
    actual fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler)
    actual fun disableDeviceForCurrentUser()
    actual fun setAutoDisplayPaused(paused: Boolean)
}
