package com.example.shuchanalaye

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var drawerLayout: DrawerLayout
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawerLayout)
        coordinatorLayout = findViewById(R.id.coordinatorLayout)
        frameLayout = findViewById(R.id.frameLayout)
        navigationView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)
        setUpToolbar()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer,
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener {

            when(it.itemId) {
                R.id.dashboard -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, Dashboard())
                        .addToBackStack("Dashboard")
                        .commit()
                    supportActionBar?.title = "Dashboard"

                    drawerLayout.closeDrawers()
                }
                R.id.college -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, College())
                        .addToBackStack("College")
                        .commit()
                    supportActionBar?.title = "College"

                    drawerLayout.closeDrawers()
                }
                R.id.branch -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, Branch())
                        .addToBackStack("Branch")
                        .commit()
                    supportActionBar?.title = "Branch"

                    drawerLayout.closeDrawers()
                }
                R.id.help -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, Help())
                        .addToBackStack("Help")
                        .commit()
                    supportActionBar?.title = "Help"

                    drawerLayout.closeDrawers()
                }
                R.id.about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout, About())
                        .addToBackStack("About app")
                        .commit()
                    supportActionBar?.title = "About"

                    drawerLayout.closeDrawers()
                }
            }
            return@setNavigationItemSelectedListener true
        }
    }
    fun setUpToolbar(){
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id=item.itemId

        if (id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}


