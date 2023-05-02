package com.myunidays.kiterable.models

interface IterableInAppMessageInterface {
    val messageId: String
    val customPayload: Payload?
    val createdAt: String?
    val expiresAt: String?
}