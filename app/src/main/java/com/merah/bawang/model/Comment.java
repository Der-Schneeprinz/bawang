package com.merah.bawang.model;

public class Comment extends Post {
    /**
     * Table User
     * 	_UID
     *
     * Table Organization
     * 	_OID
     *
     * Table Member
     * 	_UID
     * 	_OID
     *
     * Table Posts
     * 	_OID
     * 	_PID
     *
     * Table Comment
     * 	_OID
     * 	_PID
     */

    private String _CID;    // Primary Key

    public Comment(String _PID, String _OID, String _CID) {
        super(_PID, _OID);
        this._CID = _CID;
    }

    // Copy Constructor
    public Comment(Comment comment) {
        super(comment.get_PID(), comment.get_OID());
        this._CID = comment._CID;
    }

    // GETTERS

    public String get_CID() {
        return _CID;
    }

}
