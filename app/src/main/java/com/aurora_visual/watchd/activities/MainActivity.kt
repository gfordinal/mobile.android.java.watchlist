package com.aurora_visual.watchd.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.roughike.bottombar.OnTabSelectListener
import android.support.v7.widget.LinearLayoutManager
import com.aurora_visual.watchd.R
import com.aurora_visual.watchd.adapters.RecyclerAdapter
import com.aurora_visual.watchd.models.Category
import com.aurora_visual.watchd.network.ImageRequester
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.library_category_item.*
import java.io.IOException
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var categoriesList: ArrayList<Category> = ArrayList()
    private lateinit var imageRequester: ImageRequester

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: RecyclerAdapter


    private val mOnTabSelectListener = OnTabSelectListener { tabId ->
//        when (tabId) {
//            R.id.tab_home -> {
//                category_title!!.setText(R.string.nav_home)
//            }
//            R.id.tab_library -> {
//                category_title!!.setText(R.string.nav_library)
//
////                // Begin the transaction
////                val ft = supportFragmentManager.beginTransaction()
////                // Replace the contents of the container with the new fragment
////                ft.replace(R.id.library_content, LibraryCategoryFragment())
////                // or ft.add(R.id.your_placeholder, new FooFragment());
////                // Complete the changes added above
////                ft.commit()
//            }
//            R.id.tab_settings -> {
//                category_title!!.setText(R.string.nav_settings)
//            }
//            R.id.tab_account -> {
//                category_title!!.setText(R.string.nav_account)
//            }
//        }
    }

    // call super
    // initialize widgets
    // set event listener
    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomBar.setOnTabSelectListener(mOnTabSelectListener)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        adapter = RecyclerAdapter(categoriesList)
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()

        if (categoriesList.size == 0) {
            requestCategory()
        }
    }

    private fun requestCategory() {
        try {
            var cat = Category("Filme")
            receivedNewCategory(cat)

            cat = Category("Personen")
            receivedNewCategory(cat)

            cat = Category("Serien")
            receivedNewCategory(cat)

            cat = Category("Filmreihen")
            receivedNewCategory(cat)
//            imageRequester.getPhoto()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    fun receivedNewCategory(newPhoto: Category) {
        runOnUiThread {
            categoriesList.add(newPhoto)
            adapter.notifyItemInserted(categoriesList.size)
        }
    }

}
