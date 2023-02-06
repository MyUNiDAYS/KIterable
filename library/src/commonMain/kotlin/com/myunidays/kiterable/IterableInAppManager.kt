package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessage

expect class IterableInAppManager {

    val messages: List<IterableInAppMessage>
    val inboxMessages: List<IterableInAppMessage>
    val unreadInboxMessagesCount: Int

    fun setAutoDisplayPaused(paused: Boolean)
    fun showMessage(message: IterableInAppMessage, consume: Boolean, clickCallback: ((String?) -> Unit)?)
}
