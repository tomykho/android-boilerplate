package com.boilerplate.model

import org.parceler.Parcel

/**
 * Created by tomykho on 5/22/17.
 */

@Parcel
data class Album(
        var id: Int = 0,
        var title: String = ""
)