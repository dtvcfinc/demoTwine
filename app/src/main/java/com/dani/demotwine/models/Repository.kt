package com.dani.demotwine.models

/**
 * Created by dani on 3/05/17.
 */
data class Repository(val ownerUrl: String,
                      val ownerName:String,
                      val repositoryName:String,
                      val stars: Int,
                      val watching:Int,
                      val language:String)