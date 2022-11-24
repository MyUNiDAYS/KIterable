package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.IterableConfig
import com.myunidays.kiterable.models.IterableInAppMessage
import com.myunidays.kiterable.models.PayloadData

expect class IterableApi {

    companion object {

        fun initialize(context: Context, apiKey: String, config: IterableConfig): IterableApi

        fun getInstance(): IterableApi
    }

    val payloadData: PayloadData?
    val inAppManager: IterableInAppManager
    fun setUserId(userId: String?)
    fun setEmail(email: String?)
    fun getPayloadData(key: String): String?
    fun getMessages(): List<IterableInAppMessage>
    fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage?
    fun showMessage(message: IterableInAppMessage, consume: Boolean, onClick: IterableHelper.IterableUrlCallback)
    fun getAndTrackDeepLink(uri: String, onCallback: IterableHelper.IterableActionHandler?)
}
