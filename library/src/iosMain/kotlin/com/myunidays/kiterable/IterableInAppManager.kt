package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterableUrlCallback

actual class IterableInAppManager constructor(
    private val ios: IosIterableInAppManagerInterface
) : IterableInAppManagerInterface {

    actual override val messages: List<IterableInAppMessageInterface>
        get() = ios.messages.map { IterableInAppMessage(it) }

    actual override val inboxMessages: List<IterableInAppMessageInterface>
        get() = ios.inboxMessages.map { IterableInAppMessage(it) }

    actual override val unreadInboxMessagesCount: Int
        get() = ios.unreadInboxMessagesCount

    actual override fun setAutoDisplayPaused(paused: Boolean) {
        ios.autoDisplayPaused = paused
    }

    actual override fun showMessage(
        message: IterableInAppMessageInterface,
        consume: Boolean,
        clickCallback: IterableUrlCallback?,
    ) = ios.showMessage(ios.messages.first { it.messageId == message.messageId }, consume, clickCallback)
}
