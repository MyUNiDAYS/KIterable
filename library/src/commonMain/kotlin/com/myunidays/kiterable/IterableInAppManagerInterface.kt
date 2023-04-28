package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableUrlCallback

expect interface IterableInAppManagerInterface {
    val messages: List<IterableInAppMessage>
    val inboxMessages: List<IterableInAppMessage>
    val unreadInboxMessagesCount: Int
    fun setAutoDisplayPaused(paused: Boolean)
    fun showMessage(message: IterableInAppMessage, consume: Boolean, clickCallback: IterableUrlCallback?)
}
