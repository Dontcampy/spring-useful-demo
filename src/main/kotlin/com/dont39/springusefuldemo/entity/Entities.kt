package com.dont39.springusefuldemo.entity

import javax.persistence.*

/**
 * @author sirius
 * @since 2019/05/24
 */
@Entity
@Table(name = "player", indexes = [
  Index(name = "idx_name", columnList = "name")
])

data class PlayerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // 只是为了展示这个注解的name属性
    var id: Long?,

    @Column
    var name: String
)