package edu.kvcc.cis298.inclass3.inclass3;

import java.util.Date;
import java.util.UUID;

/**
 * Created by aaernie7528 on 10/19/2015.
 */
public class Crime {

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public Crime(){
        //generate unique identifier
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    //4 parameter constructor to make a new crime
    public Crime(UUID uuid, String title, Date date, boolean isSolved){
        mId = uuid;
        mTitle = title;
        mDate = date;
        mSolved = isSolved;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
