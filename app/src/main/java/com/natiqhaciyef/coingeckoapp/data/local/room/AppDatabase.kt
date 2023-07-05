package com.natiqhaciyef.coingeckoapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [CryptoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getDao(): AppDao
}