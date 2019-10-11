package com.android.he.lq.ble

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.le.BluetoothLeScanner
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.baidu.imsdk.R

class BleFragment : Fragment() {

    /*
    使用startLeScan()
     */
    private var mScanning: Boolean = false
    private val handler: Handler = Handler(Looper.getMainLooper())

    private val bluetoothAdapter: BluetoothAdapter by lazy(LazyThreadSafetyMode.NONE) {
        val bluetoothManager = context!!.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothManager.adapter
    }

    private val BluetoothAdapter.isDisabled: Boolean
        get() = !isEnabled


    private val leScanCallback = BluetoothAdapter.LeScanCallback { device, rssi, scanRecord ->
        activity!!.runOnUiThread {
            Log.e("HEHE", "leScanCallback ：" + device.toString())
            Toast.makeText(context, device.name, Toast.LENGTH_LONG).show()
//            leDeviceListAdapter.addDevice(device)
//            leDeviceListAdapter.notifyDataSetChanged()
        }
    }

    private fun PackageManager.missingSystemFeature(name: String): Boolean = !hasSystemFeature(name)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.ble_frag, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!context!!.getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)) {
            Toast.makeText(context, R.string.ble_not_supported, Toast.LENGTH_SHORT).show()
            activity!!.finish()
        }


//        bluetoothAdapter?.takeIf { it.isDisabled }?.apply {
//            val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
//            startActivityForResult(enableBtIntent, Companion.REQUEST_ENABLE_BT)
//        }
//        scanLeDevice(true)

        // 这是第二种方法
//        context!!.startActivity(Intent(context, BleActivity::class.java))
        context!!.startActivity(Intent(context, Ble2Activity::class.java))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == Companion.REQUEST_ENABLE_BT) {
            // find ble devices
            scanLeDevice(true)
        }
    }

    private fun scanLeDevice(enable: Boolean) {
        when (enable) {
            true -> {
                // Stops scanning after a pre-defined scan period.
                handler.postDelayed({
                    mScanning = false
                    bluetoothAdapter.stopLeScan(leScanCallback)
                }, SCAN_PERIOD)
                mScanning = true
                Log.e("HEHE", "发现蓝牙设备 ：" + bluetoothAdapter.startDiscovery())
                bluetoothAdapter.startLeScan(leScanCallback)
            }
            else -> {
                mScanning = false
                bluetoothAdapter.stopLeScan(leScanCallback)
            }
        }
    }





    companion object {
        // 扫描时间
        private const val SCAN_PERIOD: Long = 10000
        // 申请蓝牙权限
        private const val REQUEST_ENABLE_BT = 100
    }

}