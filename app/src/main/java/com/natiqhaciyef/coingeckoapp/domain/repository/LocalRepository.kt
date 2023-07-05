package com.natiqhaciyef.coingeckoapp.domain.repository

import com.natiqhaciyef.coingeckoapp.data.local.room.CryptoEntity
import com.natiqhaciyef.coingeckoapp.data.source.LocalDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalRepository(val lds: LocalDataSource) {
    suspend fun getAll(): List<CryptoEntity> =
        lds.getAll()


    suspend fun insertCrypto(cryptoEntity: CryptoEntity) =
        lds.insertCrypto(cryptoEntity)


    suspend fun deleteCrypto(cryptoEntity: CryptoEntity) =
        lds.deleteCrypto(cryptoEntity)

}