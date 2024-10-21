package com.kodiiiofc.urbanuniversity.internetmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CheckFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_check, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val checkTV = view.findViewById<TextView>(R.id.tv_check)
        checkTV.text = generateCheck()
    }

    private fun generateCheck(): String {

        return getString(R.string.tv_check) + (1..10000).random() +
                "\n\n" + toString(Items.getCartWithCount()) +
                "\n\n" + "ИТОГО: ${getSummaryOfCart(Items.getCartWithCount())} $"


    }

    private fun toString(map: Map<Item, Int>) : String {
        val stringBuilder = StringBuilder()
        var counter = 0
        for (entry in map) {
            counter++
            stringBuilder.append("$counter) ${entry.key.name} - ${entry.value} шт.: ${entry.value * entry.key.price} $\n")
        }
        return stringBuilder.toString()
    }

    private fun getSummaryOfCart(map: Map<Item, Int>) : Int {
        var sum = 0
        map.forEach {key, value ->
            sum += key.price * value
        }
        return sum
    }
}