package com.range.animeizle.like.domain.repository

import com.range.animeizle.like.domain.entity.Like
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository: JpaRepository<Like, Long>{

}