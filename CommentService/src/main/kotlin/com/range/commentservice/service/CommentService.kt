package com.range.commentservice.service

import com.range.commentservice.domain.entity.Comment
import java.util.UUID

interface CommentService {
    fun sendComment(userId: UUID, episodeId: UUID, comment: String)
    fun fetchComments(episodeId: UUID): List<Comment>
    fun deleteComment(userId: UUID,commentId: UUID)
}