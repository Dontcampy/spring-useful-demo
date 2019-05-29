package com.dont39.springusefuldemo.msg

import com.dont39.springusefuldemo.NoArgConstructor

/**
 * @author sirius
 * @since 2019/05/28
 */
@NoArgConstructor
open class CommonResponse @JvmOverloads constructor(
    var code: Int = 1,
    var msg: String? = null
) {

  override fun toString(): String {
    return "{code: $code, msg: $msg}"
  }
}

object OkResponse : CommonResponse(0)