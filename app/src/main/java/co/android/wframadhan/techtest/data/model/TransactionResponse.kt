package co.android.wframadhan.techtest.data.model

import com.google.gson.annotations.SerializedName

data class CandidateResponse(

    @SerializedName("results")
    val results: List<Candidate>,
)

data class AddressResponse(
    @SerializedName("results")
    val results: List<Address>
)

data class BlogResponse(
    @SerializedName("results")
    val results: List<Blog>
)
