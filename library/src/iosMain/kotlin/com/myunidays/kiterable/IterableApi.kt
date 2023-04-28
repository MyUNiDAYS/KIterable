package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableUrlCallback
import com.myunidays.kiterable.models.PayloadData
import platform.Foundation.NSData

actual class IterableApi internal constructor(private val ios: IosIterableApiInterface) : IterableApiInterface {
    actual override val payloadData: PayloadData?
        get() = ios.getPayloadData()
    actual override val inAppManager: IterableInAppManagerInterface
        get() = ios.inAppManager
    actual override fun setUserId(userId: String?) = ios.setUserId(userId)
    actual override fun setEmail(email: String?) = ios.setEmail(email)
    actual override fun getPayloadData(key: String): String? = ios.getPayloadData(key)
    actual override fun getMessages(): List<IterableInAppMessage> = inAppManager.messages
    actual override fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage? = getMessages().firstOrNull(predicate)
    actual override fun showMessage(
        message: IterableInAppMessage,
        consume: Boolean,
        onClick: IterableUrlCallback?,
    ) = inAppManager.showMessage(message, consume, onClick)
    actual override fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler) = ios.getAndTrackDeepLink(uri, onCallback)
    fun register(token: NSData) = ios.register(token)
    actual override fun disableDeviceForCurrentUser() = ios.disableDeviceForCurrentUser()
    actual override fun setAutoDisplayPaused(paused: Boolean) = ios.inAppManager.setAutoDisplayPaused(paused)
}
