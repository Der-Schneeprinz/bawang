package com.merah.bawang.model;

import java.util.ArrayList;

public class PostItem extends Post {

    /**
     * Post Contains
     *      _PID
     *      Full Name
     *      _OID (class)
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

    // TODO: REMOVE OLD CONSTRUCTOR
    public PostItem(String _PID, String _OID, String fullName, String postText, String postTitle, int votes, int postProfile) {
        super(_PID, _OID);
        this.fullName = fullName;
        this.postText = postText;
        this.votes = votes;
        this.postProfile = postProfile;
        this.postTitle = postTitle;
    }

    // SETTERS

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void setPostProfile(int postProfile) {
        this.postProfile = postProfile;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // GETTERS

    @Override
    public String get_PID() {
        return super.get_PID();
    }

    @Override
    public String get_OID() {
        return super.get_OID();
    }

    public String getFullName() {
        return fullName;
    }

    public String getPostText() {
        return postText;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public int getVotes() {
        return votes;
    }

    public int getPostProfile() {
        return postProfile;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public String getDate() {
        return date;
    }
}
