package com.example.myapplication.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.ui.main.datasource.NetworkService
import com.example.myapplication.ui.main.model.BaseStateResponse
import com.example.myapplication.ui.main.model.State
import com.example.myapplication.ui.main.model.Todo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    val response = MutableLiveData<BaseStateResponse<Todo>>()
    val apiKey = "AIzaSyAGhQDTiy4DMxNvzzaCLeoPuKFV4pVloJU"
    fun execute() {
        response.postValue(BaseStateResponse(State.IN_PROGRESS))
        NetworkService.getService().todo.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe({
            response.postValue(BaseStateResponse(it))
        }, {
            response.postValue(BaseStateResponse(it))
        })
    }
}