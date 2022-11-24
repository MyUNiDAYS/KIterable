package com.myunidays.kiterable.models

import com.myunidays.kiterable.IterableURLDelegate

actual class IterableConfig(
    val pushIntegrationName: String? = null,
    val sandboxPushIntegrationName: String? = null,
    val pushServicePlatform: PushServicePlatform = PushServicePlatform.Auto,
    val urlDelegate: IterableURLDelegate? = null
)
