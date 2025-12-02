package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.repository.AnimeRepository
import com.range.rangeWatch.anime.dto.request.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.request.AnimeUpdateRequest
import com.range.rangeWatch.anime.exception.AnimeNotFoundException
import com.range.rangeWatch.anime.mapper.AnimeMapper
import com.range.rangeWatch.anime.service.AnimeCommandService
import com.range.rangeWatch.common.service.PhotoService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class AnimeCommandServiceImpl(
    private val animeRepository: AnimeRepository,
    private val amazonService: PhotoService,
    private val animeMapper: AnimeMapper,
) : AnimeCommandService {

    private val bucketName = "anime-photos"

    @Transactional
    override fun create(anime: AnimeCreateRequest, image: MultipartFile?) {
        val image = image ?: throw IllegalArgumentException("For creating a new anime you must provide a image.")
        if (image.isEmpty) {
            throw IllegalArgumentException("Anime name can't be empty!.")
        }

        val animeEntity = animeMapper.toAnime(anime)

        val originalFilename = image.originalFilename ?: "default_image.jpg"
        val safeFileName = "${UUID.randomUUID()}-${originalFilename.substringAfterLast('/')}"

        try {
            animeEntity.imageUrl = amazonService.addPhoto(bucketName, image, safeFileName)

             animeRepository.save(animeEntity)

        } catch (e: Exception) {

            throw RuntimeException("A problem occurred creating  anime.", e)
        }
    }

    @Transactional
    override fun update(id: UUID, updated: AnimeUpdateRequest, image: MultipartFile?) {
        val existing = animeRepository.findById(id).orElseThrow {
            AnimeNotFoundException("Anime Not Found")
        }

        existing.title = updated.title
        existing.description = updated.description

        if (image != null && !image.isEmpty) {
            val fileName = "${UUID.randomUUID()}-${image.originalFilename}"
            existing.imageUrl = amazonService.addPhoto(bucketName, image, fileName)
        }

         animeRepository.save(existing)
    }

    @Transactional
    override fun delete(id: UUID) {
        val anime = animeRepository.findById(id).orElse(null) ?: throw AnimeNotFoundException("Anime not found")

        if (anime.imageUrl.isNotEmpty()) {
            val filename = anime.imageUrl.substringAfterLast("/")
            amazonService.deletePhoto(bucketName, filename)
        }
        animeRepository.deleteById(id)

    }

}
