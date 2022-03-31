package com.abdullaev.smartagro

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.abdullaev.smartagro.databinding.ActivityMainBinding
import com.abdullaev.smartagro.fragment.manegement.FragmentFarmManagementDirections
import com.abdullaev.smartagro.utils.statusBarColor
import com.google.android.material.transition.MaterialElevationScale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    val currentNavigationFragment: Fragment?
        get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main_home)
            ?.childFragmentManager
            ?.fragments
            ?.first()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        statusBarColor(
            ResourcesCompat.getColor(
                resources,
                R.color.white,
                theme
            ), ResourcesCompat.getColor(
                resources,
                R.color.white,
                theme
            ), true
        )

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main_home) as NavHostFragment
        navController = navHostFragment.findNavController()
        binding.navView.itemIconTintList = null
        binding.navView.setupWithNavController(navController)


        binding.fab.apply {
            setOnClickListener {
                navigateToExamFragment()
            }

        }

        binding.apply {
            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.fragmentFarmManagement->{
                        hideBottomNav()
                    }
                    R.id.fragmentCollaboration->{
                        showBottomNav()
                    }
                    R.id.fragmentMarketplace->{
                        showBottomNav()
                    }

                    R.id.fragmentRenting->{
                        showBottomNav()
                    }
                    R.id.fragmentSponsorship->{
                        showBottomNav()
                    }
                }
            }
        }

        binding.navView.setOnNavigationItemReselectedListener {}
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun navigateToExamFragment(){
        currentNavigationFragment?.apply {
            exitTransition = MaterialElevationScale(false).apply {
                duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            }
            reenterTransition = MaterialElevationScale(true).apply {
                duration = resources.getInteger(R.integer.reply_motion_duration_large).toLong()
            }
        }
        val directions = FragmentFarmManagementDirections.actionGlobalFarmManagement()
        findNavController(R.id.nav_host_fragment_activity_main_home).navigate(directions)
    }
    private fun setBottomAppBarForCompose() {
        hideBottomAppBar()
    }

    private fun hideBottomAppBar() {
        binding.run {
            bottomBar.performHide()
            // Get a handle on the animator that hides the bottom app bar so we can wait to hide
            // the fab and bottom app bar until after it's exit animation finishes.
            bottomBar.animate().setListener(object : AnimatorListenerAdapter() {
                var isCanceled = false
                override fun onAnimationEnd(animation: Animator?) {
                    if (isCanceled) return

                    bottomBar.visibility = View.GONE
                    fab.visibility = View.INVISIBLE
                }
                override fun onAnimationCancel(animation: Animator?) {
                    isCanceled = true
                }
            })
        }
    }
    private fun showBottomNav() {
        binding.fab.show()
        binding.bottomBar.performShow()
    }

    private fun hideBottomNav() {
        binding.bottomBar.performHide()
        binding.fab.hide()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}