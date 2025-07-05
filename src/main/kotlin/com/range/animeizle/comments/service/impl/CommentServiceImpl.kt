package com.range.animeizle.comments.service.impl

import com.range.animeizle.comments.service.CommentService
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl : CommentService {
    override fun sendComment(episodeId: Long, comment: String) {
        TODO("Not yet implemented")
    }

    override fun fetchComments(episodeId: Long) {
        TODO("Not yet implemented")
    }

    override fun deleteComment(commentId: Long) {
        TODO("Not yet implemented")
    }

    override fun likeComment(commentId: Long) {
        TODO("Not yet implemented")
    }
}