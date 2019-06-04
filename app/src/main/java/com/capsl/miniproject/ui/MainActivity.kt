package com.capsl.miniproject.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.capsl.miniproject.R
import com.capsl.miniproject.databinding.ActivityMainBinding
import com.capsl.miniproject.util.base.BaseActivity
import com.capsl.miniproject.util.databinding.withBinding

class MainActivity : BaseActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = withBinding<ActivityMainBinding>(R.layout.activity_main) {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            navController = findNavController(R.id.nav_host_fragment)
            setupActionBarWithNavController(navController)
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            // todo: show search bar on add people
            /*when (destination.id) {
                R.id.signInFragment -> supportActionBar?.hide()
                else -> supportActionBar?.show()
            }*/
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item) {
        null -> super.onOptionsItemSelected(item)
        else -> NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp() || super.onSupportNavigateUp()

}
