package com.range.animeizle.anime.service.impl

import com.range.animeizle.anime.domain.entity.Anime
import com.range.animeizle.anime.domain.repository.AnimeRepository
import com.range.animeizle.anime.service.AnimeService
import com.range.animeizle.common.service.AmazonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class AnimeServiceImpl(
    private val animeRepository: AnimeRepository,
    private val amazonService: AmazonService
) : AnimeService {

    private val bucketName = "anime-photos"

    override fun getAll(pageable: Pageable): Page<Anime> =
        animeRepository.findAll(pageable)

    override fun getById(id: UUID): Anime? =
        animeRepository.findById(id).orElse(null)

    override fun searchByTitle(title: String, pageable: Pageable): Page<Anime> =
        animeRepository.findByTitleContainingIgnoreCase(title, pageable)

    override fun create(anime: Anime, image: MultipartFile?): Anime {
        if (image != null && !image.isEmpty) {
            val fileName = "${UUID.randomUUID()}-${image.originalFilename}"
            anime.imageUrl = amazonService.addPhoto(bucketName, image, fileName)
        }
        return animeRepository.save(anime)
    }

    override fun update(id: UUID, updated: Anime, image: MultipartFile?): Anime? {
        val existing = animeRepository.findById(id).orElse(null) ?: return null

        existing.title = updated.title
        existing.description = updated.description

        if (image != null && !image.isEmpty) {
            val fileName = "${UUID.randomUUID()}-${image.originalFilename}"
            existing.imageUrl = amazonService.addPhoto(bucketName, image, fileName)
        }

        return animeRepository.save(existing)
    }

    override fun delete(id: UUID): Boolean {
        val anime = animeRepository.findById(id).orElse(null) ?: return false

        if (anime.imageUrl.isNotEmpty()) {
            val filename = anime.imageUrl.substringAfterLast("/")
            amazonService.deletePhoto(bucketName, filename)
        }
        animeRepository.deleteById(id)
        return true
    }
}
