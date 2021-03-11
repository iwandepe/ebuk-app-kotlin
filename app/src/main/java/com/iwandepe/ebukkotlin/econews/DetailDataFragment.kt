package com.iwandepe.ebukkotlin.econews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.iwandepe.ebukkotlin.R
import com.iwandepe.ebukkotlin.databinding.FragmentDetailDataBinding

class DetailDataFragment : Fragment() {
    val args: DetailDataFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentDetailDataBinding> (inflater, R.layout.fragment_detail_data, container, false)

        val webView = binding.detailWebView
        webView.loadUrl(args.linkToWeb)

        // Just configuration, do it haha. IDK
        val webSettings: WebSettings = webView.getSettings()
        webSettings.javaScriptEnabled = true
        webView.setWebViewClient(WebViewClient())

        return binding.root
    }
}