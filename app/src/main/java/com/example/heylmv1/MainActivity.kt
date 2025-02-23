package com.example.heylmv1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val openDrawerButton: Button = findViewById(R.id.open_drawer_button)

        // menu selector
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_settings -> replaceFragment(SettingsFragment())
            }
            navView.isVisible = false

            true
        }

        val navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.findNavController()

        if (navController != null) {
            NavigationUI.setupWithNavController(navView, navController)
        }

        openDrawerButton.setOnClickListener {
            navView.isVisible = true
        }
    }
    // replace fragments
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}
