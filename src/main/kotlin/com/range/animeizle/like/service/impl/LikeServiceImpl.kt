package com.range.animeizle.like.service.impl

import com.range.animeizle.animes.domain.entity.Episode
import com.range.animeizle.animes.domain.repository.EpisodeRepository
import com.range.animeizle.animes.exception.EpisodeNotFound
import com.range.animeizle.like.domain.entity.Like
import com.range.animeizle.like.domain.repository.LikeRepository
import com.range.animeizle.like.dto.LikeRequest
import com.range.animeizle.like.dto.LikeResponse
import com.range.animeizle.like.exception.LikeNotFoundException
import com.range.animeizle.like.mapper.LikeMapper
import com.range.animeizle.like.service.LikeService
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.exception.UserNotFoundException
import org.springframework.boot.actuate.endpoint.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LikeServiceImpl(
    private val likeRepository: LikeRepository,
    private val userRepository: UserRepository,
    private val episodeRepository: EpisodeRepository,
    private val likeMapper: LikeMapper
): LikeService {

    @Transactional
    override fun likeEpisode(likeRequest: LikeRequest): LikeResponse {
        val user = findUser(likeRequest.userId)
        val episode =findEpisode(likeRequest.episodeId)
        val like =likeMapper.LikeRequestToLike(user,episode)
        val savedLike=  likeRepository.save(like)
        return likeMapper.LikeToLikeResponse(savedLike)

    }

    override fun removeLikeEpisode(
        id: Long,
        details: Boolean
    ): LikeResponse? {
        val like= findLikedEpisode(id)
        likeRepository.delete(like)
        return if (details){
            likeMapper.LikeToLikeResponse(like)
        }else{
            null
        }

    }

    override fun findAllUserLikes(): List<LikeResponse> {
        val  user = SecurityContextHolder.getContext().authentication.name
        return likeRepository.findByUser_Username(user).map(likeMapper::LikeToLikeResponse)
    }


    private fun findUser(userId: Long): User {
        return userRepository.findById(userId).orElseThrow {
            UserNotFoundException("User Not Found")
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
}