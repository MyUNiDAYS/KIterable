package com.myunidays.kiterable

val shared: IterableApiInterface get() = IterableApiInterface.getInstance()
val optionalShared: IterableApiInterface? get() = IterableApiInterface.getOptionalInstance()

private var internalInstance: IosIterableApiInterface? = null
actual interface IterableApiInterface {

    actual companion object {
        actual fun initialize(apiKey: String, initializationOptions: IterableInitializationOptions): IterableApiInterface {
            internalInstance = initializationOptions.iosNativeInstance
            internalInstance!!.initialize(apiKey, initializationOptions.launchOptions, initializationOptions.iterableConfig)
            return instance
        }

        actual fun getInstance(): IterableApiInterface = instance

        fun getOptionalInstance(): IterableApiInterface? = if (internalInstance != null) instance else null

        private val instance: IterableApiInterface by lazy {
            IterableApi(internalInstance!!)
        }
    }

    actual val payloadData: PayloadData?
    actual val inAppManager: IterableInAppManagerInterface
    actual fun setUserId(userId: String?)
    actual fun setEmail(email: String?)
    actual fun getPayloadData(key: String): String?
    actual fun getMessages(): List<IterableInAppMessage>
    actual fun getMessage(predicate: (IterableInAppMessage) -> Boolean): IterableInAppMessage?
    actual fun showMessage(message: IterableInAppMessage, consume: Boolean, onClick: IterableUrlCallback?)
    actual fun getAndTrackDeepLink(uri: String, onCallback: IterableActionHandler)
    actual fun disableDeviceForCurrentUser()
    actual fun setAutoDisplayPaused(paused: Boolean)
}
