package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val weatherItem : ArrayList<Weather> = arrayListOf<Weather>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO){
                Client.api.getWeatherDetails()
            }
            if(response.isSuccessful){
           val responseBody = response.body()
              Log.d("Response","$responseBody")
                response.body()?.let {res->
                    res.main.let{

                    }
                    res.weather.let{

                    }

                }
            }

        }
    }
}
