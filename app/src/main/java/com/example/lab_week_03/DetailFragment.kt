package com.example.lab_week_03

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailFragment : Fragment() {

    private val coffeeTitle get() = view?.findViewById<TextView>(R.id.coffee_title)
    private val coffeeDesc  get() = view?.findViewById<TextView>(R.id.coffee_desc)

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coffeeId = arguments?.getInt(COFFEE_ID, 0) ?: 0
        setCoffeeData(coffeeId)
    }

    fun setCoffeeData(id: Int) { /* (sama seperti Part 2) */ }

    companion object {
        private const val COFFEE_ID = "COFFEE_ID"
        fun newInstance(id: Int) = DetailFragment().apply {
            arguments = Bundle().apply { putInt(COFFEE_ID, id) }
        }
    }
}
