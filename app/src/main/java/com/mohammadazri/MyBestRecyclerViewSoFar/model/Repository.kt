package com.mohammadazri.MyBestRecyclerViewSoFar.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repository(
    val name: String?,
    val description: String?,
    val numberOfStars: Int?,
    val language: String?
): Parcelable
