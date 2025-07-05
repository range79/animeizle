package com.range.animeizle.comments.api

import com.range.animeizle.comments.domain.entity.Comment
import org.apache.coyote.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/api/v1/comments")
interface CommentApi {
    @RequestMapping("/send/{episodeId}/comment")
    fun sendComment(@PathVariable episodeId: Long, comment: String): ResponseEntity<Void>
    @RequestMapping("/fetch/{episodeId}/comments")
    fun fetchComments(@PathVariable episodeId: Long): ResponseEntity<List<Comment>>
    @RequestMapping("/delete/{commentId}")
    fun deleteComment(@PathVariable commentId: Long): ResponseEntity<Void>
}