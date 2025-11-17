package com.range.animeWatch.common.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client

@Configuration
class AmazonS3Config {

    @Value("\${amazon.s3.accessKey}")
    private lateinit var accessKey: String

    @Value("\${amazon.s3.secretAccessKey}")
    private lateinit var secretAccessKey: String

    @Value("\${amazon.s3.region}")
    private lateinit var region: String

    @Bean
    fun s3Client(): S3Client {
        val credentials = AwsBasicCredentials.create(accessKey, secretAccessKey)

        return S3Client.builder()
            .region(Region.of(region))
            .credentialsProvider(StaticCredentialsProvider.create(credentials))
            .build()
    }
}