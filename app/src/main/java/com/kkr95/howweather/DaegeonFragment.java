package com.kkr95.howweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class DaegeonFragment extends Fragment {

    public DaegeonFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.fragment_daegeon, container, false);

        return view;
    }
}
