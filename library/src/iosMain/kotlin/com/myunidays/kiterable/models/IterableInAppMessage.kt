package com.myunidays.kiterable.models

actual class IterableInAppMessage internal constructor(private val ios: IterableInAppMessageImpl) {
    actual val messageId: String = ios.messageId
    actual val customPayload: Payload? = ios.customPayload
    actual val createdAt: String? = ios.createdAt
    actual val expiresAt: String? = ios.expiresAt
}

data class IterableInAppMessageImpl(
    val messageId: String,
    val customPayload: Payload?,
    val createdAt: String?,
    val expiresAt: String?,
//    val content: Content,
//    val trigger: Trigger,
//    val priorityLevel: Double,
//    val inboxMetadata: InboxMetadata,
//    val campaignId: Long,
)
