package com.range.commentservice.api

import com.range.commentservice.domain.entity.Comment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import java.util.UUID

@RequestMapping("\${api.prefix}/comments")
interface CommentApi {
    @RequestMapping("/send/{episodeId}/comment")
    fun sendComment(@RequestHeader("x-user-Id") userId: UUID, @PathVariable episodeId: UUID, comment: String): ResponseEntity<Void>
    @RequestMapping("/fetch/{episodeId}/comments")
    fun fetchComments(@PathVariable episodeId: UUID): List<Comment>
    @RequestMapping("/delete/{commentId}")
    fun deleteComment(@RequestHeader("x-user-Id") userId: UUID,@PathVariable commentId: UUID): ResponseEntity<Void>
}