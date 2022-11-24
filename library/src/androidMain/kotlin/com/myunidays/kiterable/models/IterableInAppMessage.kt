package com.myunidays.kiterable.models

actual class IterableInAppMessage internal constructor(android: com.iterable.iterableapi.IterableInAppMessage) {
    actual val messageId = android.messageId
    actual val customPayload: Payload? = android.customPayload
}
