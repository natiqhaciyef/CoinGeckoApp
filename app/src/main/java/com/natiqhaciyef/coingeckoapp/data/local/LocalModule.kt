package com.natiqhaciyef.coingeckoapp.data.local

import android.content.Context
import androidx.room.Room
import com.natiqhaciyef.coingeckoapp.data.local.room.AppDao
import com.natiqhaciyef.coingeckoapp.data.local.room.AppDatabase
import com.natiqhaciyef.coingeckoapp.data.source.LocalDataSource
import com.natiqhaciyef.coingeckoapp.domain.repository.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDao(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .build()
            .getDao()

    @Provides
    @Singleton
    fun provideDataSource(dao: AppDao) = LocalDataSource(dao)

    @Provides
    @Singleton
    fun provideRepository(lds: LocalDataSource) = LocalRepository(lds)
}