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
  fun findPlayerById(id: Long): PlayerEntity?

  fun findPlayerByName(name: String): PlayerEntity?
}

@Service
@AllOpen
class PlayerServiceImpl @Autowired constructor(
    private val playerDao: PlayerDao
): PlayerService {
  override fun findPlayerById(id: Long): PlayerEntity? {
    return playerDao.findById(id).get()
  }

  override fun findPlayerByName(name: String): PlayerEntity? {
    return playerDao.findByName(name)
  }
}