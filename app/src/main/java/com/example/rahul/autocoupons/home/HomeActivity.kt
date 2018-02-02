package com.example.rahul.autocoupons.brows

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.rahul.autocoupons.R
import kotlinx.android.synthetic.main.activity_web.*
import com.example.rahul.autocoupons.data.Constants
import com.example.rahul.autocoupons.data.Site
import kotlinx.android.synthetic.main.content_home.*


class HomeActivity : AppCompatActivity(), HomeContract.View {


    private lateinit var mPresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)
        mPresenter = HomePresenter(this, this)
        button1.setOnClickListener { mPresenter.openSite(Constants.JABONG_CODE) }
        button2.setOnClickListener { mPresenter.openSite(Constants.MYNTRA_CODE) }
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadSiteData();
    }

    override fun open(site: Site) {
        val intent = Intent(this,WebActivity::class.java)
        intent.putExtra("site",site)
        startActivity(intent)
    }

}
