package com.range.rangeWatch.anime.api

import com.range.rangeWatch.anime.dto.request.EpisodeVideoRequest
import com.range.rangeWatch.anime.dto.response.EpisodeVideoResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.multipart.MultipartFile
import java.util.UUID

@RequestMapping("\${api.prefix}/episode-videos")
interface EpisodeVideoCommandApi {
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/")
    fun uploadVideo(
        @RequestPart("file") file: MultipartFile,
        @RequestPart("data") episodeVideoRequest: EpisodeVideoRequest
    )

    @DeleteMapping("/{videoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteVideo(
        @PathVariable videoId: UUID
    )
}