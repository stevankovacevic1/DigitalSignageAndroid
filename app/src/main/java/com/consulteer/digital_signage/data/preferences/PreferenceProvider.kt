package com.consulteer.digital_signage.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


private const val KEY_SAVED_AT= "key_saved_at"
class PreferenceProvider(
    context:Context

){
    private val appContext = context.applicationContext// getting all application context
    private val preference: SharedPreferences
    get() = PreferenceManager.getDefaultSharedPreferences(appContext)

    fun saveLastSavedAt(savedAt: String){
        preference.edit().putString(
            KEY_SAVED_AT,savedAt
        ).apply()

    }

    fun getLastSAvedAt() : String? {
        return preference.getString(KEY_SAVED_AT, null)



    }



}