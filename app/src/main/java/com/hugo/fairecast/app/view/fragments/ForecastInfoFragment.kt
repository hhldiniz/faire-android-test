package com.hugo.fairecast.app.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.hugo.fairecast.app.view.states.ForecastInfoState
import com.hugo.fairecast.app.viewmodel.ForecastInfoViewModel
import com.hugo.fairecast.databinding.FragmentForecastInfoBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForecastInfoFragment : Fragment() {
    private val forecastInfoViewModel: ForecastInfoViewModel by viewModel()
    private lateinit var binding: FragmentForecastInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForecastInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                binding.state = ForecastInfoState.Loading
                binding.executePendingBindings()
                forecastInfoViewModel.getForecastByCityId(4418).collect(binding::setState)
            }
        }
    }
}