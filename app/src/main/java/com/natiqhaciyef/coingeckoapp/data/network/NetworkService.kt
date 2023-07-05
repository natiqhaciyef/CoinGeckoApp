package com.natiqhaciyef.coingeckoapp.data.network

import com.natiqhaciyef.coingeckoapp.data.model.CryptoModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("api/v3/coins/markets")
    suspend fun getAllCryptos(
        @Query("vs_currency") vs_currency: String = "usd",
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") per_page: Int = 100,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean = true,
        @Query("price_change_percentage") price_change_percentage: String = "24h",
        @Query("precision") precision: Int = 1,
        @Query("locale") locale: String = "en",
    ) : List<CryptoModel>

}