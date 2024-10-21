package com.kodiiiofc.urbanuniversity.internetmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MarketFragment : Fragment() {

    private lateinit var itemsRV: RecyclerView
    private lateinit var marketFAB: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_market, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsRV = view.findViewById(R.id.rv_items)
        marketFAB = view.findViewById(R.id.fab_market)

        val adapter = ItemsAdapter(requireContext(), Items.list)
        itemsRV.adapter = adapter
        adapter.setOnItemClickListener {
            val item = Items.list[it]
            val dialog = AlertDialog.Builder(requireContext())
            dialog.setTitle("Внимание!")
                .setMessage("Вы хотите добавить ${item.name} в корзину?")
                .setPositiveButton("В корзину") { dialog, _ ->
                    addToCart(item)
                    dialog.dismiss()
                }
                .setNeutralButton("Отмена", null)
                .create().show()
        }

        marketFAB.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.cl_main, CartFragment())
                .commit()
        }

    }

    private fun addToCart(item: Item) {
        Items.cart += item
    }

}