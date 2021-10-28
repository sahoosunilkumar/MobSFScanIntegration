package com.example.myapplication.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.ui.main.model.BaseStateResponse
import com.example.myapplication.ui.main.model.State
import com.example.myapplication.ui.main.model.Todo
import android.net.http.SslError

import android.webkit.SslErrorHandler

import android.webkit.WebViewClient




class MainFragment : Fragment(), Observer<BaseStateResponse<Todo>> {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var message: TextView? = null
    private var progressbar: ProgressBar? = null

    private val url1 = "https://wrong.host.badssl.com/"
    private val url2 = "https://untrusted-root.badssl.com/"
    private var myUrl = url1
    private fun getUrl():String{
        if (myUrl == url1){
            myUrl = url2
        }else{
            myUrl = url1
        }
        return myUrl
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.response.observe(viewLifecycleOwner, this)
        viewModel.execute()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message = view.findViewById(R.id.message)
        progressbar = view.findViewById(R.id.progress_bar)
        val webView = view.findViewById<WebView>(R.id.webView)
        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedSslError(
                view: WebView,
                handler: SslErrorHandler,
                error: SslError
            ) {
                handler.proceed() // Ignore SSL certificate errors
            }
        }
        webView.loadUrl(getUrl())
//        val toolBar = view.findViewById<Toolbar>(R.id.toolbar)
        val button:Button = view.findViewById(R.id.button)
        button.setOnClickListener {
            webView.loadUrl(getUrl())
            viewModel.execute()
        }
    }

    override fun onChanged(t: BaseStateResponse<Todo>?) {
        t?.let {
            message?.text=""
            if (t.currentState == State.IN_PROGRESS){
                progressbar?.visibility=View.VISIBLE
                return
            }

            progressbar?.visibility=View.GONE

            if (t.currentState== State.ERROR){
                Toast.makeText(context, "something went wrong", Toast.LENGTH_LONG).show()
            }else if (t.currentState == State.SUCCESS){
                message?.text=t.currentData?.title
            }
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }

}