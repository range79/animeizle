package com.range.rangeWatch.anime.api

import com.range.rangeWatch.anime.dto.request.SeasonRequest
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.util.UUID

@RequestMapping("\${api.prefix}/seasons")
interface SeasonCommandApi {
    @PostMapping
    fun create(@RequestBody seasonRequest: SeasonRequest)
    @DeleteMapping("/{seasonId}")
    fun deleteSeason(@PathVariable seasonId: UUID)
    @PatchMapping("/{seasonId}")
    fun updateSeason(@PathVariable seasonId: UUID,@RequestBody seasonRequest: SeasonRequest)
}