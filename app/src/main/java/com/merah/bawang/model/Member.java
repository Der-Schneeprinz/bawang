package com.merah.bawang.model;

public class Member extends User {

    private enum MemberType{
        MEMBER,
        MODERATOR,
        ADMIN
    }

    private String _OID;    // Foreign Key
    private MemberType memberType;

    public Member(String _UID, String _OID) {
        super(_UID);
        this._OID = _OID;
    }

    // Copy Constructor
    public Member(Member member) {
        super(member.get_UID());
        _OID = member._OID;
    }

    // GETTERS
    public String get_UID() {
        return super.get_UID();
    }


    public String get_OID() {
        return _OID;
    }

}
