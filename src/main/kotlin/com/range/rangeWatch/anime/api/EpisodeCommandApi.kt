package com.range.rangeWatch.anime.api

import com.range.rangeWatch.anime.dto.request.EpisodeRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RequestMapping("\${api.prefix}/episodes")
interface EpisodeCommandApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createEpisode(@RequestBody episodeRequest: EpisodeRequest)

    @DeleteMapping("/{episodeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEpisode(@PathVariable episodeId: UUID)


    @PatchMapping("/{episodeId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateEpisode(@PathVariable episodeId: UUID, @RequestBody episodeRequest: EpisodeRequest)
}