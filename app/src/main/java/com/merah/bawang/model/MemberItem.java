package com.merah.bawang.model;

public class MemberItem extends Member {

    /**
     * Member Contains
     *      _MID
     *      _OID
     *      Member Type { Pending, Member, Moderator, Admin }
     *      Full Name
     *      Profile Picture
     */

    private String fullName;
    private int profilePicture;

    public MemberItem(Member member, String fullName, int profilePicture) {
        super(member);
        this.fullName = fullName;
        this.profilePicture = profilePicture;
    }

    // TODO: REMOVE OLD CONSTRUCTOR
    public MemberItem(Member member, int profilePicture, String fullName) {
        super(member);
        this.profilePicture = profilePicture;
        this.fullName = fullName;
    }

    // SETTERS

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // GETTERS
    public String get_OID() {
        return super.get_OID();
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

}
