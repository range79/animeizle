package com.range.commentservice.domain.repository

import com.range.commentservice.domain.entity.Comment
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface CommentRepository: MongoRepository<Comment, UUID> {
    fun  findAllByEpisodeId(episodeId: UUID): List<Comment>
}