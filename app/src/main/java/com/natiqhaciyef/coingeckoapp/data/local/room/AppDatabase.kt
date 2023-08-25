package com.natiqhaciyef.coingeckoapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [CryptoEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getDao(): AppDao
}