package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableUrlCallback

actual interface IterableInAppManagerInterface {
    actual val messages: List<IterableInAppMessage>
    actual val inboxMessages: List<IterableInAppMessage>
    actual val unreadInboxMessagesCount: Int
    actual fun setAutoDisplayPaused(paused: Boolean)
    actual fun showMessage(message: IterableInAppMessage, consume: Boolean, clickCallback: IterableUrlCallback?)
}
