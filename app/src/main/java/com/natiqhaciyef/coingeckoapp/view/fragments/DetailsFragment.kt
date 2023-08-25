package com.natiqhaciyef.coingeckoapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.natiqhaciyef.coingeckoapp.R
import com.natiqhaciyef.coingeckoapp.data.local.room.CryptoEntity
import com.natiqhaciyef.coingeckoapp.databinding.FragmentDetailsBinding
import com.natiqhaciyef.coingeckoapp.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel : DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data: DetailsFragmentArgs by navArgs()
        val coinId = data.coinId

        viewModel.getCryptoById(coinId)
        viewModel.cryptoLiveData.observe(viewLifecycleOwner){coin ->
            Glide.with(requireContext()).load(coin.image).into(binding.cryptoImage)
            binding.cryptoName.text = "Name: ${coin.name}"
            binding.cryptoPrice.text = "Price: ${coin.current_price} $"
            binding.cryptoLow.text = "Low: ${coin.low_24h} $"
            binding.cryptoHigh.text = "High: ${coin.high_24h} $"

            val numberFormatted = viewModel.numberConverter(coin.total_volume.toString())
            binding.cryptoVolume.text = "Volume: $numberFormatted"
            binding.cryptoChangePercent.text = "Change: ${coin.price_change_percentage_24h_in_currency}"


            binding.saveButton.setOnClickListener {
                val cryptoEntity = CryptoEntity(
                    id = 0,
                    name = coin.name,
                    currentPrice = coin.current_price,
                    dailyLow = coin.low_24h,
                    dailyHigh = coin.high_24h,
                    totalVolume = numberFormatted,
                    change = coin.price_change_percentage_24h_in_currency,
                    image = coin.image
                )

                viewModel.insertCrypto(cryptoEntity)
            }
        }

    }
}