package com.kkr95.howweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class DaeguFragment extends Fragment {

    public DaeguFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.fragment_daegu, container, false);

        return view;
    }
}
