package com.range.commentservice.mapper

import com.range.commentservice.domain.entity.Comment
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.UUID

@Component
class CommentMapper {
    fun toComments(comment: String,userId: UUID, episodeId: UUID): Comment{
        return Comment(
            id=null,
            text = comment,
            userId = userId,
            episodeId = episodeId,
            updatedAt = LocalDateTime.now()
        )
    }
}