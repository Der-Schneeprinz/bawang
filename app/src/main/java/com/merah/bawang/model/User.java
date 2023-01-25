package com.merah.bawang.model;

public class User {

    private String _UID;

    public User(String _UID) {
        this._UID = _UID;
    }

    public User(User user) {
        this(user._UID);
    }

    // GETTER

    public String get_UID() {
        return _UID;
    }
}
