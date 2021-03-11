package com.iwandepe.ebukkotlin.econews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.iwandepe.ebukkotlin.R
import com.iwandepe.ebukkotlin.databinding.FragmentCategoryListBinding

class CategoryListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentCategoryListBinding>(inflater, R.layout.fragment_category_list, container, false)

        // This is dumb category but lets do it
        val categories = listOf("Indonesia", "United States", "Japan", "Russia")
        val countriesId = listOf("id", "us", "jp", "ru")

        // set an adapter to listView
        binding.categoryListView.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, categories)

        // set click listener and link to list fragment
        binding.categoryListView.setOnItemClickListener { parent, view, position, id ->
            val action = CategoryListFragmentDirections.actionCategoryListFragmentToListByCategoryFragment(countriesId[position])
            view.findNavController().navigate(action)
        }

        return binding.root
    }
}