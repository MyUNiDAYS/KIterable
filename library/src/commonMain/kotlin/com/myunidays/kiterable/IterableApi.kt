package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterablePushToken
import com.myunidays.kiterable.models.IterableUrlCallback
import com.myunidays.kiterable.models.PayloadData

expect class IterableApi : IterableApiInterface {

    override val payloadData: PayloadData?
    override val inAppManager: IterableInAppManagerInterface

    override fun register(token: IterablePushToken)
    override fun setUserId(userId: String?)
    override fun setEmail(email: String?)
    override fun getPayloadData(key: String): String?
    override fun getMessages(): List<IterableInAppMessage>
    override fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage?
    override fun showMessage(message: IterableInAppMessage, consume: Boolean, onClick: IterableUrlCallback?)
    override fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler)
    override fun disableDeviceForCurrentUser()
    override fun setAutoDisplayPaused(paused: Boolean)
}
