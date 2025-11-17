package com.range.animeWatch.common.service.impl

import com.range.animeWatch.common.service.AmazonService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import software.amazon.awssdk.core.exception.SdkException
import software.amazon.awssdk.core.sync.RequestBody
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest
import software.amazon.awssdk.services.s3.model.PutObjectRequest
import java.io.IOException

@Service
class AmazonServiceImpl(
    private val s3Client: S3Client
): AmazonService {

    override fun addPhoto(bucketName: String, file: MultipartFile, fileName: String): String {
        try {
            val putRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(file.contentType)
                .build()

            s3Client.putObject(putRequest, RequestBody.fromInputStream(file.inputStream, file.size))

            return "https://${bucketName}.s3.amazonaws.com/$fileName"
        } catch (e: IOException) {
            throw RuntimeException("Failed to read the uploaded file: ${e.message}", e)
        } catch (e: SdkException) {
            throw RuntimeException("AWS S3 upload failed: ${e.message}", e)
        }
    }

    override fun deletePhoto(bucketName: String, filename: String?) {
        try {
            val deleteRequest = DeleteObjectRequest.builder()
                .bucket(bucketName)
                .key(filename)
                .build()

            s3Client.deleteObject(deleteRequest)
        } catch (e: SdkException) {
            throw RuntimeException("AWS S3 delete failed: ${e.message}", e)
        }
    }
}