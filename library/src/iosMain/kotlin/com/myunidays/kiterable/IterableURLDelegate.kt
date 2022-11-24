package com.myunidays.kiterable

import com.myunidays.kiterable.models.IterableActionContext
import platform.Foundation.NSURL

interface IterableURLDelegate {
    fun handle(url: NSURL, context: IterableActionContext): Boolean
}
