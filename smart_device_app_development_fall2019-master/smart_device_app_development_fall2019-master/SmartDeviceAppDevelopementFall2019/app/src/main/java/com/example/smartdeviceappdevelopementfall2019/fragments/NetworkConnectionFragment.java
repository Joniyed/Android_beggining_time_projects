package com.example.smartdeviceappdevelopementfall2019.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartdeviceappdevelopementfall2019.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NetworkConnectionFragment extends Fragment {


    public NetworkConnectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_network_connection, container, false);
    }

}
