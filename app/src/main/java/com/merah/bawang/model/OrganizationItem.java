package com.merah.bawang.model;

import java.util.ArrayList;

public class OrganizationItem extends Organization {


    private String organizationName;
    private String description;
    private ArrayList<String> members; // _UID
    private ArrayList<String> followers; // _UID
    private int memberCount;
    private int followerCount;

    public OrganizationItem(String _OID, String organizationName, String description, ArrayList<String> members, ArrayList<String> followers, int memberCount, int followerCount) {
        super(_OID);
        this.organizationName = organizationName;
        this.description = description;
        this.members = members;
        this.followers = followers;
        this.memberCount = memberCount;
        this.followerCount = followerCount;
    }

    // SETTERS

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public void setFollower(ArrayList<String> followers) {
        this.followers = followers;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    // GETTERS

    public String get_OID() {
        return super.get_OID();
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }
}
