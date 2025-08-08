package com.range.commentservice.service

import com.range.commentservice.domain.entity.Comment

interface CommentService {
    fun sendComment(episodeId: Long, comment: String)
    fun fetchComments(episodeId: Long): List<Comment>
    fun deleteComment(commentId: Long)
}