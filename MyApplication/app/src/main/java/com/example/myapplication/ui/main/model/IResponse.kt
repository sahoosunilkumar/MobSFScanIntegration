package com.example.myapplication.ui.main.model

/**
 * Type for response details
 *
 * @param <T> type
 **/
interface IResponse<T> {
    fun getData(): T?

    fun getError(): Throwable?

    fun getState(): Int
}
