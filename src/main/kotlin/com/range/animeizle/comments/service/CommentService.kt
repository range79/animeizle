package com.range.animeizle.comments.service

import com.range.animeizle.comments.domain.entity.Comment

interface CommentService {
    fun sendComment(episodeId: Long, comment: String)
    fun fetchComments(episodeId: Long): List<Comment>
    fun deleteComment(commentId: Long)
}