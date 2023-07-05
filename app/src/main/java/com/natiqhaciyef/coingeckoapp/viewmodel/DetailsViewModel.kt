package com.natiqhaciyef.coingeckoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.coingeckoapp.data.local.room.CryptoEntity
import com.natiqhaciyef.coingeckoapp.data.model.CryptoModel
import com.natiqhaciyef.coingeckoapp.domain.repository.LocalRepository
import com.natiqhaciyef.coingeckoapp.domain.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val networkRepo: NetworkRepository,
    private val localRepo: LocalRepository
) : BaseViewModel(){
    val cryptoLiveData = MutableLiveData<CryptoModel>()

    init {
        getAllFromLocalDB()
    }

    fun getCryptoById(id: String = "bitcoin"){
        viewModelScope.launch {
            cryptoLiveData.value = networkRepo.getFilteredCoins(id).first()
        }
    }

    fun insertCrypto(cryptoEntity: CryptoEntity){
        viewModelScope.launch {
            localRepo.insertCrypto(cryptoEntity)
        }
    }

    fun getAllFromLocalDB(){
        viewModelScope.launch {
            println(localRepo.getAll())
        }
    }

    fun numberConverter(volume: String) : String = if(volume.length > 12){
        "${"%.2f".format(volume.toDouble()/1000000000)} B"
    }else if(volume.length in 10..12){
        "${"%.2f".format(volume.toDouble()/1000000)} M"
    }else if(volume.length in 7..9){
        "${"%.2f".format(volume.toDouble()/1000)} K"
    }else{
        volume
    }
}