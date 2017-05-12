package com.dani.demotwine.repositories

import com.dani.demotwine.models.Repository
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Single
import rx.schedulers.Schedulers

/**
 * Created by dani on 3/05/17.
 */
object GitHub {
    private val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        retrofit.create(Api::class.java)
    }

    fun getRepos(): Single<List<Repository>> {
        return instance.getMostFamousKotlinRepo()
                .map {
                    response ->
                    response.items.map {
                        item ->
                        Repository(ownerImage = item.owner.avatarUrl,
                                language = item.language,
                                ownerName = item.owner.login,
                                repositoryName = item.fullName,
                                repositoryUrl = item.htmlUrl,
                                stars = item.stargazersCount,
                                watching = item.watchers)
                    }
                }.toSingle()
    }
}