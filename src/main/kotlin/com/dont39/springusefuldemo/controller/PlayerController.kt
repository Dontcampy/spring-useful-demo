package com.dont39.springusefuldemo.controller

import com.dont39.springusefuldemo.entity.PlayerEntity
import com.dont39.springusefuldemo.exception.EntityNotFoundException
import com.dont39.springusefuldemo.msg.OkResponse
import com.dont39.springusefuldemo.service.PlayerService
import com.dont39.springusefuldemo.util.lzDebug
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author sirius
 * @since 2019/05/24
 */

@RestController
class PlayerController @Autowired constructor(
    private val playerService: PlayerService
) {

  private val logger = LoggerFactory.getLogger(javaClass)

  @RequestMapping(path = ["/player"], method = [RequestMethod.GET])
  fun getAllPlayer(): List<PlayerEntity> {
    logger.lzDebug { "获取所有玩家" }
    return playerService.findAllPlayer()
  }

  @RequestMapping(path = ["/player/{id}"], method = [RequestMethod.GET])
  fun getPlayer(@PathVariable id: Long): PlayerEntity {
    return findPlayerById(id)
  }

  @RequestMapping(path = ["/player"], method = [RequestMethod.POST])
  fun addPlayer(@RequestBody playerEntity: PlayerEntity): PlayerEntity {
    return playerService.save(playerEntity)
  }

  @RequestMapping(path = ["/player/{id}"], method = [RequestMethod.PUT])
  fun setPlayer(@PathVariable id: Long, @RequestBody playerEntity: PlayerEntity): PlayerEntity {
    val player = findPlayerById(id)
    player.name = playerEntity.name
    return playerService.save(player)
  }

  @RequestMapping(path = ["/player/{id}"], method = [RequestMethod.DELETE])
  fun deletePlayer(@PathVariable id: Long): OkResponse {
    playerService.delete(id)
    return OkResponse
  }

  @Throws(EntityNotFoundException::class)
  private fun findPlayerById(id: Long): PlayerEntity {
    return playerService.findPlayerById(id) ?: throw EntityNotFoundException("Player Entity not found.")
  }
}