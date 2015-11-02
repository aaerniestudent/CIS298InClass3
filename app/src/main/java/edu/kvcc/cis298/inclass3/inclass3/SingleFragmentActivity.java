package edu.kvcc.cis298.inclass3.inclass3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by aaernie7528 on 11/2/2015.
 */
public abstract class SingleFragmentActivity extends FragmentActivity {

    //this method is declared abstract so that every activity
    //that we create must implement this method. Instead of having
    //every activity that we create inherit from FragmentActivity
    //it will inherit from THIS class, which now provides some base
    //functionality for us. we no longer need to duplicate
    //this code in any child activity we create
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //get a variable that represents the support version of the fragment manager
        //If the android OS version of Fragment manager is imported this statement will
        // fail. must have supported version imported.
        FragmentManager fm = getSupportFragmentManager();

        //uses the fragment manager to get the fragment that is currently in the frame
        //that we created in the crimeFragment.xml file.
        //On the start of the app, this will be null since there won't be anything there
        //until we add it. Once something is added, this method will return whatever is in it
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        //at the start fragment will be null, this adds the fragment to the frame and makes it not.
        if (fragment == null){
            //create a new instance to "fill" null
            fragment = createFragment();
            //this adds it to the frame by:
            //starting a transaction;
            //adding the to be attached fragment;
            //and committing the changes
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
