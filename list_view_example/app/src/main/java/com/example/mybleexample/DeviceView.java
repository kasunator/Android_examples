package com.example.mybleexample;

public class DeviceView {

    private String mDeviceName;
    private String mDeviceAddress;
    private String mRSSILevel;
    private int mDeviceImageID = R.drawable.ic_action_on;

    public DeviceView(int deviceImageID, String deviceName, String deviceAddress, String rSSILevel) {
        mDeviceName = deviceName;
        mDeviceAddress = deviceAddress;
        mRSSILevel = rSSILevel;
        mDeviceImageID = deviceImageID;
    }
    public String getDeviceName() {
        return  mDeviceName;
    }

    public String getDeviceAddress() {
        return  mDeviceAddress;
    }

    public String getRSSILevel() {
        return  mRSSILevel;
    }

    public int getDeviceImageID() {
        return mDeviceImageID;
    }
}
