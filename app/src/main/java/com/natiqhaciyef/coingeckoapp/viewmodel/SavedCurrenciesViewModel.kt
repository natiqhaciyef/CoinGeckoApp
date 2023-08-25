package com.natiqhaciyef.coingeckoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.coingeckoapp.data.local.room.CryptoEntity
import com.natiqhaciyef.coingeckoapp.domain.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedCurrenciesViewModel @Inject constructor(
    private var localRepo: LocalRepository
): BaseViewModel() {

    val savedLiveData = MutableLiveData<List<CryptoEntity>>()

    init {
        getAllSavedData()
    }

    fun getAllSavedData(){
        viewModelScope.launch {
            savedLiveData.value = localRepo.getAll()
        }
    }

    fun deleteSavedData(cryptoEntity: CryptoEntity){
        viewModelScope.launch{
            localRepo.deleteCrypto(cryptoEntity)
        }
    }
}


fun main() {
    val str = "208504406101853332221444478196634750328"
    println(str.length)


}