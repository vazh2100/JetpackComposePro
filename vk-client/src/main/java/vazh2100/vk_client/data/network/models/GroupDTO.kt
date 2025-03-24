package vazh2100.vk_client.data.network.models

import com.google.gson.annotations.SerializedName

data class GroupDTO(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("photo_200") val photo: String,
)