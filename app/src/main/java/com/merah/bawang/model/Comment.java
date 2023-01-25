package com.merah.bawang.model;

public class Comment {

    /**
     * Comment Contains
     *      _CID
     *      _PID
     *      Full Name
     *      Comment Text
     *      Profile Picture
     */

    private String _CID;
    private String _PID;
    private String fullName;
    private String commentText;
    private int profilePicture;

    public Comment(String _CID, String _PID, String fullName, String commentText, int profilePicture) {
        this._CID = _CID;
        this._PID = _PID;
        this.fullName = fullName;
        this.commentText = commentText;
        this.profilePicture = profilePicture;
    }

    // SETTERS

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    // GETTERS

    public String get_CID() {
        return _CID;
    }

    public String get_PID() {
        return _PID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCommentText() {
        return commentText;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

}
