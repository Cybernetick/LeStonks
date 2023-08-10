package personal.vankhulup.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagedResponse<T> (@SerialName("count") val count: Int, @SerialName("next_url") val nextCursor: String, @SerialName("request_id") val requestId: String, @SerialName("results") val data: List<T> = emptyList(), @SerialName("status") val responseStatus: ResponseStatus)