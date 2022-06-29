package com.example.mybleexample;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class DeviceListActivity extends  Activity {
    ListView mDeviceListview;
    ArrayAdapter<String> mArrAdapter;
    ArrayList<String> testDevList = new ArrayList<String>(){
        {
            add("device 1");
            add("device 2");
            add("device 3");
        }
    };
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_activity);
        /* find the List view defined in the layout*/
        mDeviceListview = (ListView) findViewById(R.id.DeviceListview);
        /* now let us create an ArrayAdapter using the ArrayList */

        /*mArrAdapter = new ArrayAdapter<String>(this,
                android.support.constraint.R.layout.support_simple_spinner_dropdown_item,
                testDevList);*/
        /*mArrAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                testDevList);*/
        mArrAdapter = new ArrayAdapter<String>(this,
                R.layout.my_simple_activity_listview,
                testDevList);
        /*now set mArrAdapter as the adapter of the mDeviceListview */
        mDeviceListview.setAdapter(mArrAdapter);

    }

}
