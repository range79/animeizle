package com.range.animeizle.like.domain.repository

import com.range.animeizle.like.domain.entity.Like
import com.range.animeizle.like.dto.LikeResponse
import org.springframework.data.jpa.repository.JpaRepository


interface LikeRepository: JpaRepository<Like, Long>{
    fun findByUserId(id: Long): List<Like>
}