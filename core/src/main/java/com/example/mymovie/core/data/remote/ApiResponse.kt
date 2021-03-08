package com.example.mymovie.core.data.remote

class ApiResponse<T>(val status: StatusResponse, val body: T?, val message: String?) {
    companion object {
        fun <T>success(body : T): ApiResponse<T> = ApiResponse(StatusResponse.SUCCESS, body, null)
        fun <T>error(msg: String): ApiResponse<T> = ApiResponse(StatusResponse.ERROR, null ,msg)
        fun <T>loading(msg: String, body : T): ApiResponse<T> = ApiResponse(StatusResponse.LOADING, body, msg)
        fun <T>empty(msg: String): ApiResponse<T> = ApiResponse(StatusResponse.EMPTY, null, msg)
    }
}