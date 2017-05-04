package com.dani.demotwine.repositories

import com.dani.demotwine.response_objects.Repositories
import retrofit2.http.GET
import rx.Observable

/**
 * Created by dani on 3/05/17.
 */
interface Api {
    @GET("search/repositories?q=language:kotlin&sort=stars&order=desc")
    fun getMostFamousKotlinRepo(): Observable<Repositories>
}