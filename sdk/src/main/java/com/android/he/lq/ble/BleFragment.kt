package com.android.he.lq.ble

import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.android.baidu.imsdk.R

class BleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.ble_frag, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!context!!.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(context, R.string.ble_not_supported, Toast.LENGTH_SHORT).show()
            activity!!.finish()
        }

//        private fun PackageManager.missingSystemFeature(name: String): Boolean = !hasSystemFeature(name)
//        ...
//
//        packageManager.takeIf { it.missingSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE) }?.also {
//            Toast.makeText(this, R.string.ble_not_supported, Toast.LENGTH_SHORT).show()
//            finish()
//        }

    }
}