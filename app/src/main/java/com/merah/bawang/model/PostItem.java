package com.merah.bawang.model;

import java.util.ArrayList;

public class PostItem extends Post {

    /**
     * Post Contains
     *      _PID
     *      _OID (class)
     *      Full Name
     *      Post Text
     *      Post Title
     *      Votes
     *      Post Profile
     *      Comment <List>
     *      Dates
     */

    private String fullName;
    private String postText;
    private String postTitle;
    private int votes;
    private int postProfile;
    private ArrayList<String> comments;
    private String date;

    public PostItem(String _PID, String _OID, String fullName, String postText, String postTitle, int votes, int postProfile, ArrayList<String> comments, String date) {
        super(_PID, _OID);
        this.fullName = fullName;
        this.postText = postText;
        this.postTitle = postTitle;
        this.votes = votes;
        this.postProfile = postProfile;
        this.comments = comments;
        this.date = date;
    }


}
