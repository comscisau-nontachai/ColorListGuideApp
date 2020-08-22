package com.dev.colorlistguideapp.services

import com.dev.colorlistguideapp.models.ColorResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("api/unknows")
    fun getColorData() : Observable<ColorResponse>
}