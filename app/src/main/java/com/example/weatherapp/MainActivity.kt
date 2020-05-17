package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val weatherItem : ArrayList<Weather> = arrayListOf<Weather>()
    val weatherI : ArrayList<WeatherItem> = arrayListOf<WeatherItem>()

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
                    runOnUiThread {
                        state.text = res.name
                        temp.text = res.main!!.temp.toString()
                        main.text = res.weather!!.get(0)!!.main
                        description.text = res.weather!!.get(0)!!.description
                        //min.text = "Min : ${res.main!!.temp_min}"
                        //max.text = "Max : ${res.main!!.temp_max}"
                        humidity.text = res.main!!.humidity.toString()
                        Pressure.text = res.main!!.pressure.toString()





                        Log.d("Response","${res.main!!.temp}")
                    }

                }
            }

        }
    }
}
