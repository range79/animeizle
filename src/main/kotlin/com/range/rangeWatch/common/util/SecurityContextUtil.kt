package com.range.rangeWatch.common.util

import java.util.UUID

interface SecurityContextUtil {
    fun getCurrentUserId(): UUID
}