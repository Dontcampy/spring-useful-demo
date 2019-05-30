package com.dont39.springusefuldemo.util

import org.slf4j.Logger

/**
 * @author sirius
 * @since 2019/05/30
 */
inline fun Logger.lzDebug(buildMsg: () -> String) {
  if (isDebugEnabled) {
    debug(buildMsg())
  }
}

inline fun Logger.lzInfo(buildMsg: () -> String) {
  if (isInfoEnabled) {
    info(buildMsg())
  }
}

inline fun Logger.lzTrace(buildMsg: () -> String) {
  if (isTraceEnabled) {
    trace(buildMsg())
  }
}

inline fun Logger.lzWarn(buildMsg: () -> String) {
  if (isWarnEnabled) {
    warn(buildMsg())
  }
}