package com.aurora_visual.watchd.activities

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.widget.TextView
import com.roughike.bottombar.OnTabSelectListener
import android.support.v7.widget.LinearLayoutManager
import com.aurora_visual.watchd.LibraryRootFragment
import com.aurora_visual.watchd.R
import com.aurora_visual.watchd.adapters.RecyclerAdapter
import com.aurora_visual.watchd.models.Category
import com.aurora_visual.watchd.network.ImageRequester
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.library_category_item.*
import java.io.IOException
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val mOnTabSelectListener = OnTabSelectListener { tabId ->
        var fragment: Fragment? = null

        when (tabId) {
            R.id.tab_home       -> { /* fragment = ... */ }
            R.id.tab_library    -> { fragment = LibraryRootFragment() }
            R.id.tab_settings   -> { /* fragment = ... */ }
            R.id.tab_account    -> { /* fragment = ... */ }
        }

        // append fragment to #content
        if(fragment != null) {
            // Begin the transaction
            val ft = supportFragmentManager.beginTransaction()
            // Replace the contents of the container with the new fragment
            ft.replace(R.id.content, fragment)
            // or ft.add(R.id.your_placeholder, new FooFragment());
            // Complete the changes added above
            ft.commit()
        }
    }

    // call super
    // initialize widgets
    // set event listener
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomBar.setOnTabSelectListener(mOnTabSelectListener)
    }

}
