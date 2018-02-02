package com.example.rahul.autocoupons.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by rahul on 2/2/18.
 */
class SitesData {
    @SerializedName("sites")
    @Expose
    var sites: List<Site>? = null
}