package com.example.mybleexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomDeviceViewAdapter extends ArrayAdapter<DeviceView> {
    public CustomDeviceViewAdapter(@NonNull Context context, ArrayList<DeviceView> arrayList) {
        super(context , 0 , arrayList);
    }
    /*	getView(int position, View convertView, ViewGroup parent)
        Get a View that displays the data at the specified position in the data set.
        You can either create a View manually or inflate it from an XML layout file.
        When the View is inflated, the parent View (GridView, ListView...) will apply
        default layout parameters unless you use LayoutInflater.inflate(int, android.view.ViewGroup, boolean)
        to specify a root view and to prevent attachment to the root.
     */
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentItemView = convertView;
        if (currentItemView == null) {
            /* there are few ways to get the LayoutInflater */
            /* method 1, this is less readable, more shorthand*/
            /*currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_device_list_view,
                                                                            parent, false); */
            /*method 2*/
            Context context = getContext();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            currentItemView = inflater.inflate(R.layout.custom_device_list_view,parent,false);
        }
        /*public T getItem (int position)
          Get the data item associated with the
          specified position in the data set
         */
        DeviceView pDeviceView =  getItem(position);
        /* according to the position assign the view the desired image */
        ImageView deviceImage = currentItemView.findViewById(R.id.imageView);
        assert pDeviceView != null;
        //get DeviceView's DeviceImageID
        // drawable resource R.drawable."image_name"
        deviceImage.setImageResource(pDeviceView.getDeviceImageID());

        /*according to the position assign the text to the TextView1 of the view */
        TextView textView1 = currentItemView.findViewById(R.id.textView1);
        textView1.setText(pDeviceView.getDeviceName());

        /*according to the position assign the text to the TextView2 of the view */
        TextView textView2 = currentItemView.findViewById(R.id.textView2);
        textView2.setText(pDeviceView.getDeviceAddress());

        /*according to the position assign the text to the TextView3 of the view */
        TextView textView3 = currentItemView.findViewById(R.id.textView3);
        textView3.setText(pDeviceView.getRSSILevel());
        return currentItemView;
    }
}
