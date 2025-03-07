package com.quotes.creator.maker.quotify.app.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.android.bringit.base.BaseActivity

abstract class BaseFragment : Fragment() {

    lateinit var activity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = requireActivity() as BaseActivity
    }

}
