package com.example.rahul.autocoupons.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 * Created by rahul on 2/2/18.
 */
class Actions:Serializable{
    @SerializedName("open_coupon_window")
    @Expose
    var openCouponWindow: String? = null
    @SerializedName("enter_coupon_code")
    @Expose
    var enterCouponCode: String? = null
    @SerializedName("apply_coupon")
    @Expose
    var applyCoupon: String? = null
    @SerializedName("get_total_price")
    @Expose
    var getTotalPrice: String? = null
}