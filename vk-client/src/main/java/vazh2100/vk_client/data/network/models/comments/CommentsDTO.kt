package vazh2100.vk_client.data.network.models.comments

import com.google.gson.annotations.SerializedName

data class CommentsResponseDTO(
    @SerializedName("response") val response: CommentsDTO,
)

data class CommentsDTO(
    @SerializedName("items") val comments: List<CommentDTO>,
    @SerializedName("profiles") val profiles: List<VkUserDTO>,
)