package bd.edu.seu.myfragmentexample.phoneFragment;


import android.os.Bundle;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bd.edu.seu.myfragmentexample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneFragment extends Fragment {

    public PhoneFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone, container, false);
    }

}
