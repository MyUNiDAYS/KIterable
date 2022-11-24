package com.myunidays.kiterable

class IterableHelper {
    interface IterableActionHandler {
        fun execute(data: String?)
    }

    interface IterableUrlCallback {
        fun execute(url: String?)
    }
}
