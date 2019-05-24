package com.dont39.springusefuldemo.dao

import com.dont39.springusefuldemo.entity.PlayerEntity
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author sirius
 * @since 2019/05/24
 */
interface PlayerDao : JpaRepository<PlayerEntity, Long> {
  fun findByName(name: String): PlayerEntity
}