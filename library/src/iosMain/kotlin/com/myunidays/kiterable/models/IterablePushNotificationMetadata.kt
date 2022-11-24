package com.myunidays.kiterable.models

import platform.Foundation.NSDictionary
import platform.Foundation.NSNumber

data class IterablePushNotificationMetadata(
    val campaignId: NSNumber? = null,
    val templateId: NSNumber? = null,
    val messageId: String,
    val isGhostPush: Boolean
) {

    companion object {
        fun metadata(userInfo: NSDictionary): IterablePushNotificationMetadata? =
            (userInfo.objectForKey("itbl") as? NSDictionary)
                ?.let { metadata ->
                    if (metadata.objectForKey("messageId") != null &&
                        metadata.objectForKey("isGhostPush") != null
                    ) {
                        IterablePushNotificationMetadata(
                            campaignId = metadata.objectForKey("campaignId") as? NSNumber,
                            templateId = metadata.objectForKey("templateId") as? NSNumber,
                            messageId = metadata.objectForKey("messageId") as String,
                            isGhostPush = metadata.objectForKey("isGhostPush") as Boolean
                        )
                    } else {
                        null
                    }
                }
    }

    fun isRealCampaignNotification(): Boolean = !(isGhostPush || isProof() || isTestPush())
    fun isProof(): Boolean = ((campaignId == null || campaignId.intValue == 0) && templateId?.intValue != 0)
    fun isTestPush(): Boolean = ((campaignId == null || campaignId.intValue == 0) && templateId?.intValue == 0)
}
