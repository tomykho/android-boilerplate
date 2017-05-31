package com.sample.application.api

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.IOException
import java.lang.reflect.Type

class ApiCallAdapterFactory private constructor() : CallAdapter.Factory() {

    private val originalCallAdapterFactory = RxJava2CallAdapterFactory.createAsync()

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        val adapter = originalCallAdapterFactory.get(returnType, annotations, retrofit)
        return if (adapter == null) null else APICallAdapter(retrofit, adapter)
    }

    private class APICallAdapter<R> internal constructor(private val mRetrofit: Retrofit, private val mWrappedCallAdapter: CallAdapter<R, *>) : CallAdapter<R, Observable<R>> {

        override fun responseType(): Type {
            return mWrappedCallAdapter.responseType()
        }

        override fun adapt(call: Call<R>): Observable<R> {
            @Suppress("UNCHECKED_CAST")
            val adapt = mWrappedCallAdapter.adapt(call) as Observable<R>
            return adapt.onErrorResumeNext { throwable: Throwable -> Observable.error(asException(throwable)) }
        }

        private fun asException(throwable: Throwable): ApiException {
            if (throwable is HttpException) {
                return ApiException.httpError(throwable.response(), mRetrofit)
            }
            if (throwable is IOException) {
                return ApiException.networkError(throwable)
            }
            return ApiException.unexpectedError(throwable)
        }
    }

    companion object {

        fun create(): CallAdapter.Factory {
            return ApiCallAdapterFactory()
        }
    }
}