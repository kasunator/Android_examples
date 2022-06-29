package com.example.mybleexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomDeviceListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_activity);
        ArrayList<DeviceView> arrayList = new ArrayList<DeviceView>();

        //DeviceView deviceView = new DeviceView();
        DeviceView deviceView1 = new DeviceView(R.drawable.ic_action_on, "Name 1" ,
                                                    "AA", "-10");
        DeviceView deviceView2 = new DeviceView(R.drawable.ic_action_on, "Name 2" ,
                "BB", "-11");
        DeviceView deviceView3 = new DeviceView(R.drawable.ic_action_on, "Name 3" ,
                "CC", "-10");
        DeviceView deviceView4 = new DeviceView(R.drawable.ic_action_on, "Name 1" ,
                "DD", "-60");
        arrayList.add(deviceView1);
        arrayList.add(deviceView2);
        arrayList.add(deviceView3);
        arrayList.add(deviceView4);
        //now create the instance of the CustomDeviceViewAdapter
        CustomDeviceViewAdapter customDeviceViewAdapter = new CustomDeviceViewAdapter(this,arrayList);

        //get the ListView defined inside the scan_activity.xml
        ListView numbersListView = (ListView)  findViewById(R.id.DeviceListview);

        //now lets set the customDeviceViewAdapter as the adapter for the ListView
        numbersListView.setAdapter(customDeviceViewAdapter);

    }
}
