package com.example.rahul.autocoupons.brows

import android.content.Context
import android.util.Log
import com.example.rahul.autocoupons.R
import com.example.rahul.autocoupons.data.ApiClient
import com.example.rahul.autocoupons.data.ApiInterface
import com.example.rahul.autocoupons.data.SitesData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader


/**
 * Created by rahul on 2/2/18.
 */

/**
 * Listens to user actions from the UI ([HomeActivity]), retrieves the data and updates
 * the UI as required.
 */
class HomePresenter(val context: Context,
                    private val mHomeActivity: HomeContract.View) : HomeContract.Presenter {


    private lateinit var sitesData: SitesData

    override fun loadSiteData() {
        val raw = context.resources.openRawResource(R.raw.sites)
        val rd = BufferedReader(InputStreamReader(raw))
        val gson = Gson()
         sitesData = gson.fromJson(rd, SitesData::class.java)
    }

    override fun openSite(index: Int) {
        mHomeActivity.open(sitesData.sites!![index])
    }

}
