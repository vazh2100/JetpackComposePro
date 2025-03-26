package vazh2100.vk_client.data.network.models.comments

import com.google.gson.annotations.SerializedName

data class CommentDTO(
    @SerializedName("id") val id: Int,
    @SerializedName("from_id") val userId: Int,
    @SerializedName("date") val date: Long,
    @SerializedName("text") val text: String,
)
