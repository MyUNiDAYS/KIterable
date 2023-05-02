package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterableUrlCallback

actual class IterableInAppManager internal constructor(
    private val android: com.iterable.iterableapi.IterableInAppManager
) : IterableInAppManagerInterface {

    actual override val messages: List<IterableInAppMessageInterface>
        get() = android.messages.map { IterableInAppMessage(it) }

    actual override val inboxMessages: List<IterableInAppMessageInterface>
        get() = android.inboxMessages.map { IterableInAppMessage(it) }

    actual override val unreadInboxMessagesCount: Int
        get() = android.unreadInboxMessagesCount

    actual override fun setAutoDisplayPaused(paused: Boolean) = android.setAutoDisplayPaused(paused)

    actual override fun showMessage(
        message: IterableInAppMessageInterface,
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
