package com.range.animeizle.comments.service

interface CommentService {
    fun sendComment(episodeId: Long, comment: String)
    fun fetchComments(episodeId: Long)
    fun deleteComment(commentId: Long)
    fun likeComment(commentId: Long)
}