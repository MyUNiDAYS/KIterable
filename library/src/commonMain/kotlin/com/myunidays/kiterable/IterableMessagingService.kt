package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.RemoteMessage

expect object IterableMessagingService {
    fun isGhostPush(message: RemoteMessage): Boolean
    fun handleMessageReceived(context: Context, message: RemoteMessage): Boolean

    fun handleTokenRefresh()
}
