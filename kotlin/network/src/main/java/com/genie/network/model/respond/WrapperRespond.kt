package com.genie.network.model.respond

/**
 * Created by viet.tr90@gmail.com on 25/9/20.
 */
data class WrapperRespond<T>(val data: T?, val throwable: Throwable?, val code: Int)