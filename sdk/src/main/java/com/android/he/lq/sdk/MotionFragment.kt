package com.android.he.lq.sdk

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.baidu.imsdk.R

/**
 * 本类源于https://mp.weixin.qq.com/s/Cs3_9vIC3IKrZ4KzBtKoYw
 * 代码仓库 https://github.com/Moosphan/ConstraintSample
 *
 * MotionLayout作为ConstraintLayout的子类，可以约束子视图
 *      MotionLayout可分为<View>(ConstraintLayout) 和 <Helper>(动画层)两部分。
 *      MotionScene 主要由三部分组成：StateSet、ConstraintSet 和 Transition。
 */
class MotionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.motion_frag, container, false)
    }


}