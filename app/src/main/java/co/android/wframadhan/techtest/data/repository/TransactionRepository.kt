package co.android.wframadhan.techtest.data.repository

import android.content.Context
import co.android.wframadhan.techtest.data.model.AddressResponse
import co.android.wframadhan.techtest.data.model.BlogResponse
import co.android.wframadhan.techtest.data.model.CandidateResponse
import co.android.wframadhan.techtest.services.ApiClient
import co.android.wframadhan.techtest.services.SafeApiRequest
import co.android.wframadhan.techtest.utils.Constant
import co.android.wframadhan.techtest.utils.ServiceGenerator
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TransactionRepository @Inject constructor(
    @ApplicationContext
    private val context: Context,
    serviceGenerator: ServiceGenerator
) : SafeApiRequest() {

    private val build = serviceGenerator.createService(
        ApiClient::class.java,
        Constant.BASE_URL
    )

    suspend fun getCandidate(): CandidateResponse {
        return apiRequest { build.getCandidates() }
    }

    suspend fun getAddress(): AddressResponse {
        return apiRequest { build.getAddress() }
    }

    suspend fun getBlog(): BlogResponse {
        return apiRequest { build.getBlogs() }
    }
}