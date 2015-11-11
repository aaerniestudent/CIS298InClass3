package edu.kvcc.cis298.inclass3.inclass3;

import android.content.Context;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by aaernie7528 on 10/28/2015.
 */
public class CrimeLab {

    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    //make a class level variable to hold the context that is passed into the constructor
    //we will need access to the context in order to read the data file.
    private Context mContext;

    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }
    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();

        mContext = context;

        for (int i = 0; i <100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i%2 == 0);
            mCrimes.add(crime);
        }
    }
    public List<Crime> getCrimes(){
        return mCrimes;
    }
    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }

    private void loadCrimeList() {

        Scanner scanner;

        try {
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.crimes));

            String line = scanner.nextLine();

            String parts[] = line.split(",");

            String id = parts[0];
            String title = parts[1];
            String dateString = parts[2];
            String solved = parts[3];

            UUID uuid = UUID.fromString(id);
            boolean isSolved;
            if (solved.equals("T")) {
                isSolved = true;
            } else {
                isSolved = false;
            }

            DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = df.parse(dateString);

            mCrimes.add(new Crime(uuid,title,date,isSolved));

        } catch (Exception e){
            Log.e("Read CSV", e.toString());
        }
    }

}
