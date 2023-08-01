package personal.vankhulup.api

import kotlinx.serialization.Serializable

@Serializable
data class OpenCloseData(val symbol: String, val status: String, val afterHours: Float, val close: Float, val open: Float)
