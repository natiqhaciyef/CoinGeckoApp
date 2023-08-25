package com.natiqhaciyef.coingeckoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.coingeckoapp.data.model.CryptoModel
import com.natiqhaciyef.coingeckoapp.domain.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val networkRepo: NetworkRepository
): BaseViewModel() {

    private val _cryptoLiveData = MutableLiveData<List<CryptoModel>?>()
    val cryptoLiveData get() = _cryptoLiveData

    init {
        getAllCoins()
    }

    private fun getAllCoins(){
        viewModelScope.launch {
            _cryptoLiveData.value = networkRepo.getAllCoins()
        }
    }
}