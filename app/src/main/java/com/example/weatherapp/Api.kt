package com.example.weatherapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.weatherapp.WeatherItem

interface Api {
    @GET("weather")
    suspend fun getWeatherDetails(
        @Query("q") state: String = "delhi",
        @Query("units") units: String = "metrics",
        @Query("appid") apiKey : String = "f72df05499017a169bc4502167918f53"
    ): Response<Weather>
}