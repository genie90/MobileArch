package com.genie.domain.entity

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
data class WrapperEntity<T>(val data: T?, val throwable: Throwable?, val code: Int)