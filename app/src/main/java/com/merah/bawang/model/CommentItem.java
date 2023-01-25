package com.merah.bawang.model;

public class CommentItem extends Comment{

    /**
     * Comment Contains
     *      _CID
     *      _PID
     *      Full Name
     *      Comment Text
     *      Profile Picture
     */

    private String fullName;
    private String commentText;
    private int profilePicture;

    public CommentItem(String _CID, String _PID, String fullName, String commentText, int profilePicture) {
        super(_CID, _PID);
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
        return super.get_CID();
    }

    public String get_PID() {
        return super.get_PID();
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
