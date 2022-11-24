package com.myunidays.kiterable.models

actual class IterableActionContext constructor(private val android: com.iterable.iterableapi.IterableActionContext) {
    actual val action: IterableAction
        get() = android.action
    actual val source: IterableActionSource
        get() = IterableActionSource.valueOf(android.source.name)
}
