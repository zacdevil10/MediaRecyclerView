package uk.co.zac_h.mediarecyclerview.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MediaModel(
    val url: String,
    val type: Int,
    val static: String = ""
) : Parcelable