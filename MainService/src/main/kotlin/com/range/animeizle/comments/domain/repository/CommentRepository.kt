package com.range.animeizle.comments.domain.repository

import com.range.animeizle.comments.domain.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
    fun  findAllByEpisodeId(episodeId: Long): List<Comment>
}