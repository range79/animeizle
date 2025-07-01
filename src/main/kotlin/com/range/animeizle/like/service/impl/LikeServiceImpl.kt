package com.range.animeizle.like.service.impl

import com.range.animeizle.animes.domain.repository.EpisodeRepository
import com.range.animeizle.animes.exception.EpisodeNotFound
import com.range.animeizle.like.domain.entity.Like
import com.range.animeizle.like.domain.repository.LikeRepository
import com.range.animeizle.like.dto.LikeResponse
import com.range.animeizle.like.exception.LikeAuthorException
import com.range.animeizle.like.exception.LikeNotFoundException
import com.range.animeizle.like.mapper.LikeMapper
import com.range.animeizle.like.service.LikeService
import com.range.animeizle.user.security.CustomUserDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LikeServiceImpl(
    private val likeRepository: LikeRepository,
    private val episodeRepository: EpisodeRepository,
    private val likeMapper: LikeMapper
): LikeService {

    @Transactional
    override fun likeEpisode(episodeId: Long): LikeResponse {
        val userId =getUserId()
        validateEpisodeExists(episodeId)
        val like = likeMapper.toLike(userId, episodeId)
        val savedLike = likeRepository.save(like)
        return likeMapper.toLikeResponse(savedLike)
    }

    @Transactional
    override fun removeLikeEpisode(
        id: Long,
        details: Boolean
    ): LikeResponse? {
        val userId =getUserId()
        val like= findLikedEpisode(id)
        checkOwnership(userId,like)
        likeRepository.delete(like)
        return if (details){
            likeMapper.toLikeResponse(like)
        }else{
            null
        }

    }

    override fun findAllUserLikes(): List<LikeResponse> {
        val  user =getUserId()
        val like = likeRepository.findByUserId(user).map  (
            likeMapper::toLikeResponse
        )
        return like
    }






    private fun findLikedEpisode(id: Long): Like {
        return likeRepository.findById(id).orElseThrow{
            LikeNotFoundException("Like Not Found")
        }

    }
    private fun validateEpisodeExists(episodeId: Long) {
        if (!episodeRepository.existsById(episodeId))
            throw EpisodeNotFound("Episode with id=$episodeId not found")
    }
    private  fun getUserId(): Long{
        return (SecurityContextHolder.getContext().authentication.principal as CustomUserDetails).getId()
    }
    private fun checkOwnership(userId: Long, like: Like) {
        if (userId != like.userId)
            throw LikeAuthorException("User $userId not authorized to delete like id=${like.id}")
    }

}