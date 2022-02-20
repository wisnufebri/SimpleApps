package co.android.wframadhan.techtest.data.model

import com.google.gson.annotations.SerializedName

data class Candidate(

    @SerializedName("birthday")
    val birthday: Long,

    @SerializedName("expired")
    val expired: Int,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("photo")
    val photo: String,

    @SerializedName("id")
    val id: Int
)

data class Address(

    @field:SerializedName("address")
    val address: String,

    @field:SerializedName("city")
    val city: String,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("state")
    val state: String,

    @field:SerializedName("zip_code")
    val zipCode: Int
)

data class Blog(

    @field:SerializedName("subTitle")
    val subTitle: String? = null,

    @field:SerializedName("author")
    val author: String? = null,

    @field:SerializedName("photo")
    val photo: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("tag")
    val tag: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("create_at")
    val createAt: Int? = null,

    @field:SerializedName("content")
    val content: String? = null
)