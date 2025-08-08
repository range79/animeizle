package com.range.commentservice.domain.entity

import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "comments")
data class Comment (
    @Id
    val id: String? = null,
    val text: String,
    val episodeId: Long,
    val userId: Long,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime
)