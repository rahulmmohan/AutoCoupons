package com.example.rahul.autocoupons.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable




/**
 * Created by rahul on 2/2/18.
 */
class Site:Serializable {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("cart_url")
    @Expose
    var cartUrl: String? = null
    @SerializedName("coupon_url")
    @Expose
    var couponUrl: String? = null
    @SerializedName("coupon_code")
    @Expose
    var couponCode: Int = 0
    @SerializedName("coupons")
    @Expose
    var coupons: List<String>? = null
    @SerializedName("actions")
    @Expose
    var actions: Actions? = null
}