package co.android.wframadhan.techtest.services

import co.android.wframadhan.techtest.data.model.AddressResponse
import co.android.wframadhan.techtest.data.model.BlogResponse
import co.android.wframadhan.techtest.data.model.CandidateResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("candidates")
    suspend fun getCandidates(): Response<CandidateResponse>

    @GET("address")
    suspend fun getAddress(): Response<AddressResponse>

    @GET("blogs")
    suspend fun getBlogs(): Response<BlogResponse>
}