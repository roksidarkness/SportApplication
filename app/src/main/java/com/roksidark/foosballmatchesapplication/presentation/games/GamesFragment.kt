package com.roksidark.foosballmatchesapplication.presentation.games

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.roksidark.foosballmatchesapplication.R
import com.roksidark.foosballmatchesapplication.databinding.FragmentGamesBinding
import com.roksidark.foosballmatchesapplication.presentation.MainViewModel
import com.roksidark.foosballmatchesapplication.presentation.games.adapter.GameAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GamesFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by activityViewModels {
        viewModelFactory
    }

    private var _binding: FragmentGamesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddItem.setOnClickListener { _ ->
            val bundle = Bundle()
            bundle.putBoolean("isAdd", true)
            findNavController().navigate(R.id.action_GamesFragment_to_AddGameFragment, bundle)
        }
        val adapter = GameAdapter()
        binding.listGames.layoutManager = LinearLayoutManager(requireContext())
        binding.listGames.adapter = adapter
        adapter.onItemClick = { item ->
            val bundle = Bundle()
            bundle.putBoolean("isAdd", false)
            bundle.putParcelable("item", item)
            findNavController().navigate(R.id.action_GamesFragment_to_AddGameFragment, bundle)
        }

        viewModel.gamesLiveData.observe(viewLifecycleOwner) { results ->
            binding.progressBar.visibility = View.GONE
            (binding.listGames.adapter as GameAdapter).setItems(results)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}