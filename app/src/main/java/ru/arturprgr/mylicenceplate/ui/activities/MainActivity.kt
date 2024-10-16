package ru.arturprgr.mylicenceplate.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import ru.arturprgr.mylicenceplate.R
import ru.arturprgr.mylicenceplate.adapter.MyFragmentPagerAdapter
import ru.arturprgr.mylicenceplate.databinding.ActivityMainBinding
import ru.arturprgr.mylicenceplate.ui.fragments.AchievementsFragment
import ru.arturprgr.mylicenceplate.ui.fragments.RandomFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var fragmentPagerAdapter: MyFragmentPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        fragmentPagerAdapter = MyFragmentPagerAdapter(supportFragmentManager)
        fragmentPagerAdapter.addFragment(RandomFragment())
        fragmentPagerAdapter.addFragment(AchievementsFragment())
        setContentView(binding.root)

        if (Firebase.auth.currentUser != null) else startActivity(
            Intent(this@MainActivity, AuthActivity::class.java)
        )

        binding.apply {
            fragmentPager.adapter = fragmentPagerAdapter
            @Suppress("DEPRECATION")
            fragmentPager.setOnPageChangeListener(object : OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int,
                ) {
                    //not init
                }

                override fun onPageSelected(position: Int) {

                    when (position) {
                        0 -> navigationView.selectedItemId = R.id.item_random
                        1 -> navigationView.selectedItemId = R.id.item_achievements
                    }
                }

                override fun onPageScrollStateChanged(state: Int) {
                    //not init
                }
            })
            navigationView.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.item_random -> fragmentPager.setCurrentItem(0)
                    R.id.item_achievements -> fragmentPager.setCurrentItem(1)
                }
                true
            }
        }
    }
}