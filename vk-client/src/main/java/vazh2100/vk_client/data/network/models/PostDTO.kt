package vazh2100.vk_client.data.network.models

import com.google.gson.annotations.SerializedName

data class PostDTO(
    @SerializedName("id") val id: Long,
    @SerializedName("source_id") val groupId: Long,
    @SerializedName("text") val text: String?,
    @SerializedName("date") val date: Long,
    @SerializedName("views") val views: ViewsDTO?,
    @SerializedName("reposts") val shares: SharesDTO?,
    @SerializedName("comments") val comments: CommentsDTO?,
    @SerializedName("likes") val likes: LikesDTO?,
    @SerializedName("attachments") val attachments: List<AttachmentDTO>?,
)

data class ViewsDTO(@SerializedName("count") val count: Int)

data class SharesDTO(@SerializedName("count") val count: Int)

data class CommentsDTO(@SerializedName("count") val count: Int)

data class LikesDTO(
    @SerializedName("count") val count: Int,
    @SerializedName("user_likes") val isLiked: Int,
)

data class AttachmentDTO(@SerializedName("photo") val photo: PhotoDTO)

data class PhotoDTO(@SerializedName("sizes") val urls: List<PhotoUrlDTO>)

data class PhotoUrlDTO(@SerializedName("url") val url: String)
