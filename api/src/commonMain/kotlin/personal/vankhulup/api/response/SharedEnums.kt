package personal.vankhulup.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
* If we use custom @SerialName annotation for fields, then we have to make whole enum class with @Serializable annotation
* */

enum class ResponseStatus {
  OK
}

@Serializable
enum class AssetMarket {
  @SerialName("stocks") STOCKS,
  @SerialName("crypto") CRYPTO,
  @SerialName("fx") FX,
  @SerialName("otc") OTC,
  @SerialName("indices") INDICES
}

@Serializable
enum class AssetLocale {
  @SerialName("us") US, @SerialName("global") GLOBAL
}