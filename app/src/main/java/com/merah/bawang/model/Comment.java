package com.merah.bawang.model;

public class Comment {

    private String _CID;    // Primary Key
    private String _PID;    // Foreign Key

    public Comment(String _CID, String _PID) {
        this._CID = _CID;
        this._PID = _PID;
    }

    // GETTERS

    public String get_CID() {
        return _CID;
    }

    public String get_PID() {
        return _PID;
    }
}
