package com.range.animeWatch.common.util

import com.range.animeWatch.common.exception.DeviceNotFoundException

object DeviceInfoHolder {
    private val context = ThreadLocal<RequestContext?>()

    fun setContext(ctx: RequestContext?) {
        context.set(ctx)
    }

    fun getContext(): RequestContext {
        return context.get()?: throw DeviceNotFoundException("Device information not found in context")
    }

    fun clear() {
        context.remove()
    }
}

@JvmRecord
data class RequestContext(val ip: String?, val deviceName: String)