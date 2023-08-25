package com.natiqhaciyef.coingeckoapp.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.coingeckoapp.databinding.FragmentSavedCurrenciesBinding
import com.natiqhaciyef.coingeckoapp.view.adapter.SavedCoinAdapter
import com.natiqhaciyef.coingeckoapp.viewmodel.SavedCurrenciesViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SavedCurrenciesFragment : Fragment() {
    private lateinit var binding: FragmentSavedCurrenciesBinding
    private val viewModel: SavedCurrenciesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavedCurrenciesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.savedLiveData.observe(viewLifecycleOwner){ list ->
            val adapter = SavedCoinAdapter(requireContext(), list)
            binding.savedCurrenciesRecyclerView.adapter = adapter
            binding.savedCurrenciesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            adapter.onClick = {
                viewModel.deleteSavedData(it)
            }
        }
    }
}