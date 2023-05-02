package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterableUrlCallback

expect interface IterableInAppManagerInterface {
    val messages: List<IterableInAppMessageInterface>
    val inboxMessages: List<IterableInAppMessageInterface>
    val unreadInboxMessagesCount: Int
    fun setAutoDisplayPaused(paused: Boolean)
    fun showMessage(message: IterableInAppMessageInterface, consume: Boolean, clickCallback: IterableUrlCallback?)
}
