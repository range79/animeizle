package com.range.commentservice.service.impl

import com.range.animeizle.animes.exception.EpisodeNotFound
import com.range.animeizle.animes.service.EpisodeService
import com.range.commentservice.domain.entity.Comment
import com.range.commentservice.domain.repository.CommentRepository
import com.range.commentservice.exception.CommentAuthorException
import com.range.commentservice.mapper.CommentMapper
import com.range.commentservice.service.CommentService
import com.range.animeizle.common.CustomSecurityContext
import com.range.commentservice.exception.CommentNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,

    private val commentMapper: CommentMapper
) : CommentService {
    @Transactional
    override fun sendComment(episodeId: Long, comment: String) {
        val  userId =customSecurityContext.getUserId()
        episodeService.exits(episodeId)
        val commentEntity =commentMapper.toComments(comment,userId,episodeId)
        commentRepository.save(commentEntity)
    }

    override fun fetchComments(episodeId: Long) :List<Comment>{
        return commentRepository.findAllByEpisodeId(episodeId)

    }
    @Transactional
    override fun deleteComment(commentId: String) {
        val comment = commentRepository.findById(commentId)
            .orElseThrow{ CommentNotFoundException("Comment not found")}

        val userId = customSecurityContext.getUserId()
        if (comment.userId != userId){
            throw CommentAuthorException("You're not the author of this comment")
        }
        commentRepository.delete(comment)



    }
}