package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableInAppMessageImpl
import com.myunidays.kiterable.models.IterableUrlCallback

actual class IterableInAppManager constructor(private val ios: IterableInAppManagerInterface) {
    actual val messages: List<IterableInAppMessage>
        get() = ios.messages.map { IterableInAppMessage(it) }

    actual val inboxMessages: List<IterableInAppMessage>
        get() = ios.inboxMessages.map { IterableInAppMessage(it) }
    actual val unreadInboxMessagesCount: Int
        get() = ios.unreadInboxMessagesCount

    actual fun setAutoDisplayPaused(paused: Boolean) {
        ios.autoDisplayPaused = paused
    }

    actual fun showMessage(
        message: IterableInAppMessage,
        consume: Boolean,
        clickCallback: IterableUrlCallback?,
    ) = ios.showMessage(ios.messages.first { it.messageId == message.messageId }, consume, clickCallback)
}

interface IterableInAppManagerInterface {
    val messages: List<IterableInAppMessageImpl>
    val inboxMessages: List<IterableInAppMessageImpl>
    val unreadInboxMessagesCount get() = inboxMessages.count() // needs to be unread ones
    var autoDisplayPaused: Boolean

    fun showMessage(message: IterableInAppMessageImpl, consume: Boolean, clickCallback: IterableUrlCallback?)
}
