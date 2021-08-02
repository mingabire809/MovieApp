package com.example.fragapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.countrylistretrofit.retrofit.RetroInstance
import com.demo.countrylistretrofit.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var liveDataList: MutableLiveData<List<MovieModel>>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<List<MovieModel>> {
        return liveDataList
    }

    fun getAllMovies() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.getMovieList()
        call.enqueue(object : Callback<List<MovieModel>> {
            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                liveDataList.postValue(null)
                Log.i("data", "Failed ${t.message}")
            }

            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                liveDataList.postValue(response.body())
                Log.i("data", "Success")
            }
        })


    }

    fun createMovie() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.addMovie("KU", "gugjg", "dee.jpg")
        call.enqueue(object : Callback<List<MovieModel>> {
            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                liveDataList.postValue(response.body())
            }
        })
    }

    fun deleteMovie() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.deleteMovie("KU")
        call.enqueue(object : Callback<List<MovieModel>> {
            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                liveDataList.postValue(response.body())
            }
        })


    }

    fun updateMovie() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call = retroService.updateMovie("UG", "wEA RE ")
        call.enqueue(object : Callback<List<MovieModel>> {
            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                liveDataList.postValue(response.body())
            }
        })


    }

}
