package com.example.todo.presnation.util

import com.google.gson.Gson

fun<T> T.toJson(): String {
    return Gson().toJson(this)
}

inline fun <reified T> String.toObject(): T? {
    return Gson().fromJson(this, T::class.java)
}
