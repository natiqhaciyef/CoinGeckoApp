package com.natiqhaciyef.coingeckoapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.coingeckoapp.data.model.CryptoModel
import com.natiqhaciyef.coingeckoapp.databinding.RecyclerCoinItemBinding
import com.natiqhaciyef.coingeckoapp.view.adapter.behaviour.OnClickAction

class CoinAdapter(val context: Context, val list: List<CryptoModel>): RecyclerView.Adapter<CoinAdapter.CoinHolder>() {

    var onClick: (CryptoModel) -> Unit = { }

    inner class CoinHolder(val binding: RecyclerCoinItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinHolder {
        val binding = RecyclerCoinItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CoinHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CoinHolder, position: Int) {
        val view = holder.binding
        val coin = list[position]

        Glide.with(context).load(coin.image).into(view.imageView)

        val lowPrice = "%.2f".format(coin.low_24h)
        val highPrice = "%.2f".format(coin.high_24h)
        view.titleText.text = coin.name
        view.lastLimitsText.text = "High: $highPrice, Low: $lowPrice"
        view.priceText.text = "Price: ${coin.current_price}$"

        holder.itemView.setOnClickListener {
            onClick.invoke(coin)
        }
    }


    fun setOnClickData(action: (CryptoModel)-> Unit){
        onClick = action
    }
}