package com.merah.bawang.model;

public class PostRVItem extends Post {

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
    private String postOrg;
    private String postText;
    private String postTitle;
    private int votes;
    private int postProfile;
    private Post post = new Post("", "");

    public PostRVItem(Post post, String fullName, String postOrg, String postText, String postTitle, int votes, int postProfile) {
        super(post);
        this.fullName = fullName;
        this.postOrg = postOrg;
        this.postText = postText;
        this.postTitle = postTitle;
        this.votes = votes;
        this.postProfile = postProfile;
    }

    public PostRVItem(PostRVItem postRVItem) {
        super(postRVItem.post);
        this.fullName = postRVItem.fullName;
        this.postOrg = postRVItem.postOrg;
        this.postText = postRVItem.postText;
        this.postTitle = postRVItem.postTitle;
        this.votes = postRVItem.votes;
        this.postProfile = postRVItem.postProfile;
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

}
