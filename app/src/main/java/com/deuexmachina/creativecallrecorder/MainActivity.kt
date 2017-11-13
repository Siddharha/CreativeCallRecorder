package com.deuexmachina.creativecallrecorder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.ComponentName
import android.app.admin.DevicePolicyManager
import android.content.Context
import android.content.Intent
import android.content.Context.DEVICE_POLICY_SERVICE





class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 0
    private var mDPM: DevicePolicyManager?=null
    private var mAdminName: ComponentName?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
    }

    private fun initialize() {
        try {
            // Initiate DevicePolicyManager.
            mDPM = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
            mAdminName = ComponentName(this, DeviceAdminDemo::class.java!!)

            if (!mDPM!!.isAdminActive(mAdminName)) {
                val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN)
                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mAdminName)
                intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Click on Activate button to secure your application.")
                startActivityForResult(intent, REQUEST_CODE)
            } else {
                /* mDPM.lockNow();
                 Intent intent = new Intent(MainActivity.this,
                 TrackDeviceService.class);
                 startService(intent);*/
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        if (REQUEST_CODE == requestCode) {
            val intent = Intent(this@MainActivity, TService::class.java)
            startService(intent)
        }
    }
}
