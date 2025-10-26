package com.range.commentservice.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import java.util.UUID

@FeignClient(value = "episodeService")
interface EpisodeService {
    @GetMapping("/{episodeId}")
    fun exits(episodeId: UUID):Boolean

}