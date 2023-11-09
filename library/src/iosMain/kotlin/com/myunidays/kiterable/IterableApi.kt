package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterablePushToken
import com.myunidays.kiterable.models.IterableUrlCallback
import com.myunidays.kiterable.models.PayloadData

actual class IterableApi internal constructor(private val ios: IosIterableApiInterface) : IterableApiInterface {
    actual override val payloadData: PayloadData?
        get() = ios.getPayloadData()
    actual override val inAppManager: IterableInAppManagerInterface
        get() = ios.inAppManager

    actual override fun register(token: IterablePushToken) = ios.register(token)
    actual override fun setUserId(userId: String?) = ios.setUserId(userId)
    actual override fun setEmail(email: String?) = ios.setEmail(email)
    actual override fun getPayloadData(key: String): String? = ios.getPayloadData(key)
    actual override fun getMessages(): List<IterableInAppMessageInterface> = inAppManager.messages
    actual override fun getMessage(predicate: (IterableInAppMessageInterface) -> Boolean):
        IterableInAppMessageInterface? = getMessages().firstOrNull(predicate)
    actual override fun showMessage(
        message: IterableInAppMessageInterface,
        consume: Boolean,
        onClick: IterableUrlCallback?,
    ) = inAppManager.showMessage(message, consume, onClick)
    actual override fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler) =
        ios.getAndTrackDeepLink(uri, onCallback)
    actual override fun disableDeviceForCurrentUser() = ios.disableDeviceForCurrentUser()
    actual override fun setAutoDisplayPaused(paused: Boolean) = ios.inAppManager.setAutoDisplayPaused(paused)
}
