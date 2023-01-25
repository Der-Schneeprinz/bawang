package com.merah.bawang.model;

public class Member extends User {

    // Entities for Member Type
    private final static int USER = 0;
    private final static int PENDING = 1;
    private final static int MEMBER = 2;
    private final static int MODERATOR = 3;
    private final static int ADMIN = 4;

    // Multiple key thing
    private String _MID;    // Primary Key
    private String _OID;    // Foreign Key

    public Member(String _UID, String _MID, String _OID) {
        super(_UID);
        this._MID = _MID;
        this._OID = _OID;
    }

    public Member(Member member) {
        super(member.get_UID());
        _MID = member._MID;
        _OID = member._OID;
    }

    // GETTERS
    public String get_UID() {
        return super.get_UID();
    }

    public String get_MID() {
        return _MID;
    }

    public String get_OID() {
        return _OID;
    }

}
