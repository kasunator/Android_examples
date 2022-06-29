package com.example.mybleexample;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class BleScan {

    private Handler mHandler;
    private Runnable mRunnable;
    private ScanCallback mScanCallback;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private BluetoothAdapter mBluetoothAdapter;
    private ScanSettings settings;
    private List<ScanFilter> mFilters;
    private Activity mParentActivity;

    public void BleScan(Activity activity) {
        mParentActivity = activity;
        createScanner();

    }
    private void createScanner() {
        if(mParentActivity != null) {
            final BluetoothManager bluetoothManager =
                    (BluetoothManager) mParentActivity.getSystemService(Context.BLUETOOTH_SERVICE);
            mBluetoothAdapter = bluetoothManager.getAdapter();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ScanSettings.Builder builder = new ScanSettings.Builder();
                builder.setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY);
                builder.setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES);
                settings = builder.build();
                createFilter();
            }
        }
    }

    private void createFilter() {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        builder.setDeviceName(null);
        ScanFilter filter = builder.build();
        mFilters = new ArrayList<ScanFilter>();
        mFilters.add(filter);
    }

}
