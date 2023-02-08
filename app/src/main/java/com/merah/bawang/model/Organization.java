package com.merah.bawang.model;

import java.util.ArrayList;

public class Organization {

    /**
     * Organization Contains
     *      _OID
     *      Organization Name
     *      Description
     *      Member (class) (First 100 members) <List>
     *      Follower <List>
     *      Member Count
     *      Follower Count
     */

    private String _OID;

    public Organization(String _OID) {
        this._OID = _OID;
    }

    // GETTER

    public String get_OID() {
        return _OID;
    }
}
