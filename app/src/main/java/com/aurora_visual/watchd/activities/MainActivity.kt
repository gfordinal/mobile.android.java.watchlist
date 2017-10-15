package com.aurora_visual.watchd.activities

import android.content.Context
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import com.roughike.bottombar.OnTabSelectListener
import com.aurora_visual.watchd.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mContext: Context
    private set

    private val mOnTabSelectListener = OnTabSelectListener { tabId ->
        var fragment: Fragment? = null
        var background: Int = R.color.mainActivityBackground

        when (tabId) {
            R.id.tab_home       -> {
                fragment = HomeFragment()
                background = R.color.homeBackground
            }
            R.id.tab_library    -> {
                fragment = LibraryRootFragment()
                background = R.color.libraryBackground
            }
            R.id.tab_settings   -> {
                fragment = SettingsFragment()
                background = R.color.settingsBackground
            }
            R.id.tab_account    -> {
                fragment = AccountFragment()
                background = R.color.accountBackground
            }
        }

        container.background = ContextCompat.getDrawable(this, background)

        // append fragment to #content
        if(fragment != null) {
            // Begin the transaction
            val ft = supportFragmentManager.beginTransaction()
            // Replace the contents of the container with the new fragment
            ft.replace(R.id.content, fragment)
            // potentially add to back stack
            ft.addToBackStack(R.id.tab_home.toString())
            // or ft.add(R.id.your_placeholder, new FooFragment());
            // Complete the changes added above
            ft.commit()
        }
    }

    private val mOnBackStackChangedListener = FragmentManager.OnBackStackChangedListener { ->
        // solution not working
        // keep only home and the current tab in the fragment back stack
        // bottomBar.selectTabAtPosition(0)
        // if (supportFragmentManager.backStackEntryCount > 0) {
        //     val first = supportFragmentManager.getBackStackEntryAt(0)
        //     supportFragmentManager.popBackStack(first.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        // }
    }


    // call super
    // initialize widgets
    // set event listener
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.app_name)

        bottomBar.setOnTabSelectListener(mOnTabSelectListener)

        supportFragmentManager.addOnBackStackChangedListener(mOnBackStackChangedListener)
    }

}
