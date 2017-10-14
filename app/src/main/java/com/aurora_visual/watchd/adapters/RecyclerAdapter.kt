package com.aurora_visual.watchd.adapters
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.aurora_visual.watchd.R
import com.aurora_visual.watchd.extensions.inflate
import com.aurora_visual.watchd.models.Category
import kotlinx.android.synthetic.main.library_category_item.view.*


/**
 * Created by admin on 14.10.17.
 */
class RecyclerAdapter(private val categories: ArrayList<Category>)  : RecyclerView.Adapter<RecyclerAdapter.CategoryHolder>()  {
    override fun getItemCount() = categories.size
    override fun onBindViewHolder(holder: RecyclerAdapter.CategoryHolder, position: Int) {
        val itemCategory= categories[position]
        holder.bindCategory(itemCategory)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.CategoryHolder {
        val inflatedView = parent.inflate(R.layout.library_category_item, false)
        return CategoryHolder(inflatedView)
    }

    /* */
    class CategoryHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        //2
        private var view: View = v
        private var category: Category? = null

        //3
        init {
            v.setOnClickListener(this)
        }

        //4
        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        fun bindCategory(category: Category) {
            this.category = category
            view.category_title.text = category.name
        }

        companion object {
            //5
            private val PHOTO_KEY = "PHOTO"
        }
    }
}