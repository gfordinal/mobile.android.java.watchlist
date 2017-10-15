package com.aurora_visual.watchd

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.aurora_visual.watchd.adapters.LibraryAdapter
import com.aurora_visual.watchd.models.Category
import kotlinx.android.synthetic.main.fragment_library_root.*
import java.io.IOException
import java.util.ArrayList
import android.support.v7.widget.DefaultItemAnimator
import com.aurora_visual.watchd.models.Categories


/**
 * Created by admin on 08.10.17.
 */

class LibraryRootFragment : Fragment() {

    private var categoriesList: ArrayList<Category> = ArrayList()

    private lateinit var gridLayoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: LibraryAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_library_root, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        gridLayoutManager = GridLayoutManager(activity, 2)
        adapter = LibraryAdapter(categoriesList)

        categoryRecycler.layoutManager = gridLayoutManager
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
            var cat = Category(Categories.MOVIES, resources)
            receivedNewCategory(cat)

            cat = Category(Categories.PEOPLE, resources)
            receivedNewCategory(cat)

            cat = Category(Categories.SERIES, resources)
            receivedNewCategory(cat)

            cat = Category(Categories.COLLECTIONS, resources)
            receivedNewCategory(cat)
//            imageRequester.getPhoto()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    fun receivedNewCategory(newCategory: Category) {
        activity.runOnUiThread {
            categoriesList.add(newCategory)
            adapter.notifyItemInserted(categoriesList.size)
        }
    }
}