package com.natiqhaciyef.coingeckoapp.data.source

import com.natiqhaciyef.coingeckoapp.data.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NetworkDataSource(private val ns: NetworkService) {
    suspend fun getAllCoins() = withContext(Dispatchers.IO){
        ns.getAllCryptos()
    }

}