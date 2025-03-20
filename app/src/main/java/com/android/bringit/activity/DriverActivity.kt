package com.android.bringit.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.android.bringit.R
import com.android.bringit.base.BaseActivity
import com.android.bringit.databinding.ActivityDriverBinding
import com.android.bringit.fragment.HistoryFragment
import com.android.bringit.fragment.HomeFragment
import com.android.bringit.fragment.ProfileFragment
import com.android.bringit.fragment.WalletFragment

class DriverActivity : BaseActivity() {

    private lateinit var binding: ActivityDriverBinding

    lateinit var mCurrentLoadedFragment: Fragment
    lateinit var mFragmentManager: FragmentManager
    lateinit var mFragmentTransaction: FragmentTransaction

    lateinit var homeFragment: HomeFragment
    lateinit var walletFragment: WalletFragment
    lateinit var historyFragment: HistoryFragment
    lateinit var profileFragment: ProfileFragment
    var selectedFragment: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDriverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.llHome.setOnClickListener(View.OnClickListener {
            if (selectedFragment == 1)
                return@OnClickListener
            selectedFragment = 1
            homeFragment = HomeFragment()

            replaceFragmentMain(homeFragment)
            selectTab(binding.llImgHome, binding.ivHome, binding.tvHome)
        })

        binding.llWallet.setOnClickListener(View.OnClickListener {
            if (selectedFragment == 2)
                return@OnClickListener
            selectedFragment = 2
            walletFragment = WalletFragment()

            replaceFragmentMain(walletFragment)
            selectTab(binding.llImgWallet, binding.ivWallet, binding.tvWallet)
        })

        binding.llHistory.setOnClickListener(View.OnClickListener {
            if (selectedFragment == 3)
                return@OnClickListener
            selectedFragment = 3
            historyFragment = HistoryFragment()

            replaceFragmentMain(historyFragment)
            selectTab(binding.llImgHistory, binding.ivHistory, binding.tvHistory)
        })

        binding.llProfile.setOnClickListener(View.OnClickListener {
            if (selectedFragment == 4)
                return@OnClickListener
            selectedFragment = 4
            profileFragment = ProfileFragment()

            replaceFragmentMain(profileFragment)
            selectTab(binding.llImgProfile, binding.ivProfile, binding.tvProfile)
        })

        // Set default selection
        selectTab(binding.llImgHome, binding.ivHome, binding.tvHome)
    }

    private fun replaceFragmentMain(fragment: Fragment) {
        mCurrentLoadedFragment = fragment
        mFragmentManager = supportFragmentManager
        mFragmentTransaction = mFragmentManager.beginTransaction()
        mFragmentTransaction
            .replace(
                R.id.content_frame,
                mCurrentLoadedFragment,
                mCurrentLoadedFragment.javaClass.simpleName.toString()
            )
            .commit()
    }

    private fun selectTab(selectedTab: LinearLayout, selectedIcon: ImageView, selectedText: TextView) {
        resetTabs()

        selectedTab.setBackgroundResource(R.drawable.selected_tab_bg)
        selectedIcon.setColorFilter(ContextCompat.getColor(this, R.color.white))
        selectedText.setTextColor(ContextCompat.getColor(this, R.color.white))
    }

    private fun resetTabs() {
        val allTabs = listOf(binding.llImgHome, binding.llImgWallet, binding.llImgHistory, binding.llImgProfile)
        val allIcons = listOf(binding.ivHome, binding.ivWallet, binding.ivHistory, binding.ivProfile)
        val allTexts = listOf(binding.tvHome, binding.tvWallet, binding.tvHistory, binding.tvProfile)

        for (i in allTabs.indices) {
            allTabs[i].setBackgroundResource(android.R.color.transparent)
            allIcons[i].setColorFilter(ContextCompat.getColor(this, R.color.white))
            allTexts[i].setTextColor(ContextCompat.getColor(this, R.color.white))
        }
    }
}