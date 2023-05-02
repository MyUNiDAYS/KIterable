package com.myunidays.kiterable.models

actual class IterableInAppMessage internal constructor(android: com.iterable.iterableapi.IterableInAppMessage) : IterableInAppMessageInterface {
    actual override val messageId = android.messageId
    actual override val customPayload: Payload? = android.customPayload
    actual override val createdAt: String? = android.createdAt.toString()
    actual override val expiresAt: String? = android.expiresAt.toString()
}
