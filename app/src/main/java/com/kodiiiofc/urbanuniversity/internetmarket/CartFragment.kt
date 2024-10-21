package com.kodiiiofc.urbanuniversity.internetmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CartFragment : Fragment() {

    private lateinit var itemsRV: RecyclerView
    private lateinit var fab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsRV = view.findViewById(R.id.rv_items_cart)
        fab = view.findViewById(R.id.fab_cart)

        val cartWithCount = Items.getCartWithCount()
        val adapter = ItemsCartAdapter(requireContext(), cartWithCount)
        itemsRV.adapter = adapter

        fab.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.cl_main, CheckFragment())
                .commit()
        }
    }
}