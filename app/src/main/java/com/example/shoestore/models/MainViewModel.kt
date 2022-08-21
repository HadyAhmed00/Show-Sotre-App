package com.example.shoestore.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.data.Show

class MainViewModel : ViewModel() {
    private val _show= MutableLiveData<MutableList<Show>>()
    val show : LiveData<MutableList<Show>> = _show

    init {
        Log.i("MainViewModel","created for time")
        _show.value = arrayListOf()
    }
    fun addShow(show: Show) {
        _show.value?.add(show)
    }
}