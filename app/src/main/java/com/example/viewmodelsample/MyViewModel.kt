package com.example.viewmodelsample

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel :ViewModel() {

    private val _counter = mutableStateOf(0)
    val counter: State<Int> get() = _counter
    fun incrementCounter()
    {
        _counter.value++
    }
    fun decrementCounter()
    {
        _counter.value--
    }
}