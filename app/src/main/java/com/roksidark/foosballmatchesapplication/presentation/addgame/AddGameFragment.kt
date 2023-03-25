package com.roksidark.foosballmatchesapplication.presentation.addgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.roksidark.foosballmatchesapplication.R
import com.roksidark.foosballmatchesapplication.databinding.FragmentAddGameBinding
import com.roksidark.foosballmatchesapplication.presentation.MainViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by activityViewModels {
        viewModelFactory
    }

    private var _binding: FragmentAddGameBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddGameBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.buttonSecond.setOnClickListener { _ ->
            if (binding.edittextFirstPerson.text.isNotEmpty() ||
                binding.edittextFirstPersonScore.text.isNotEmpty() ||
                binding.edittextSecondPerson.text.isNotEmpty() ||
                binding.edittextSecondPersonScore.text.isNotEmpty()) {
                viewModel.addGame(
                    binding.edittextFirstPerson.text.toString(),
                    binding.edittextFirstPersonScore.text.toString(),
                    binding.edittextSecondPerson.text.toString(),
                    binding.edittextSecondPersonScore.text.toString(),
                )
            }
            findNavController().navigate(R.id.action_AddGameFragment_to_GamesFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}