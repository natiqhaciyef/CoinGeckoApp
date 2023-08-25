package com.natiqhaciyef.coingeckoapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.coingeckoapp.data.local.room.CryptoEntity
import com.natiqhaciyef.coingeckoapp.databinding.RecyclerSavedCurrencyItemBinding

class SavedCoinAdapter(val context: Context, val list: List<CryptoEntity>) :
    RecyclerView.Adapter<SavedCoinAdapter.SavedCoinHolder>() {

    var onClick: (CryptoEntity) -> Unit = { }

    inner class SavedCoinHolder(val binding: RecyclerSavedCurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedCoinHolder {
        val binding = RecyclerSavedCurrencyItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return SavedCoinHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: SavedCoinHolder, position: Int) {
        val view = holder.binding
        val savedCoin = list[position]

        Glide.with(context).load(savedCoin.image).into(view.imageView)
        view.titleText.text = savedCoin.name
        view.priceText.text = "Price: ${savedCoin.currentPrice}$"
        view.deleteButton.setOnClickListener {
            onClick.invoke(savedCoin)
        }
    }

}