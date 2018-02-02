package com.example.rahul.autocoupons.brows

import android.content.Context
import android.util.Log
import com.example.rahul.autocoupons.data.ApiClient
import com.example.rahul.autocoupons.data.ApiInterface
import com.example.rahul.autocoupons.data.Site
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by rahul on 2/2/18.
 */

/**
 * Listens to user actions from the UI ([HomeActivity]), retrieves the data and updates
 * the UI as required.
 */
class WebPresenter(context: Context,
                   private val mWebActivity: WebContract.View,val site:Site) : WebContract.Presenter {

    private val apiService = ApiClient.getClient().create(ApiInterface::class.java)

    override fun fetchCoupons() {
        apiService.getCoupons(site.couponCode).enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                Log.d("onFailure",t!!.message)
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                Log.d("onResponse",response!!.body())
                if(response!!.body()!=null) {
                    convertToList(response.body()!!)
                }
            }

        })
    }

    private fun convertToList(body: String) {
        val coupons = body.split("~").dropLast(1)
        site.coupons = coupons
    }
}
