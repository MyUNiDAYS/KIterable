package com.myunidays.kiterable.models

expect class IterableInAppMessage {
    val messageId: String
    val customPayload: Payload?
}
