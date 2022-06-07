package com.geekbrains.dictionary.datasource


import android.util.Log
import com.geekbrains.dictionary.data.OnCallbackWebRequest
import com.geekbrains.dictionary.domain.skyeng.SkyengBase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASEURL = "https://dictionary.skyeng.ru/api/public/v1/words/"

class RetrofitWebConnection(private val onCallbackWebRequest: OnCallbackWebRequest) {

    private val retrofit = provideRetrofit()

     fun webRequest(searchWord: String) {
       val retrofitService = retrofit.create(RetrofitService1::class.java)
        retrofitService.getListTranslatedWords(searchWord).enqueue(object :Callback<List<SkyengBase>>{
            override fun onResponse(
                call: Call<List<SkyengBase>>,
                response: Response<List<SkyengBase>>
            ) {
                if (response.isSuccessful && response.code() == 200) {
                    val skyEngBase = response.body()
                    Log.d("!!!", "onResponse: RetrofitWebConnection" + skyEngBase.toString())
                }
                onCallbackWebRequest.onResponse(response.body())
            }

            override fun onFailure(call: Call<List<SkyengBase>>, t: Throwable) {
                Log.d("!!!", "Что-то пошло не так")
            }
        })
    }


    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    }

}

interface RetrofitService1 {

    @GET("search?&page=1&pageSize=1")
    fun getListTranslatedWords(@Query("search") word:String): Call<List<SkyengBase>>
}