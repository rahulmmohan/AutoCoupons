package com.example.rahul.autocoupons.data

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


/**
 * Created by rahul on 2/2/18.
 */
object ApiClient {
        val BASE_URL = "http://coupons.buyhatke.com/PickCoupon/FreshCoupon/"
        private var retrofit: Retrofit? = null
        fun getClient(): Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }
    }