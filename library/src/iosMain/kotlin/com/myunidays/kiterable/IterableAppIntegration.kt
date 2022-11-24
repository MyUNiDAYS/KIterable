package com.myunidays.kiterable

import platform.Foundation.NSDictionary
import platform.UIKit.UIApplication
import platform.UIKit.UIBackgroundFetchResult
import platform.UserNotifications.UNNotificationResponse
import platform.UserNotifications.UNUserNotificationCenter

class IterableAppIntegration constructor(private val ios: IterableAppIntegrationInterface) {

    fun application(
        application: UIApplication,
        userInfo: NSDictionary,
        completionHandler: ((UIBackgroundFetchResult) -> Unit)?
    ) = ios.application(application, userInfo, completionHandler)

    fun userNotificationCenter(
        center: UNUserNotificationCenter?,
        response: UNNotificationResponse,
        completionHandler: (() -> Unit)?
    ) = ios.userNotificationCenter(center, response, completionHandler)
}

interface IterableAppIntegrationInterface {
    fun application(
        application: UIApplication,
        userInfo: NSDictionary,
        completionHandler: ((UIBackgroundFetchResult) -> Unit)?
    )

    fun userNotificationCenter(
        center: UNUserNotificationCenter?,
        response: UNNotificationResponse,
        completionHandler: (() -> Unit)?
    )
}
