package com.example.randomprofile.reporsitories

import android.util.Log
import com.example.randomprofile.API.APIService
import com.example.randomprofile.entities.UserResponse
import com.google.gson.Gson
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Response

class services {






    /*fun  GetUsers(){


        val service = APIService.create()
        val gson = Gson()



        val call: Call<JsonObject> = service.getUsers()
        call.enqueue(object : retrofit2.Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val response = response.body()
                val p = gson.fromJson(response, UserResponse::class.java)


                //Log.d("Sample",p.toString())


                // Log.d("Sample", "Text: "+response!!.get("text").toString())
                // rest of the keys...
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                t.message?.let { Log.d("Sample", it) }
            }
        })

    }*/
}