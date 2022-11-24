package com.myunidays.kiterable.models

actual class IterableActionContext(private val nativeSource: Int) {
    actual val action: IterableAction
        get() = TODO("Not yet implemented")
    actual val source: IterableActionSource
        get() = IterableActionSource.values()[nativeSource]
}
