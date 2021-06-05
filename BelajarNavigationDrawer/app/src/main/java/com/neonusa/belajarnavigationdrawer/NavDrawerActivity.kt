package com.neonusa.belajarnavigationdrawer

import android.os.Bundle
import android.view.Menu
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.neonusa.belajarnavigationdrawer.databinding.ActivityNavDrawerBinding

class NavDrawerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityNavDrawerActivity = ActivityNavDrawerBinding.inflate(layoutInflater)
        setContentView(activityNavDrawerActivity.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //val fab: FloatingActionButton = findViewById(R.id.fab)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        val navController = findNavController(R.id.nav_host_fragment)

        /** id navigasi di mobile_nav dan activity_main_drawer harus sama
            untuk navigasi ke halaman tertentu melalui menu drawer */

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_bookmark, R.id.nav_history, R.id.nav_about), activityNavDrawerActivity.root)
        setupActionBarWithNavController(navController, appBarConfiguration)
        activityNavDrawerActivity.navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}