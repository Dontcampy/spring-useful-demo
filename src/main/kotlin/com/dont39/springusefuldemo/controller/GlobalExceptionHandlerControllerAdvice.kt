package com.dont39.springusefuldemo.controller

import com.dont39.springusefuldemo.exception.EntityNotFoundException
import com.dont39.springusefuldemo.msg.CommonResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @author sirius
 * @since 2019/05/28
 */
@RestControllerAdvice
class GlobalExceptionHandlerControllerAdvice {
  @ResponseStatus(value = HttpStatus.NOT_FOUND) // 如果定义的reason，method返回的Response会被强制覆盖掉
  @ExceptionHandler(EntityNotFoundException::class)
  fun handleEntityNotFoundException(exp: EntityNotFoundException): CommonResponse {
    return CommonResponse(code = 1, msg = exp.msg)
  }
}