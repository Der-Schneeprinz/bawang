package com.merah.bawang.model;

public class UserSelfProfileItem extends User{

    private User user = new User("");
    private int profile;
    private String fullName;
    private String email;
    private String sex;
    private String birthdate;
    private String studentNo;

    public UserSelfProfileItem(User user) {
        super(user);
    }

    public UserSelfProfileItem(User user, int profile, String fullName, String email, String sex, String birthdate, String studentNo) {
        super(user);
        this.profile = profile;
        this.fullName = fullName;
        this.email = email;
        this.sex = sex;
        this.birthdate = birthdate;
        this.studentNo = studentNo;
    }

    // SETTERS

    public void setUser(User user) {
        this.user = user;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    // GETTERS

    public User getUser() {
        return user;
    }

    public int getProfile() {
        return profile;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getStudentNo() {
        return studentNo;
    }

}
