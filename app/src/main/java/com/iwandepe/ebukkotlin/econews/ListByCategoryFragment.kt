package com.iwandepe.ebukkotlin.econews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.iwandepe.ebukkotlin.R
import com.iwandepe.ebukkotlin.databinding.FragmentListByCategoryBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListByCategoryFragment : Fragment() {
    var dataSet: MutableList<Article> = mutableListOf()
    lateinit var recyclerView: RecyclerView
    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var newsCategory: String
    val args: ListByCategoryFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentListByCategoryBinding>(inflater, R.layout.fragment_list_by_category, container, false)

        recyclerViewAdapter = RecyclerViewAdapter(dataSet, R.layout.econews_rv_row_item)
        recyclerView = binding.econewsRecyclerView
        recyclerView.adapter = recyclerViewAdapter

        newsCategory = args.country

        val newsapiService = NewsSevices.create()
        val call = newsapiService.getArticlesList(newsCategory)
        call.enqueue(object: Callback<NewsResponse> {
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                println("Failure")
            }

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.body() != null) {
                    var data: NewsResponse = response.body()!!
                    dataSet.addAll(data!!.articles)
                    println(dataSet)
                    if (dataSet != null) {
                        println("Dataset isnt null")
                        recyclerViewAdapter.notifyDataSetChanged()
                    }
                } else {
                    println("response body null")
                }
            }
        })


        return binding.root
    }
}