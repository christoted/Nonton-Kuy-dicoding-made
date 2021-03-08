package com.example.mymovie.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.mymovie.core.data.remote.ApiResponse
import com.example.mymovie.core.data.remote.StatusResponse
import com.example.mymovie.core.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class NetworkBoundResource<ResultType, RequestType>() {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.loading<ResultType>(null))
        val dbSource = loadFromDB().first()
        if ( shouldFetch(dbSource)) {
            emit(Resource.loading<ResultType>(null))
            val apiResponse = createCall().first()
            when(apiResponse.status) {

                StatusResponse.SUCCESS -> {
                    apiResponse.body?.let { saveCallForResult(it) }
                    emitAll(loadFromDB().map {
                        Resource.success(it)
                    })
                }

                StatusResponse.EMPTY -> {
                    emitAll(loadFromDB().map {
                        Resource.success(it)
                    })
                }

                StatusResponse.ERROR -> {
                    emit(Resource.error<ResultType>(apiResponse.message, null))
                }

                StatusResponse.LOADING -> {
                    emitAll(loadFromDB().map {
                        Resource.success(it)
                    })
                }
            }
        } else {
            emitAll(loadFromDB().map {
                Resource.success(it)
            })
        }

    }

    abstract fun loadFromDB(): Flow<ResultType>

    abstract fun shouldFetch(data: ResultType): Boolean

    abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    abstract suspend fun saveCallForResult(body: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result
}