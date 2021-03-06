package com.he.lq.demo

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.he.lq.ble.BleFragment
import com.android.he.lq.sdk.MotionFragment
import io.flutter.embedding.android.FlutterFragment

/*
    两个Fragment切换：FlutterFragment + MotionFragment
 */
class MainFragment : Fragment() {

    private var mainViewPager: ViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.main_frag, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewPager = view.findViewById(R.id.main_viewpager)
        mainViewPager?.adapter = MainAdapter(childFragmentManager)
        mainViewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                mainViewPager?.setCurrentItem(position)
            }
        })
    }


    private inner class MainAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm) {

        var itemCount = 3

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    // 删除io.flutter.facade 包下的FlutterFragment
                    return FlutterFragment.createDefault()
                }
                1 -> {
                    return MotionFragment()
                }
                2 -> {
                    return BleFragment()
                }
                else -> {
                    return MotionFragment()
                }
            }
        }

        override fun getCount(): Int {
            return itemCount
        }
    }

}