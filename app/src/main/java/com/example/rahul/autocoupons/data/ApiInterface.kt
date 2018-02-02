package com.example.rahul.autocoupons.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by rahul on 2/2/18.
 */
interface ApiInterface {

    @GET("getCoupons.php")
    fun getCoupons(@Query("pos") site: Int): Call<String>
}