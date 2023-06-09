package com.example.resourcemanagers.lookup

import androidx.annotation.StringRes

interface StringLookup {

    fun getString(@StringRes id: Int): String

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String
}