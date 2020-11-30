package com.genie.domain.interfaces

import com.genie.domain.entity.MovieEntity

/**
 * Created by viet.tr90@gmail.com on 2/8/20.
 */
interface MovieInterface {
    fun getPopularMovieList(page: Int): List<MovieEntity>
}