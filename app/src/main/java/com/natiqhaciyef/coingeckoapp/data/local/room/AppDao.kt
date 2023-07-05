package com.natiqhaciyef.coingeckoapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM crypto_table")
    suspend fun getAll(): List<CryptoEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCrypto(cryptoEntity: CryptoEntity)

    @Delete
    suspend fun deleteCrypto(cryptoEntity: CryptoEntity)

}