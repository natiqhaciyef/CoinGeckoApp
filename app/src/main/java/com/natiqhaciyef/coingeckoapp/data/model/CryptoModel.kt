package com.natiqhaciyef.coingeckoapp.data.model

import androidx.room.Entity


data class CryptoModel(
    val id: String,
    val name: String,
    val image: String,
    val symbol: String,
    val current_price: Double,
    val market_cap: Double,
    val high_24h: Double,
    val low_24h: Double,
    val last_updated: String,
    val market_cap_rank: Double,
    val market_cap_change_24h: Double,
    val market_cap_change_percentage_24h: Double,
    val price_change_24h: Double,
    val price_change_percentage_24h: Double,
    val price_change_percentage_24h_in_currency: Double,
    val total_volume: Double
)