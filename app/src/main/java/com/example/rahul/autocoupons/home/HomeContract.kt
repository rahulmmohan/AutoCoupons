package com.example.rahul.autocoupons.brows

import com.example.rahul.autocoupons.data.Site


/**
 * Created by Rahul on 16/01/18.
 */
class HomeContract {

    interface View {
        fun open(site:Site)
    }

    interface Presenter {
        fun loadSiteData()
        fun openSite(index: Int)
    }
}