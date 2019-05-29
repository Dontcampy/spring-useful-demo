package com.dont39.springusefuldemo.controller

import com.alibaba.fastjson.JSON
import com.dont39.springusefuldemo.entity.PlayerEntity
import com.dont39.springusefuldemo.exception.EntityNotFoundException
import com.dont39.springusefuldemo.msg.CommonResponse
import com.dont39.springusefuldemo.msg.OkResponse
import com.dont39.springusefuldemo.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletResponse

/**
 * @author sirius
 * @since 2019/05/24
 */

@RestController
class PlayerController @Autowired constructor(
    private val playerService: PlayerService
) {
  @RequestMapping(path = ["/player"], method = [RequestMethod.GET])
  fun getAllPlayer(): List<PlayerEntity> {
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