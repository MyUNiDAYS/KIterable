package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableInAppMessageInterface
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
    override fun getMessages(): List<IterableInAppMessageInterface>
    override fun getMessage(predicate: (IterableInAppMessageInterface) -> Boolean): IterableInAppMessageInterface?
    override fun showMessage(message: IterableInAppMessageInterface, consume: Boolean, onClick: IterableUrlCallback?)
    override fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler)
    override fun disableDeviceForCurrentUser()
    override fun setAutoDisplayPaused(paused: Boolean)
}
