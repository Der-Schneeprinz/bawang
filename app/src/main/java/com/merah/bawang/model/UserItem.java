package com.merah.bawang.model;

import java.util.ArrayList;

public class UserItem extends User {

    /**
     * User Contains:
     *      _UID
     *      First Name
     *      Middle Name
     *      Last Name
     *      Email
     *      Password
     *      Profile Picture
     *      Student No.
     *      Sex
     *      _OID <List>
     *      Following (_OID) <List>
     */

    private enum SexType {
        FEMALE,
        MALE
    }

    User user;

    // Full Name
    private String firstName;
    private String middleName;
    private String lastName;
    private String fullName;
    // Authentication
    private String email;
    private String password;
    // Others
    private int profilePicture;
    private String studentNo;
    private SexType sexType;
    private ArrayList<String> _OID;
    private ArrayList<String> following;

    private UserItem(String _UID, String firstName, String middleName, String lastName, String email, String password, int profilePicture, String studentNo, SexType sexType, ArrayList<String> _OID, ArrayList<String> following) {
        super(_UID);
        // Full Name
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fullName = firstName + " " + middleName + " " + lastName;
        // Authentication
        this.email = email;
        this.password = password;
        // Others
        this.profilePicture = profilePicture;
        this.studentNo = studentNo;
        this.sexType = sexType;
        this._OID = _OID;
        this.following = following;
    }

    // Copy Constructor
    private UserItem(UserItem userItem) {
        super(userItem.user);
        this.firstName = userItem.firstName;
        this.middleName = userItem.middleName;
        this.lastName = userItem.lastName;
        this.email = userItem.email;
        this.password = userItem.password;
        this.profilePicture = userItem.profilePicture;
        this.studentNo = userItem.studentNo;
        this.sexType = userItem.sexType;
        this._OID = userItem._OID;
        this.following = userItem.following;
    }

    // SETTERS

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFullName() {
        this.fullName = this.firstName + " " + this.middleName + " " + this.lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilePicture(int profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public void setSexType(SexType sexType) {
        this.sexType = sexType;
    }

    public void set_OID(ArrayList<String> _OID) {
        this._OID = _OID;
    }

    public void setFollowing(ArrayList<String> following) {
        this.following = following;
    }

    // GETTERS

    public String get_UID() {
        return super.get_UID();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getProfilePicture() {
        return profilePicture;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public SexType getSexType() {
        return sexType;
    }

    public ArrayList<String> get_OID() {
        return _OID;
    }

    public ArrayList<String> getFollowing() {
        return following;
    }


}
