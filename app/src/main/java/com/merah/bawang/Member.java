package com.merah.bawang;

public class Member {

    private int profile;
    private String fullName;

    public Member(int profile, String fullName) {
        this.profile = profile;
        this.fullName = fullName;
    }

    public int getProfile() {
        return profile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
