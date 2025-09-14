package com.example.lab_week_03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        val coffeeTitle = view.findViewById<TextView>(R.id.coffee_title)
        val coffeeDesc = view.findViewById<TextView>(R.id.coffee_desc)
        val backButton = view.findViewById<Button>(R.id.back_button)

        coffeeTitle.text = arguments?.getString("coffee_name")
        coffeeDesc.text = arguments?.getString("coffee_desc")

        backButton.setOnClickListener {
            parentFragmentManager.popBackStack() // kembali ke ListFragment
        }

        return view
    }
}
