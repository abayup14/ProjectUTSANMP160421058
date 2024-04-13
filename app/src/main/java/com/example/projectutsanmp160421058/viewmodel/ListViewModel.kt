package com.example.projectutsanmp160421058.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.projectutsanmp160421058.model.FootballManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application): AndroidViewModel(application) {
    val listDataLD = MutableLiveData<ArrayList<FootballManager>>()
    val loadLD = MutableLiveData<Boolean>()
    val errorLD = MutableLiveData<Boolean>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        loadLD.value = true
        errorLD.value = true

        Log.d("volley", "masukvolley")

        queue = Volley.newRequestQueue(getApplication())

        val url = "http://10.0.2.2/project_uts_anmp/football_manager.json"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                val sType = object : TypeToken<List<FootballManager>>() { }.type
                val res = Gson().fromJson<List<FootballManager>>(it, sType)
                listDataLD.value = res as ArrayList<FootballManager>?
                loadLD.value = false

                Log.d("data", res.toString())
                Log.d("data", it)
            },
            {
                Log.d("showvolley", it.toString())
                loadLD.value = false
                errorLD.value = false
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)

        loadLD.value = false
        errorLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}