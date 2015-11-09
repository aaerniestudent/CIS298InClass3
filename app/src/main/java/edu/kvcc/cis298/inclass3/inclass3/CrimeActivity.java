package edu.kvcc.cis298.inclass3.inclass3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import java.util.UUID;


public class CrimeActivity extends SingleFragmentActivity {

    //Setup a string const for the key part of the Extra
    private static final String EXTRA_CRIME_ID =
            "edu.kvcc.cis298.inclass3.inclass3.crime_id";

    //this is public and static so that any other activity or fragment can get a properly formatted intent
    public static Intent newIntent(Context packageContext, UUID crimeId) {
        Intent intent = new Intent(packageContext,CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    protected Fragment createFragment(){
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }
}