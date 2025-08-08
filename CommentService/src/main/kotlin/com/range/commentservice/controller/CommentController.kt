package com.range.commentservice.controller

import com.range.commentservice.api.CommentApi
import com.range.commentservice.domain.entity.Comment
import com.range.commentservice.service.CommentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController(
    private val commentService: CommentService
) : CommentApi {
    override fun sendComment(
        episodeId: Long,
        comment: String
    ): ResponseEntity<Void> {
        commentService.sendComment(episodeId, comment)
        return ResponseEntity.ok().build()
    }

    override fun fetchComments(episodeId: Long): ResponseEntity<List<Comment>> {
        return ResponseEntity.ok(commentService.fetchComments(episodeId))
    }

    override fun deleteComment(commentId: Long): ResponseEntity<Void> {
        commentService.deleteComment(commentId)
        return ResponseEntity.ok().build()
    }

}