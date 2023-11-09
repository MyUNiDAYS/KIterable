package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterableUrlCallback

actual interface IterableInAppManagerInterface {
    actual val messages: List<IterableInAppMessageInterface>
    actual val inboxMessages: List<IterableInAppMessageInterface>
    actual val unreadInboxMessagesCount: Int
    actual fun setAutoDisplayPaused(paused: Boolean)
    actual fun showMessage(
        message: IterableInAppMessageInterface,
        consume: Boolean,
        clickCallback: IterableUrlCallback?
    )
}
