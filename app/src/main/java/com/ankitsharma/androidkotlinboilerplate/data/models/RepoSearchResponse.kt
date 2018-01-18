package com.ankitsharma.androidkotlinboilerplate.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by ankitsharma on 18/01/18.
 */
class RepoSearchResponse {

    @SerializedName("total_count")
    var totalCount: Int = -1

    @SerializedName("items")
    var repoList: List<RepoDTO> = ArrayList()
}