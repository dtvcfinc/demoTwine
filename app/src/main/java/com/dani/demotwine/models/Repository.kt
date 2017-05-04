package com.dani.demotwine.models

import java.io.Serializable

/**
 * Created by dani on 3/05/17.
 */
data class Repository(val ownerImage: String,
                      val ownerName:String,
                      val repositoryName:String,
                      val repositoryUrl:String,
                      val stars: Int,
                      val watching:Int,
                      val language:String): Serializable