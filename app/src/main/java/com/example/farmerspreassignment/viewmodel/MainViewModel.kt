package com.example.farmerspreassignment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.farmerspreassignment.model.database.PostDao
import com.example.farmerspreassignment.model.network.RetrofitHelper
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val postDao: PostDao): ViewModel() {
    lateinit var retrofitHelper: RetrofitHelper

    private lateinit var subscription: Disposable

    init{
        loadPosts()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadPosts(){
        subscription = Observable.fromCallable { postDao.allPosts }
            .concatMap {
                    dbPostList ->
                if(dbPostList.isEmpty())
                    retrofitHelper.getAllPosts().concatMap{
                            apiPostList -> postDao.insertAll(*apiPostList.toTypedArray())
                        Observable.just(apiPostList)
                    }
                else
                    Observable.just(dbPostList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}