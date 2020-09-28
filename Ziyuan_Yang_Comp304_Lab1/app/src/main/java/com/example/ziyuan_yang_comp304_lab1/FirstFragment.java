package com.example.ziyuan_yang_comp304_lab1;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends ListFragment {

    String[] first = new String[]
            {
             "AIActivity",
             "VRActivity",
            };
    //
    String[] second = new String[]
            {"AIActivity",
             "VRActivity",
            };



    @Override


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_first, container, false);
        //ArrayAdapter creates a view for each array item
        // by calling toString() on each item and placing
        // the contents in a TextView.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, first);
        //bind the list view with array adapter
        setListAdapter(adapter);

        return view;

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        SecondFragment fragment = (SecondFragment) getFragmentManager().findFragmentById(R.id.fragment_second);
        fragment.display(first[position],"Second : "+second[position]);
        getListView().setSelector(android.R.color.holo_green_dark);
    }

    String tag = "Lifecycle";


    //
    @Override
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