package com.range.animeWatch.anime.service.impl

import com.range.animeWatch.anime.domain.entity.Anime
import com.range.animeWatch.anime.domain.repository.AnimeRepository
import com.range.animeWatch.anime.dto.AnimeUpdateRequest
import com.range.animeWatch.anime.exception.AnimeNotFoundException
import com.range.animeWatch.anime.service.AnimeService
import com.range.animeWatch.common.service.AmazonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class AnimeServiceImpl(
    private val animeRepository: AnimeRepository,
    private val amazonService: AmazonService
) : AnimeService {

    private val bucketName = "anime-photos"
    @Transactional(readOnly = true)
    override fun getAll(pageable: Pageable): Page<Anime> =
        animeRepository.findAll(pageable)
    @Transactional(readOnly = true)
    override fun getById(id: UUID): Anime =
        animeRepository.findById(id).orElseThrow {
            AnimeNotFoundException("Anime Not Found")
        }
    @Transactional(readOnly = true)
    override fun searchByTitle(title: String, pageable: Pageable): Page<Anime> =
        animeRepository.findByTitleContainingIgnoreCase(title, pageable)

    @Transactional
    override fun create(anime: Anime, image: MultipartFile?): Anime {
        if (image != null && !image.isEmpty) {
            val fileName = "${UUID.randomUUID()}-${image.originalFilename}"
            anime.imageUrl = amazonService.addPhoto(bucketName, image, fileName)
        }
        return animeRepository.save(anime)
    }

    @Transactional
    override fun update(id: UUID, updated: AnimeUpdateRequest, image: MultipartFile?): Anime {
        val existing = animeRepository.findById(id).orElseThrow {
            AnimeNotFoundException("Anime Not Found")
        }

        existing.title = updated.title
        existing.description = updated.description

        if (image != null && !image.isEmpty) {
            val fileName = "${UUID.randomUUID()}-${image.originalFilename}"
            existing.imageUrl = amazonService.addPhoto(bucketName, image, fileName)
        }

        return animeRepository.save(existing)
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
