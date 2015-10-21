package edu.kvcc.cis298.inclass3.inclass3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class CrimeFragment extends Fragment {

    //declare a class level variable for a crime
    private Crime mCrime;
    private EditText mTitleField;

    //this does not inflate the view like one for an activity
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    //this method is responsible for inflating the view
    //amd getting the content on the screen
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        
        mTitleField = (EditText)v.findViewById(R.id.crime_title);

        return v;
    }

}
