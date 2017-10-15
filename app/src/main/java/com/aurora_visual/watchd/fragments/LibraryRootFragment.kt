package com.aurora_visual.watchd

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.aurora_visual.watchd.adapters.RecyclerAdapter
import com.aurora_visual.watchd.models.Category
import com.aurora_visual.watchd.network.ImageRequester
import kotlinx.android.synthetic.main.fragment_library_root.*
import java.io.IOException
import java.util.ArrayList
import android.support.v7.widget.DefaultItemAnimator




/**
 * Created by admin on 08.10.17.
 */

class LibraryRootFragment : Fragment() {

    private var categoriesList: ArrayList<Category> = ArrayList()
    private lateinit var imageRequester: ImageRequester

    private lateinit var gridLayoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_library_root, container, false)

        gridLayoutManager = GridLayoutManager(activity, 2)
        adapter = RecyclerAdapter(categoriesList)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //gridLayoutManager = GridLayoutManager(activity, 2)
        categoryRecycler.layoutManager = gridLayoutManager
        //adapter = RecyclerAdapter(categoriesList)
        categoryRecycler.adapter = adapter
        categoryRecycler.itemAnimator = DefaultItemAnimator()
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
        activity.runOnUiThread {
            categoriesList.add(newPhoto)
            adapter.notifyItemInserted(categoriesList.size)
        }
    }
}