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
     *      Upvotes
     *      Downvotes
     *      Post Profile
     *      Comment <List>
     */

    private String fullName;
    private String postText;
    private String postTitle;
    private int upvotes;
    private int postProfile;
    private ArrayList<String> comments;

    public PostItem(String _PID, String _OID, String fullName, String postText, String postTitle, int upvotes, int postProfile, ArrayList<String> comments) {
        super(_PID, _OID);
        this.fullName = fullName;
        this.postText = postText;
        this.postTitle = postTitle;
        this.upvotes = upvotes;
        this.postProfile = postProfile;
        this.comments = comments;
    }

    // TODO: REMOVE OLD CONSTRUCTOR
    public PostItem(String _PID, String _OID, String fullName, String postText, String postTitle, int upvotes, int postProfile) {
        super(_PID, _OID);
        this.fullName = fullName;
        this.postText = postText;
        this.upvotes = upvotes;
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

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public void setPostProfile(int postProfile) {
        this.postProfile = postProfile;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
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

    public int getUpvotes() {
        return upvotes;
    }

    public int getPostProfile() {
        return postProfile;
    }

    public ArrayList<String> getComments() {
        return comments;
    }
}
