package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableUrlCallback

expect class IterableInAppManager : IterableInAppManagerInterface {
    override val messages: List<IterableInAppMessage>
    override val inboxMessages: List<IterableInAppMessage>
    override val unreadInboxMessagesCount: Int
    override fun setAutoDisplayPaused(paused: Boolean)
    override fun showMessage(message: IterableInAppMessage, consume: Boolean, clickCallback: IterableUrlCallback?)
}
