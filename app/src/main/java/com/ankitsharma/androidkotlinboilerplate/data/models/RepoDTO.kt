package com.ankitsharma.androidkotlinboilerplate.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by ankitsharma on 18/01/18.
 */
class RepoDTO {

    @SerializedName("id")
    var id: Int = -1

    @SerializedName("stargazers_count")
    var stargazers_count : Int = 0

    @SerializedName("full_name")
    var fullName: String = ""

    @SerializedName("description")
    var description: String = ""
}