package com.aurora_visual.watchd

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.roughike.bottombar.BottomBar
import com.roughike.bottombar.OnTabSelectListener
import android.support.annotation.IdRes
import com.aurora_visual.watchd.R.id.bottomBar
import com.aurora_visual.watchd.R.id.bottomBar
import com.aurora_visual.watchd.R.id.bottomBar







class MainActivity : AppCompatActivity() {

    private var mTextMessage: TextView? = null

    private val mOnTabSelectListener = OnTabSelectListener { tabId ->
        when (tabId) {
            R.id.tab_home -> {
                mTextMessage!!.setText(R.string.nav_home)
            }
            R.id.tab_library -> {
                mTextMessage!!.setText(R.string.nav_library)
            }
            R.id.tab_settings -> {
                mTextMessage!!.setText(R.string.nav_settings)
            }
            R.id.tab_account -> {
                mTextMessage!!.setText(R.string.nav_account)
            }
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mTextMessage!!.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mTextMessage!!.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mTextMessage!!.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override // call super
            // initialize widgets
            // set event listener
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextMessage = findViewById(R.id.message) as TextView
        val bottomBar = findViewById(R.id.bottomBar) as BottomBar
        bottomBar.setOnTabSelectListener(mOnTabSelectListener)
    }

}
