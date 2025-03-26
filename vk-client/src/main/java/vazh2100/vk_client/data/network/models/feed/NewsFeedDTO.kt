package vazh2100.vk_client.data.network.models.feed

import com.google.gson.annotations.SerializedName

data class NewsFeedResponseDTO(
    @SerializedName("response") val response: NewsFeedDTO,
)

data class NewsFeedDTO(
    @SerializedName("items") val posts: List<PostDTO>,
    @SerializedName("groups") val groups: List<GroupDTO>,
    @SerializedName("next_from") val nextFrom: String
)