package com.range.animeizle.comments.service.impl

import com.range.animeizle.animes.exception.EpisodeNotFound
import com.range.animeizle.animes.service.EpisodeService
import com.range.animeizle.comments.domain.entity.Comment
import com.range.animeizle.comments.domain.repository.CommentRepository
import com.range.animeizle.comments.exception.CommentAuthorException
import com.range.animeizle.comments.mapper.CommentMapper
import com.range.animeizle.comments.service.CommentService
import com.range.animeizle.common.CustomSecurityContext
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl(
    private val commentRepository: CommentRepository,
    private val customSecurityContext: CustomSecurityContext,
    private val episodeService: EpisodeService,
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
    override fun deleteComment(commentId: Long) {
        val comment = commentRepository.findById(commentId)
            .orElseThrow{ EpisodeNotFound("Comment not found")}

        val userId = customSecurityContext.getUserId()
        if (comment.userId != userId){
            throw CommentAuthorException("You're not the author of this comment")
        }
        commentRepository.delete(comment)



    }
}