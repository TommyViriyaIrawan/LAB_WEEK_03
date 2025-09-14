package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private val coffeeList = arrayOf(
        "Affogato",
        "Americano",
        "Cappuccino",
        "Espresso",
        "Latte",
        "Mocha"
    )

    private val coffeeDescriptions = arrayOf(
        "Espresso poured on a vanilla ice cream. Served in a cappuccino cup.",
        "Espresso with added hot water.",
        "Espresso with steamed milk and milk foam.",
        "Strong, concentrated coffee served in a small cup.",
        "Espresso with steamed milk, usually topped with a small amount of foam.",
        "Espresso with steamed milk and chocolate syrup."
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val listView = view.findViewById<ListView>(R.id.coffee_list_view)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, coffeeList)
        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                // Kirim data ke DetailFragment
                val detailFragment = DetailFragment().apply {
                    arguments = Bundle().apply {
                        putString("coffee_name", coffeeList[position])
                        putString("coffee_desc", coffeeDescriptions[position])
                    }
                }

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .addToBackStack(null) // supaya bisa tekan Back
                    .commit()
            }

        return view
    }
}
