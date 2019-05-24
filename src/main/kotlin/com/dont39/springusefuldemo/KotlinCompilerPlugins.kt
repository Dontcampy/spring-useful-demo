package com.dont39.springusefuldemo

/**
 * @author sirius
 * @since 2019/05/24
 */

/**
 * 与kotlin-noarg compiler plugin一起工作，标记的class编译器会生成无参构造函数
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class NoArgConstructor

/**
 * 与kotlin-allopen compiler plugin一起工作，标记的class所有的方法都是open的
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class AllOpen