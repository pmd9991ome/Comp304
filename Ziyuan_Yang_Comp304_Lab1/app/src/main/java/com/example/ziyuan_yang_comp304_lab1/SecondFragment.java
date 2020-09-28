package com.example.ziyuan_yang_comp304_lab1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    TextView tvFirst,tvSecond;

    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        //
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        tvFirst= (TextView) view.findViewById(R.id.first);
        tvSecond= (TextView)view.findViewById(R.id.second);

        return view;

    }
    public void display(String first, String second){
        tvFirst.setText(first);
        tvSecond.setText(second);

    }
    String tag = "Lifecycle";

    @Override
    //public void onCreate(Bundle savedInstanceState) {
    // super.onCreate(savedInstanceState);
    // setContentView(R.layout.activity_main);
    //  Log.d(tag, "In the onCreate() event");

    //}
    //
    public void onStart()
    {
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }
    //

    public void onResume()
    {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }
    public void onPause()
    {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }
    //
    public void onStop()
    {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }
}