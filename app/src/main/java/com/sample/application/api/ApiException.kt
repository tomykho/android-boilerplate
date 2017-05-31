package com.sample.application.api

import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

class ApiException internal constructor(message: String?,
                                        /** Response object containing status code, headers, body, etc.  */
                                        val response: Response<*>?,
                                        /** The event kind which triggered this error.  */
                                        val kind: Kind, exception: Throwable?,
                                        /** The Retrofit this request was executed on  */
                                        val retrofit: Retrofit?) : RuntimeException(message, exception) {

    enum class Kind {
        NETWORK,
        HTTP,
        UNEXPECTED
    }

    /**
     * HTTP response body converted to specified `type`. `null` if there is no
     * response.

     * @throws IOException if unable to convert the body to the specified `type`.
     */
    inline fun <reified T : Any> errorAs(): T? {
        if (response == null || response.errorBody() == null) {
            return null
        }
        val converter = retrofit?.responseBodyConverter<T>(T::class.java, arrayOfNulls<Annotation>(0))
        return converter?.convert(response.errorBody())
    }

    val error: ApiError?
        get() = errorAs()

    companion object {

        fun httpError(response: Response<*>, retrofit: Retrofit): ApiException {
            val message = response.code().toString() + " " + response.message()
            return ApiException(message, response, Kind.HTTP, null, retrofit)
        }

        fun networkError(exception: IOException): ApiException {
            return ApiException(exception.message, null, Kind.NETWORK, exception, null)
        }

        fun unexpectedError(exception: Throwable): ApiException {
            return ApiException(exception.message, null, Kind.UNEXPECTED, exception, null)
        }

    }
}