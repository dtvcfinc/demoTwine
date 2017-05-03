package com.dani.demotwine.viewmodels

import android.databinding.BaseObservable
import com.dani.demotwine.models.Repository

/**
 * Created by dani on 3/05/17.
 */
class RespositoryViewModel(val repository: Repository) : BaseObservable() {
    val ownerUrl
        get() = repository.ownerUrl
    val repositoryName
        get() = repository.repositoryName
}