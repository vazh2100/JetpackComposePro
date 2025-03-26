package vazh2100.vk_client.data.network.models.comments

import com.google.gson.annotations.SerializedName

data class VkUserDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("photo_100") val photo: String,
)