package ru.arturprgr.mylicenceplate.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import ru.arturprgr.mylicenceplate.R
import ru.arturprgr.mylicenceplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Firebase.auth.currentUser != null) else startActivity(
            Intent(this@MainActivity, AuthActivity::class.java)
        )

        binding.apply {
            navigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.item_random -> setFragment(fragmentRandom)
                    R.id.item_achievements -> setFragment(fragmentAchievements)
                }
                true
            }
        }
    }

    private fun setFragment(fragment: FragmentContainerView) = with(binding) {
        fragmentRandom.visibility = View.GONE
        fragmentAchievements.visibility = View.GONE
        fragment.visibility = View.VISIBLE
    }
}