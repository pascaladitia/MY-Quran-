package com.pascal.myquran.data.repo

import com.pascal.myquran.data.service.ApiService
import com.pascal.myquran.model.ResponseListAyat
import com.pascal.myquran.model.ResponseListQuran
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class RepositoryQuran @Inject constructor(
    val apiService: ApiService
){

    fun getQuran(compositeDisposable: CompositeDisposable,
                 responHandler: (Array<ResponseListQuran>) -> Unit, errorHandler: (Throwable) -> Unit) {
        apiService.getQuran().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            }).also {
               compositeDisposable.add(it)
            }
    }

    fun getAyat(ayat: String, compositeDisposable: CompositeDisposable,
                responHandler: (ResponseListAyat) -> Unit, errorHandler: (Throwable) -> Unit) {
        apiService.getAyat(ayat).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            }).also {
                compositeDisposable.add(it)
            }
    }
}