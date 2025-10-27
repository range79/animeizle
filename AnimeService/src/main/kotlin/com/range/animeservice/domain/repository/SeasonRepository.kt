package com.range.animeservice.domain.repository

import com.range.configserver.domain.entity.Season
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SeasonRepository : JpaRepository<Season, UUID>