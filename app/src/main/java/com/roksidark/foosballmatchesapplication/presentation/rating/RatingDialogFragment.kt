package com.roksidark.foosballmatchesapplication.presentation.rating

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.roksidark.foosballmatchesapplication.databinding.FragmentDialogRatingBinding
import com.roksidark.foosballmatchesapplication.presentation.MainViewModel
import com.roksidark.foosballmatchesapplication.presentation.rating.adapter.RatingAdapter
import com.roksidark.foosballmatchesapplication.util.Constant.BY_WON
import dagger.android.support.DaggerDialogFragment
import javax.inject.Inject


class RatingDialogFragment: DaggerDialogFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by activityViewModels {
        viewModelFactory
    }

    private var _binding: FragmentDialogRatingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDialogRatingBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val byWon = arguments?.getBoolean(BY_WON)

        val adapter = RatingAdapter()
        binding.listRating.layoutManager = LinearLayoutManager(requireContext())
        binding.listRating.adapter = adapter

        byWon?.let {
        if (!it) {
            viewModel.gamesRatingLiveData.observe(viewLifecycleOwner) { items ->
                binding.progressBar.visibility = View.GONE
                adapter.setItems(items)
            }
        }
            else{
                viewModel.gamesRatingByWonLiveData.observe(viewLifecycleOwner) { items ->
                    binding.progressBar.visibility = View.GONE
                    adapter.setItems(items)
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getTheme(): Int {
        return R.style.ThemeOverlay_Material_Dialog
    }
}