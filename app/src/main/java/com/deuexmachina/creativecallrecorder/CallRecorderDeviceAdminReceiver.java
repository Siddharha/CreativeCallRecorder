package com.deuexmachina.creativecallrecorder;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by siddhartha on 13/11/17.
 */

public class CallRecorderDeviceAdminReceiver extends DeviceAdminReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    public void onEnabled(Context context, Intent intent) {
    }

    public void onDisabled(Context context, Intent intent) {
    }
}