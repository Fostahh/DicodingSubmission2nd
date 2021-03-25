package com.mohammadazri.MyBestRecyclerViewSoFar.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var avatar: Int? = null,
    var username: String? = null,
    var name: String? = null,
    var description: String? = null,
    var follower: Int? = null,
    var following: Int? = null,
    var location: String? = null,
    var company: String? = null,
    var repositories: ArrayList<Repository>? = null
) : Parcelable
