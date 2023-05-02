package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterablePushToken
import com.myunidays.kiterable.models.IterableUrlCallback
import com.myunidays.kiterable.models.PayloadData

actual class IterableApi internal constructor(
    private val android: com.iterable.iterableapi.IterableApi
) : IterableApiInterface {
    actual override val payloadData: PayloadData?
        get() = android.payloadData

    actual override val inAppManager: IterableInAppManagerInterface
        get() = IterableInAppManager(android.inAppManager)

    actual override fun register(token: IterablePushToken) = android.registerDeviceToken(token)

    actual override fun setUserId(userId: String?) = android.setUserId(userId)

    actual override fun setEmail(email: String?) = android.setEmail(email)

    actual override fun getPayloadData(key: String): String? = android.getPayloadData(key)

    actual override fun getMessages(): List<IterableInAppMessageInterface> = inAppManager.messages

    actual override fun getMessage(predicate: (IterableInAppMessageInterface) -> Boolean): IterableInAppMessageInterface? = getMessages().firstOrNull(predicate)

    actual override fun showMessage(
        message: IterableInAppMessageInterface,
        consume: Boolean,
        onClick: IterableUrlCallback?,
    ) = inAppManager.showMessage(message, consume, onClick)

    actual override fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler) =
        android.getAndTrackDeepLink(uri) { onCallback(it) }

    actual override fun disableDeviceForCurrentUser() = android.disablePush()

    actual override fun setAutoDisplayPaused(paused: Boolean) = inAppManager.setAutoDisplayPaused(paused)
}
