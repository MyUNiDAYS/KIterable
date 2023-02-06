package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.IterableActionHandler
import com.myunidays.kiterable.models.IterableConfig
import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.IterableInitializationOptions
import com.myunidays.kiterable.models.IterableUrlCallback
import com.myunidays.kiterable.models.PayloadData

expect class IterableApi {

    companion object {

        fun initialize(apiKey: String, initializationOptions: IterableInitializationOptions): IterableApi

        fun getInstance(): IterableApi
    }

    val payloadData: PayloadData?
    val inAppManager: IterableInAppManager
    fun setUserId(userId: String?)
    fun setEmail(email: String?)
    fun getPayloadData(key: String): String?
    fun getMessages(): List<IterableInAppMessage>
    fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage?
    fun showMessage(message: IterableInAppMessage, consume: Boolean, onClick: IterableUrlCallback?)
    fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler)
}
