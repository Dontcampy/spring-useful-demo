package com.dont39.springusefuldemo.config

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer
import com.dont39.springusefuldemo.AllOpen
import com.dont39.springusefuldemo.CACHE_MANAGER_LOCAL
import com.dont39.springusefuldemo.CACHE_PLAYER_ID
import com.dont39.springusefuldemo.entity.PlayerEntity
import com.fasterxml.jackson.core.type.TypeReference
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CachingConfigurerSupport
import org.springframework.cache.concurrent.ConcurrentMapCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.time.Duration

/**
 * @author sirius
 * @since 2019/05/30
 */
@Configuration
@AllOpen
class CacheConfig : CachingConfigurerSupport() {

  object ListPlayerEntityTypeRef: TypeReference<List<PlayerEntity>>()

  @Bean
  @Primary
  fun redisCacheManager(factory: RedisConnectionFactory): CacheManager {
    val redisKeySerializer = StringRedisSerializer()
    val redisValueSerializer = GenericFastJsonRedisSerializer()

    val config = RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(Duration.ofHours(2))
        .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(redisKeySerializer))
        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisValueSerializer))

    val configMap = hashMapOf<String, RedisCacheConfiguration>()
    configMap[CACHE_PLAYER_ID] = config
        .entryTtl(Duration.ofSeconds(60))
        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(Jackson2JsonRedisSerializer(PlayerEntity::class.java)))
    return RedisCacheManager.builder(factory)
        .initialCacheNames(configMap.keys)
        .cacheDefaults(config)
        .withInitialCacheConfigurations(configMap)
        .build()
  }

  @Bean(name = [CACHE_MANAGER_LOCAL])
  fun localCacheManager(): CacheManager = ConcurrentMapCacheManager()
}