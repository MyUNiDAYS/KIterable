package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionContext
import com.myunidays.kiterable.models.IterableConfig

data class IterableConfigBuilder(
    val pushIntegrationName: String,
    val urlHandler: IterableUrlHandler,
    val autoPushRegistration: Boolean = false,
    val allowedProtocols: List<String> = emptyList(),
    val logLevel: Int = 6
) {
    fun build(): IterableConfig = com.iterable.iterableapi.IterableConfig.Builder()
        .setPushIntegrationName(pushIntegrationName)
        .setUrlHandler { uri, context ->
            urlHandler.handleIterableURL(uri.toString(), IterableActionContext(context))
        }
        .setAutoPushRegistration(autoPushRegistration)
        .setAllowedProtocols(allowedProtocols.toTypedArray())
        .setLogLevel(logLevel)
        .build()
}
