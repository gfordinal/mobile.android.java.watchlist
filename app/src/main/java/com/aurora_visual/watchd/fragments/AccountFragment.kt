package com.aurora_visual.watchd

import android.os.Bundle
import android.support.v4.app.Fragment
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

class AccountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // ...
    }

    override fun onStart() {
        super.onStart()

        // ...
    }
}