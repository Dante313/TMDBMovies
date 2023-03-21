package com.example.resourcemanagers.lookup

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StringLookupImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : StringLookup {

    override fun getString(id: Int) = context.getString(id)

    override fun getString(id: Int, vararg formatArgs: Any) = context.getString(id, *formatArgs)
}