package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionContext

interface IterableUrlHandler {
    fun handleIterableURL(uri: String, actionContext: IterableActionContext): Boolean
}
