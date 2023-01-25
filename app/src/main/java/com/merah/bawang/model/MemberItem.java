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

    private Member member;

    private int memberType;
    private String fullName;
    private int profilePicture;

    public MemberItem(Member member, int memberType, String fullName, int profilePicture) {
        super(member);
        this.memberType = memberType;
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

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // GETTERS

    public String get_MID() {
        return super.get_MID();
    }

    public String get_OID() {
        return super.get_OID();
    }

    public int getMemberType() {
        return memberType;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public String getFullName() {
        return fullName;
    }

}
