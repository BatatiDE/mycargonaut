package com.mycargonaut.backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.mycargonaut.backend.entity.ExampleEntity

@Repository
interface ExampleRepository : JpaRepository<ExampleEntity, Long>
