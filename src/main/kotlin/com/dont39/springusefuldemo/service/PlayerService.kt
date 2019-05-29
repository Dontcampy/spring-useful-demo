package com.dont39.springusefuldemo.service

import com.dont39.springusefuldemo.AllOpen
import com.dont39.springusefuldemo.dao.PlayerDao
import com.dont39.springusefuldemo.entity.PlayerEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author sirius
 * @since 2019/05/24
 */
interface PlayerService {
  fun findAllPlayer(): List<PlayerEntity>

  fun findPlayerById(id: Long): PlayerEntity?

  fun findPlayerByName(name: String): PlayerEntity?

  fun save(playerEntity: PlayerEntity): PlayerEntity

  fun delete(id: Long)
}

@Service
@AllOpen
class PlayerServiceImpl @Autowired constructor(
    private val playerDao: PlayerDao
): PlayerService {

  override fun findAllPlayer(): List<PlayerEntity> {
    return playerDao.findAll()
  }

  override fun findPlayerById(id: Long): PlayerEntity? {
    return try {
      playerDao.findById(id).get()
    } catch (e: NoSuchElementException) {
      null
    }
  }

  override fun findPlayerByName(name: String): PlayerEntity? {
    return playerDao.findByName(name)
  }

  override fun save(playerEntity: PlayerEntity): PlayerEntity {
    return playerDao.save(playerEntity)
  }

  override fun delete(id: Long) {
    return playerDao.deleteById(id)
  }
}