package com.range.animeWatch.common.util

import java.util.UUID

interface SecurityContextUtil {
    fun getCurrentUserId(): UUID
}