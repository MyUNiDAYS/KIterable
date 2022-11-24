package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.IterableConfig
import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.PayloadData

actual class IterableApi internal constructor(private val android: com.iterable.iterableapi.IterableApi) {
    actual companion object {
        actual fun initialize(context: Context, apiKey: String, config: IterableConfig): IterableApi {
            com.iterable.iterableapi.IterableApi.initialize(context.applicationContext, apiKey, config)
            return internalInstance
        }
        fun initialize(context: Context, apiKey: String, config: IterableConfigBuilder): IterableApi =
            initialize(context, apiKey, config.build())

        actual fun getInstance(): IterableApi = internalInstance

        private val internalInstance: IterableApi by lazy {
            IterableApi(com.iterable.iterableapi.IterableApi.getInstance())
        }
    }
    actual val payloadData: PayloadData?
        get() = android.payloadData
    actual val inAppManager: IterableInAppManager
        get() = IterableInAppManager(android.inAppManager)

    actual fun setUserId(userId: String?) = android.setUserId(userId)

    actual fun setEmail(email: String?) = android.setEmail(email)
    actual fun getPayloadData(key: String): String? = android.getPayloadData(key)

    actual fun getMessages(): List<IterableInAppMessage> = inAppManager.messages
    actual fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage? = getMessages().firstOrNull(predicate)
    actual fun showMessage(
        message: IterableInAppMessage,
        consume: Boolean,
        onClick: IterableHelper.IterableUrlCallback,
    ) = inAppManager.showMessage(message, consume, onClick)

    actual fun getAndTrackDeepLink(uri: String, onCallback: IterableHelper.IterableActionHandler?) =
        android.getAndTrackDeepLink(uri) { onCallback?.execute(it) }
}
