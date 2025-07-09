package com.range.animeizle.like.service.impl

import com.range.animeizle.animes.service.EpisodeService
import com.range.animeizle.like.domain.entity.EpisodeLike
import com.range.animeizle.like.domain.repository.EpisodeLikeRepository
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
    private val episodeLikeRepository: EpisodeLikeRepository,
    private val episodeService: EpisodeService,
    private val likeMapper: LikeMapper
): LikeService {

    @Transactional
    override fun likeEpisode(episodeId: Long): LikeResponse {
        val userId =getUserId()
        validateEpisodeExists(episodeId)
        val like = likeMapper.toLike(userId, episodeId)
        val savedLike = episodeLikeRepository.save(like)
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
        episodeLikeRepository.delete(like)
        return if (details){
            likeMapper.toLikeResponse(like)
        }else{
            null
        }

    }

    override fun findAllUserLikes(): List<LikeResponse> {
        val  user =getUserId()
        val like = episodeLikeRepository.findByUserId(user).map  (
            likeMapper::toLikeResponse
        )
        return like
    }

    private fun findLikedEpisode(id: Long): EpisodeLike {
        return episodeLikeRepository.findById(id).orElseThrow{
            LikeNotFoundException("Like Not Found")
        }

    }
    private fun validateEpisodeExists(episodeId: Long) {
        episodeService.exits(episodeId)
    }


    private  fun getUserId(): Long{
        return (SecurityContextHolder.getContext().authentication.principal
                as CustomUserDetails).getId()
    }

    private fun checkOwnership(userId: Long, episodeLike: EpisodeLike) {
        if (userId != episodeLike.userId)
            throw LikeAuthorException("User $userId not authorized to delete like id=${episodeLike.id}")
    }

}