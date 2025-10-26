package com.range.commentservice.controller

import com.range.commentservice.api.CommentApi
import com.range.commentservice.domain.entity.Comment
import com.range.commentservice.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class CommentController(
    private val commentService: CommentService
) : CommentApi {
    override fun sendComment(
        userId: UUID,
        episodeId: UUID,
        comment: String,
    ): ResponseEntity<Void> {
        commentService.sendComment(userId,episodeId, comment)
        return ResponseEntity.ok().build()
    }

    override fun fetchComments(episodeId: UUID): List<Comment> {
        return commentService.fetchComments(episodeId)
    }

    override fun deleteComment(userId: UUID,commentId: UUID): ResponseEntity<Void> {
         commentService.deleteComment(userId,commentId)
        return ResponseEntity.ok().build()
    }

}