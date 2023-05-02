package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterableUrlCallback

expect class IterableInAppManager : IterableInAppManagerInterface {
    override val messages: List<IterableInAppMessageInterface>
    override val inboxMessages: List<IterableInAppMessageInterface>
    override val unreadInboxMessagesCount: Int
    override fun setAutoDisplayPaused(paused: Boolean)
    override fun showMessage(
        message: IterableInAppMessageInterface,
        consume: Boolean,
        clickCallback: IterableUrlCallback?
    )
}
