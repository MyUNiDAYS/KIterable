package com.myunidays.kiterable.models

expect class IterableInAppMessage : IterableInAppMessageInterface {
    override val messageId: String
    override val customPayload: Payload?
    override val createdAt: String?
    override val expiresAt: String?
}
