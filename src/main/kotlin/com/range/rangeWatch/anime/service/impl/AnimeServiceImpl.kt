package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.domain.repository.AnimeRepository
import com.range.rangeWatch.anime.dto.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.AnimeUpdateRequest
import com.range.rangeWatch.anime.exception.AnimeNotFoundException
import com.range.rangeWatch.anime.mapper.AnimeMapper
import com.range.rangeWatch.anime.service.AnimeService
import com.range.rangeWatch.common.service.AmazonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class AnimeServiceImpl(
    private val animeRepository: AnimeRepository,
    private val amazonService: AmazonService,
    private val animeMapper: AnimeMapper,
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
    override fun create(animeRequest: AnimeCreateRequest, imageFile: MultipartFile?): Anime {
        val image = imageFile ?: throw IllegalArgumentException("Anime oluşturmak için resim dosyası gereklidir.")
        if (image.isEmpty) {
            throw IllegalArgumentException("Yüklenen resim dosyası boş olamaz.")
        }

        val animeEntity = animeMapper.toAnime(animeRequest)

        val originalFilename = image.originalFilename ?: "default_image.jpg"
        val safeFileName = "${UUID.randomUUID()}-${originalFilename.substringAfterLast('/')}"

        try {
            animeEntity.imageUrl = amazonService.addPhoto(bucketName, image, safeFileName)

            return animeRepository.save(animeEntity)

        } catch (e: Exception) {

            throw RuntimeException("Anime oluşturma veya resim yükleme başarısız oldu.", e)
        }
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
