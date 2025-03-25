package com.example.mad_prac2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class SystemBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action != null) {
            switch (action) {
                case Intent.ACTION_BOOT_COMPLETED:
                    showToast(context, "Device Boot Completed");
                    break;

                case Intent.ACTION_BATTERY_CHANGED:
                    showToast(context, "Battery Level Changed");
                    break;

                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    boolean state = intent.getBooleanExtra("state", false);
                    showToast(context, "Airplane Mode: " + (state ? "ON" : "OFF"));
                    break;

                case Intent.ACTION_SCREEN_ON:
                    showToast(context, "Screen ON");
                    break;

                case Intent.ACTION_SCREEN_OFF:
                    showToast(context, "Screen OFF");
                    break;

                case Intent.ACTION_POWER_CONNECTED:
                    showToast(context, "Power Connected");
                    break;

                case Intent.ACTION_POWER_DISCONNECTED:
                    showToast(context, "Power Disconnected");
                    break;

                case "android.net.wifi.WIFI_STATE_CHANGED":
                    showToast(context, "WiFi State Changed");
                    break;

                default:
                    showToast(context, "Received Unknown Broadcast");
                    break;
            }
        }
    }

    private void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        Log.d("SystemBroadcastReceiver", message);
    }
}
