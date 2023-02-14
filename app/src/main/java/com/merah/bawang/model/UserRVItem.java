package com.merah.bawang.model;

public class UserRVItem extends User {

    private int profile;
    private String fullName;
    private User user = new User("");

    public UserRVItem(User user, int profile, String fullName) {
        super(user);
        this.profile = profile;
        this.fullName = fullName;
    }

    public UserRVItem(UserRVItem userRVItem) {
        super(userRVItem.user);
        this.profile = userRVItem.profile;
        this.fullName = userRVItem.fullName;
    }

    // SETTERS

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // GETTERS

    public String get_UID() {
        return super.get_UID();
    }

    public int getProfile() {
        return profile;
    }

    public String getFullName() {
        return fullName;
    }
}
