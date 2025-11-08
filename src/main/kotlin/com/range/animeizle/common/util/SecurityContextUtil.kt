package com.range.animeizle.common.util

import java.util.UUID

interface SecurityContextUtil {
    fun getCurrentUserId(): UUID
}