package uk.co.zac_h.mediarecyclerview.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import uk.co.zac_h.mediarecyclerview.utils.MediaType

@Parcelize
data class MediaModel(
    val url: String? = null,
    val res: Int? = null,
    val static: String? = null,
    val type: MediaType
) : Parcelable