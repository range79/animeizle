package com.range.commentservice.service.impl


import com.range.commentservice.domain.entity.Comment
import com.range.commentservice.domain.repository.CommentRepository
import com.range.commentservice.exception.CommentAuthorException
import com.range.commentservice.mapper.CommentMapper
import com.range.commentservice.service.CommentService

import com.range.commentservice.exception.CommentNotFoundException
import com.range.commentservice.service.EpisodeService

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,
    private val episodeService: EpisodeService,
    private val commentMapper: CommentMapper
) : CommentService {
    @Transactional
    override fun sendComment(userId: UUID, episodeId: UUID, comment: String) {
        val  userId =userId
        episodeService.exits(episodeId)
        val commentEntity =commentMapper.toComments(comment,userId,episodeId)
        commentRepository.save(commentEntity)
    }

    override fun fetchComments(episodeId: UUID) :List<Comment>{
        return commentRepository.findAllByEpisodeId(episodeId)

    }
    @Transactional
    override fun deleteComment(userId: UUID,commentId: UUID) {
        val comment = commentRepository.findById(commentId)
            .orElseThrow{ CommentNotFoundException("Comment not found")}
        if (comment.userId != userId){
            throw CommentAuthorException("You're not the author of this comment")
        }
        commentRepository.delete(comment)
    }
}