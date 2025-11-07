package com.range.animeizle.common.util

object DeviceInfoHolder {
    private val context = ThreadLocal<RequestContext?>()

    fun setContext(ctx: RequestContext?) {
        context.set(ctx)
    }

    fun getContext(): RequestContext? {
        return context.get()
    }

    fun clear() {
        context.remove()
    }
}

@JvmRecord
data class RequestContext(val ip: String?, val deviceName: String?)
