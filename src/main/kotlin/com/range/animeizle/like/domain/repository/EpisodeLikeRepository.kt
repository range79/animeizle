package com.range.animeizle.like.domain.repository

import com.range.animeizle.like.domain.entity.EpisodeLike
import org.springframework.data.jpa.repository.JpaRepository


interface EpisodeLikeRepository: JpaRepository<EpisodeLike, Long>{
    fun findByUserId(id: Long): List<EpisodeLike>
}