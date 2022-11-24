package com.myunidays.kiterable

import com.myunidays.kiterable.models.Context
import com.myunidays.kiterable.models.IterablePushNotificationMetadata
import com.myunidays.kiterable.models.RemoteMessage
import platform.Foundation.NSDictionary

actual object IterableMessagingService {
    actual fun isGhostPush(message: RemoteMessage): Boolean =
        (message.objectForKey("isGhostPush") as? Boolean)
            ?: (message.objectForKey("itbl") as? NSDictionary)
                ?.objectForKey("isGhostPush") as? Boolean
            ?: false

    actual fun handleMessageReceived(
        context: Context,
        message: RemoteMessage,
    ): Boolean = TODO("Not yet implemented")

    actual fun handleTokenRefresh(): Unit = TODO("Not implemented for iOS")

    fun metadata(fromLaunchOptions: NSDictionary): IterablePushNotificationMetadata? =
        IterablePushNotificationMetadata.metadata(fromLaunchOptions)
}
