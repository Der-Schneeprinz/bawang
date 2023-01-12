package com.merah.bawang;

public class ItemPostContent {
    String postUsername;
    String postOrg;
    String postText;
    String postTitle;
    String postUpvotes;
    String postDownvotes;
    int postProfile;

    public ItemPostContent(String postUsername, String postOrg, String postText, String postTitle, String postUpvotes, String postDownvotes, int postProfile) {
        this.postUsername = postUsername;
        this.postOrg = postOrg;
        this.postText = postText;
        this.postUpvotes = postUpvotes;
        this.postDownvotes = postDownvotes;
        this.postProfile = postProfile;
        this.postTitle = postTitle;
    }

    public String getPostUsername() {
        return postUsername;
    }

    public String getPostOrg() {
        return postOrg;
    }

    public String getPostText() {
        return postText;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public String getPostUpvotes() {
        return postUpvotes;
    }

    public String getPostDownvotes() {
        return postDownvotes;
    }

    public int getPostProfile() {
        return postProfile;
    }
}
