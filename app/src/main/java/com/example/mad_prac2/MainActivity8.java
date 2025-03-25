package com.example.mad_prac2;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Set;

public class MainActivity8 extends AppCompatActivity {
    BluetoothAdapter bluetoothAdapter;
    private static final int REQUEST_BLUETOOTH_PERMISSIONS = 1;
    Button next_prac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        next_prac=findViewById(R.id.next_prac);

        next_prac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity8.this,MainActivity9.class);
                startActivity(intent);
            }
        });


        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetooth is not supported on this device", Toast.LENGTH_LONG).show();
            return;
        }

        requestBluetoothPermissions();
    }

    // Request Bluetooth permissions at runtime
    private void requestBluetoothPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADVERTISE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.BLUETOOTH_CONNECT,
                            Manifest.permission.BLUETOOTH_ADVERTISE
                    },
                    REQUEST_BLUETOOTH_PERMISSIONS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_BLUETOOTH_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Bluetooth permissions granted!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth permissions denied! Some features may not work.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Turn ON Bluetooth
    public void turnon(View view) {
        if (bluetoothAdapter == null) return;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
            if (!bluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
                Toast.makeText(this, "Turning ON Bluetooth...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth is already ON", Toast.LENGTH_SHORT).show();
            }
        } else {
            requestBluetoothPermissions();
        }
    }

    // Turn OFF Bluetooth
    public void turnoff(View view) {
        if (bluetoothAdapter == null) return;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
                Toast.makeText(this, "Bluetooth Turned OFF", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetooth is already OFF", Toast.LENGTH_SHORT).show();
            }
        } else {
            requestBluetoothPermissions();
        }
    }

    // Make Device Discoverable
    public void getVisible(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADVERTISE) == PackageManager.PERMISSION_GRANTED) {
            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
            startActivity(discoverableIntent);
            Toast.makeText(this, "Device is now discoverable", Toast.LENGTH_SHORT).show();
        } else {
            requestBluetoothPermissions();
        }
    }

    // List Paired Devices
    public void listDevices(View view) {
        if (bluetoothAdapter == null) return;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED) {
            Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();

            if (pairedDevices.size() > 0) {
                StringBuilder devicesList = new StringBuilder("Paired Devices:\n");
                for (BluetoothDevice device : pairedDevices) {
                    devicesList.append(device.getName()).append(" - ").append(device.getAddress()).append("\n");
                }
                Toast.makeText(this, devicesList.toString(), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "No paired Bluetooth devices found", Toast.LENGTH_SHORT).show();
            }
        } else {
            requestBluetoothPermissions();
        }
    }
}



