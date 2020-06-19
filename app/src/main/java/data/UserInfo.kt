package data

import com.google.gson.annotations.SerializedName

data class UserInfo (
    @SerializedName("name")
    val name:String="",
    @SerializedName("address")
    val address:String="",
    @SerializedName("email")
    val email :String="",
    @SerializedName("mobile")
    val mobile:String=""
)
