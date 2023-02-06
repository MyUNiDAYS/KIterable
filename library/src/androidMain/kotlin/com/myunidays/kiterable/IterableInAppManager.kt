package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableUrlCallback

actual class IterableInAppManager internal constructor(private val android: com.iterable.iterableapi.IterableInAppManager) {
    actual val messages: List<IterableInAppMessage>
        get() = android.messages.map { IterableInAppMessage(it) }

    actual val inboxMessages: List<IterableInAppMessage>
        get() = android.inboxMessages.map { IterableInAppMessage(it) }
    actual val unreadInboxMessagesCount: Int
        get() = android.unreadInboxMessagesCount

    actual fun setAutoDisplayPaused(paused: Boolean) = android.setAutoDisplayPaused(paused)

    actual fun showMessage(
        message: IterableInAppMessage,
        consume: Boolean,
        clickCallback: IterableUrlCallback?,
    ) {
        android.showMessage(android.messages.first { it.messageId == message.messageId }, consume) { url ->
            url?.let {
                clickCallback?.invoke(it.toString())
            }
        }
    }
}
