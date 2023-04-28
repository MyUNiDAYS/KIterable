package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessageImpl
import com.myunidays.kiterable.models.IterableUrlCallback

interface IosIterableInAppManagerInterface {
    val messages: List<IterableInAppMessageImpl>
    val inboxMessages: List<IterableInAppMessageImpl>
    val unreadInboxMessagesCount get() = inboxMessages.count() // needs to be unread ones
    var autoDisplayPaused: Boolean

    fun showMessage(message: IterableInAppMessageImpl, consume: Boolean, clickCallback: IterableUrlCallback?)
}
