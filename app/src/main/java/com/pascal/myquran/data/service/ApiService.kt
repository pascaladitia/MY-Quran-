package com.pascal.myquran.data.service

import com.pascal.myquran.model.ResponseListAyat
import com.pascal.myquran.model.ResponseListQuran
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("surat")
    fun getQuran(): Single<Array<ResponseListQuran>>

    @GET("surat/{nomor}")
    fun getAyat(
        @Path("nomer") nomer: String
    ): Single<ResponseListAyat>
}