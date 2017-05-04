package com.dani.demotwine.repo_list

import android.content.Context
import android.databinding.BaseObservable
import com.dani.demotwine.R
import com.dani.demotwine.models.Repository

/**
 * Created by dani on 3/05/17.
 */
class RepositoryViewModel(val repository: Repository, val context: Context) : BaseObservable() {
    val ownerImageUrl
        get() = repository.ownerImage
    val repositoryName by lazy { repository.repositoryName }
    val repositoryUrl by lazy { repository.repositoryUrl }
    val ownerName by lazy { repository.ownerName }
    val starsString by lazy {
        context.getString(R.string.star_format).format(repository.stars)
    }
}