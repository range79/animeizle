package com.range.animeizle.like.service.impl

import com.range.animeizle.animes.domain.entity.Episode
import com.range.animeizle.animes.domain.repository.EpisodeRepository
import com.range.animeizle.animes.exception.EpisodeNotFound
import com.range.animeizle.like.domain.entity.Like
import com.range.animeizle.like.domain.repository.LikeRepository
import com.range.animeizle.like.dto.LikeResponse
import com.range.animeizle.like.exception.LikeAuthorException
import com.range.animeizle.like.exception.LikeNotFoundException
import com.range.animeizle.like.mapper.LikeMapper
import com.range.animeizle.like.service.LikeService
import com.range.animeizle.user.domain.entity.UserProfile
import com.range.animeizle.user.domain.repository.UserProfileRepository
import com.range.animeizle.user.exception.UserProfileNotFoundException
import com.range.animeizle.user.security.CustomUserDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LikeServiceImpl(
    private val likeRepository: LikeRepository,
    private val userProfileRepository: UserProfileRepository,
    private val episodeRepository: EpisodeRepository,
    private val likeMapper: LikeMapper
): LikeService {

    @Transactional
    override fun likeEpisode(episodeId: Long): LikeResponse {
        val userId = getUserId()

        val user = findUserProfile(userId)
        val episode =findEpisode(episodeId)
        val like =likeMapper.LikeRequestToLike(user,episode)

        val savedLike=  likeRepository.save(like)
        return likeMapper.LikeToLikeResponse(savedLike)

    }

    override fun removeLikeEpisode(
        id: Long,
        details: Boolean
    ): LikeResponse? {
        val userId =getUserId()
        val like= findLikedEpisode(id)
        if (userId!=like.userProfile.id ){
            throw LikeAuthorException("You are not authorized to delete this like with id=$id")
        }
        likeRepository.delete(like)
        return if (details){
            likeMapper.LikeToLikeResponse(like)
        }else{
            null
        }

    }

    override fun findAllUserLikes(): List<LikeResponse> {
        val  user = getUserId()
        return likeRepository.findByUserProfile_Id(user).map(likeMapper::LikeToLikeResponse)
    }





    //helper
    private fun findUserProfile(userId: Long): UserProfile {
        return userProfileRepository.findById(userId).orElseThrow{
            UserProfileNotFoundException("User Profile Not Found")
        }
    }
    private fun findEpisode(episodeId: Long): Episode {
        return episodeRepository.findById(episodeId).orElseThrow {
            EpisodeNotFound("Episode Not Found")
        }
    }
    private fun findLikedEpisode(id: Long): Like {
        return likeRepository.findById(id).orElseThrow{
            LikeNotFoundException("Like Not Found")
        }

    }
    private fun getUserId(): Long{
        return (SecurityContextHolder.getContext().authentication.principal as CustomUserDetails).getId()
    }
}