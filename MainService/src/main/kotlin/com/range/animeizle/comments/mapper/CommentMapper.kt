package com.range.animeizle.comments.mapper

import com.range.animeizle.comments.domain.entity.Comment
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CommentMapper {
    fun toComments(comment: String,userId: Long, episodeId: Long): Comment{
        return Comment(
            id=null,
            text = comment,
            userId = episodeId,
            episodeId = 0,
            updatedAt = LocalDateTime.now()
        )
    }
}