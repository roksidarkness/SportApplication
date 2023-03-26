package com.roksidark.foosballmatchesapplication.presentation.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.roksidark.foosballmatchesapplication.R
import com.roksidark.foosballmatchesapplication.databinding.ActivityMainBinding
import com.roksidark.foosballmatchesapplication.presentation.MainViewModel
import com.roksidark.foosballmatchesapplication.util.Constant
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MainViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        if (id == R.id.action_ratings) {
            val bundle = Bundle()
            bundle.putBoolean(Constant.BY_WON, false)
            findNavController(R.id.nav_host_fragment_content_main)
                .navigate(R.id.action_GamesFragment_to_RatingDialog, bundle)
            return true
        }

        if (id == R.id.action_ratings_by_won) {
            val bundle = Bundle()
            bundle.putBoolean(Constant.BY_WON, true)
            findNavController(R.id.nav_host_fragment_content_main)
                .navigate(R.id.action_GamesFragment_to_RatingDialog, bundle)
            return true
        }

        return super.onOptionsItemSelected(item)

    }
}