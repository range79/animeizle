package com.range.rangeWatch.common.service.impl

import com.amazonaws.services.mediaconvert.AWSMediaConvertClient
import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import com.range.rangeWatch.common.service.AmazonVideoService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client

@Service
class AmazonVideoServiceImpl (
    private val s3Client: S3Client,
//    private val mediaConvertClient: AWSMediaConvertClient,
    @Value("\${aws.mediaconvert.role}") private val mediaConvertRole: String
): AmazonVideoService {
    private val log = LoggerFactory.getLogger(AmazonVideoServiceImpl::class.java)
//Todo i need add ahh media convert to it
    override fun findVideo(
        bucketName: String,
        videoId: String,
        quality: VideoQuality,
        language: DubbingLanguage
    ): String? {
        val key = "$videoId/${language.name}/${quality.name}.mp4"
        return try {
            s3Client.headObject {
                it.bucket(bucketName).key(key)
            }
            "https://$bucketName.s3.amazonaws.com/$key"
        } catch (e: Exception) {
            log.error(e.toString())
            null
        }
    }

    override fun saveVideo(
        bucketName: String,
        videoId: String,
        video: MultipartFile,
        language: DubbingLanguage
    ): String {
        val key = "$videoId/${language.name}/${video.originalFilename}"
        s3Client.putObject(
            { it.bucket(bucketName).key(key) },
            RequestBody.fromInputStream(video.inputStream, video.size)
        )
        return "https://$bucketName.s3.amazonaws.com/$key"
    }
    override fun deleteVideo(
        bucketName: String,
        videoId: String,
        quality: VideoQuality?,
        language: DubbingLanguage?
    ) {
        val key = if (quality != null && language != null) {
            "$videoId/${language.name}/${quality.name}.mp4"
        } else {

            log.info("Deleting all videos for $videoId in bucket $bucketName")
            return
        }

        try {
            s3Client.deleteObject {
                it.bucket(bucketName)
                it.key(key)
            }
            log.info("Deleted $key from $bucketName")
        } catch (e: Exception) {
            log.error("Failed to delete $key: ${e.message}")
        }
    }
}