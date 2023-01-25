package com.merah.bawang.model;

public class Post {

    private String _PID;    // Primary Key
    private String _OID;    // Foreign Key

    public Post(String _PID, String _OID) {
        this._PID = _PID;
        this._OID = _OID;
    }

    // GETTERS

    public String get_PID() {
        return _PID;
    }

    public String get_OID() {
        return _OID;
    }

}
