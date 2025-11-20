package com.range.rangeWatch.anime.api

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.exception.AnimeNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID
@RequestMapping("\${api.base-path}/anime")
interface AnimeQueryApi {
    @GetMapping
    fun getAll(pageable: Pageable): Page<Anime>

    @GetMapping("/{id}")
    fun getById(@PathVariable id: UUID): Anime

    @GetMapping("/search")
    fun search(@RequestParam title: String, pageable: Pageable): Page<Anime>

}