package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.RemoteMessage

actual object IterableMessagingService {
    actual fun isGhostPush(message: RemoteMessage) =
        com.iterable.iterableapi.IterableFirebaseMessagingService.isGhostPush(message)

    actual fun handleMessageReceived(
        context: Context,
        message: RemoteMessage,
    ) = com.iterable.iterableapi.IterableFirebaseMessagingService.handleMessageReceived(context, message)

    actual fun handleTokenRefresh() =
        com.iterable.iterableapi.IterableFirebaseMessagingService.handleTokenRefresh()
}
