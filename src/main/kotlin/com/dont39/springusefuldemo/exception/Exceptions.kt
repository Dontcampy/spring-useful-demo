package com.dont39.springusefuldemo.exception

/**
 * @author sirius
 * @since 2019/05/28
 */
data class EntityNotFoundException(val msg: String) : RuntimeException(msg)
