package edu.kvcc.cis298.inclass3.inclass3;

import java.util.UUID;

/**
 * Created by aaernie7528 on 10/19/2015.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime(){
        //generate unique identifier
        mId = UUID.randomUUID();
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
