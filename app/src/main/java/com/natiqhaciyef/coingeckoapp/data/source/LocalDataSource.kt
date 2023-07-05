package com.natiqhaciyef.coingeckoapp.data.source

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.natiqhaciyef.coingeckoapp.data.local.room.AppDao
import com.natiqhaciyef.coingeckoapp.data.local.room.CryptoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(val dao: AppDao) {
    suspend fun getAll(): List<CryptoEntity> = withContext(Dispatchers.IO){
        dao.getAll()
    }

    suspend fun insertCrypto(cryptoEntity: CryptoEntity) = withContext(Dispatchers.IO){
        dao.insertCrypto(cryptoEntity)
    }

    suspend fun deleteCrypto(cryptoEntity: CryptoEntity) = withContext(Dispatchers.IO){
        dao.deleteCrypto(cryptoEntity)
    }

}