package com.natiqhaciyef.coingeckoapp.domain.repository

import com.natiqhaciyef.coingeckoapp.data.source.NetworkDataSource

class NetworkRepository(private val nds: NetworkDataSource) {
    suspend fun getAllCoins() = nds.getAllCoins()

    suspend fun getFilteredCoins(coinId: String) = nds.getAllCoins().filter {
        it.id == coinId
    }

}