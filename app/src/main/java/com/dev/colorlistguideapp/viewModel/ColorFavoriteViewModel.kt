package com.dev.colorlistguideapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.colorlistguideapp.models.ColorData
import com.dev.colorlistguideapp.models.ColorResponse
import com.dev.colorlistguideapp.services.ApiService
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ColorFavoriteViewModel : ViewModel() {

    val listColor = MutableLiveData<MutableList<ColorData>>()

    fun getColorData(): MutableLiveData<MutableList<ColorData>> {
        getCallApi()
        return listColor
    }

    private fun getCallApi() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        retrofit.create<ApiService>(ApiService::class.java)
            .getColorData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ColorResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: ColorResponse) {
                    listColor.postValue(t.data)
                }

                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            })
    }
}