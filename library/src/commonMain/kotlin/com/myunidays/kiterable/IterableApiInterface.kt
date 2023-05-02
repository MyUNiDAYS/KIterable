package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableInAppMessageInterface
import com.myunidays.kiterable.models.IterableInitializationOptions
import com.myunidays.kiterable.models.IterablePushToken
import com.myunidays.kiterable.models.IterableUrlCallback
import com.myunidays.kiterable.models.PayloadData

expect interface IterableApiInterface {

    companion object {
        fun initialize(
            apiKey: String,
            initializationOptions: IterableInitializationOptions
        ): IterableApiInterface

        fun getInstance(): IterableApiInterface
    }

    val payloadData: PayloadData?
    val inAppManager: IterableInAppManagerInterface
    fun register(token: IterablePushToken)
    fun setUserId(userId: String?)
    fun setEmail(email: String?)
    fun getPayloadData(key: String): String?
    fun getMessages(): List<IterableInAppMessageInterface>
    fun getMessage(predicate: (IterableInAppMessageInterface) -> Boolean): IterableInAppMessageInterface?
    fun showMessage(
        message: IterableInAppMessageInterface,
        consume: Boolean,
        onClick: IterableUrlCallback?
    )
    fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler)
    fun disableDeviceForCurrentUser()
    fun setAutoDisplayPaused(paused: Boolean)
}
