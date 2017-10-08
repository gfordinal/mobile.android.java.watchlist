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

                // Begin the transaction
                val ft = supportFragmentManager.beginTransaction()
                // Replace the contents of the container with the new fragment
                ft.replace(R.id.library_content, LibraryCategoryFragment())
                // or ft.add(R.id.your_placeholder, new FooFragment());
                // Complete the changes added above
                ft.commit()
            }
            R.id.tab_settings -> {
                mTextMessage!!.setText(R.string.nav_settings)
            }
            R.id.tab_account -> {
                mTextMessage!!.setText(R.string.nav_account)
            }
        }
    }

    // call super
    // initialize widgets
    // set event listener
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextMessage = findViewById(R.id.message) as TextView
        val bottomBar = findViewById(R.id.bottomBar) as BottomBar
        bottomBar.setOnTabSelectListener(mOnTabSelectListener)
    }

}
