package com.range.commentservice.domain.repository

import com.range.commentservice.domain.entity.Comment
import org.springframework.data.mongodb.repository.MongoRepository

interface CommentRepository: MongoRepository<Comment, String> {
    fun  findAllByEpisodeId(episodeId: Long): List<Comment>
}