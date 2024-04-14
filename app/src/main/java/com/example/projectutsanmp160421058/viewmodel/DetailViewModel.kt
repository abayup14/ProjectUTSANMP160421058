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
import org.json.JSONArray
import org.json.JSONObject

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val dataLD = MutableLiveData<FootballManager>()
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun fetch(id: Int) {
        Log.d("volley", "masukvolley")

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/project_uts_anmp/football_manager.json?"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                Log.d("showvolley", it)
                val sType = object : TypeToken<List<FootballManager>>() { }.type
                val res = Gson().fromJson<List<FootballManager>>(it, sType)
                dataLD.value = res[id - 1] as FootballManager
//                val listData = res as ArrayList<FootballManager>
//                dataLD.value = listData[id - 1]

                Log.d("showvolley", res.toString())
            },
            {
                Log.d("showvolley", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}