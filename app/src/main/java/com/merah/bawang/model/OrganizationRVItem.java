package com.merah.bawang.model;

public class OrganizationRVItem extends Organization{

    private int orgProfile;
    private String organizationName;
    private String membershipType;

    public OrganizationRVItem(String _OID, int orgProfile, String organizationName, String membershipType) {
        super(_OID);
        this.orgProfile = orgProfile;
        this.organizationName = organizationName;
        this.membershipType = membershipType;
    }

    // SETTERS

    public void setOrgProfile(int orgProfile) {
        this.orgProfile = orgProfile;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    // GETTERS

    public String get_OID() {
        return super.get_OID();
    }

    public int getOrgProfile() {
        return orgProfile;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getMembershipType() {
        return membershipType;
    }
}
