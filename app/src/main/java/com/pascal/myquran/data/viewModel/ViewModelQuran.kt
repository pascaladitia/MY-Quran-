package com.pascal.myquran.data.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pascal.myquran.model.ResponseListAyat
import com.pascal.myquran.data.repo.RepositoryQuran
import com.pascal.myquran.model.ResponseListQuran
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class ViewModelQuran @Inject constructor(
    val repository: RepositoryQuran
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    var getQuran = MutableLiveData<Array<ResponseListQuran>>()
    var responseGetQuran: LiveData<Array<ResponseListQuran>> = getQuran

    var getAyat = MutableLiveData<ResponseListAyat>()
    var responseGetAyat: LiveData<ResponseListAyat> = getAyat

    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getQuranView() {
        isLoading.value = true

        repository.getQuran(compositeDisposable, {
            isLoading.value = false
            getQuran.value = it
        }, {
            isLoading.value = false
            isError.value = it
        })
    }

    fun getAyatView(ayat: String) {
        isLoading.value = true

        repository.getAyat(ayat, compositeDisposable, {
            isLoading.value = false
            getAyat.value = it
        }, {
            isLoading.value = false
            isError.value = it
        })
    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }
}