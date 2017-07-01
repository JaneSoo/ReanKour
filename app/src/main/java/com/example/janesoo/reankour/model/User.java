package com.example.janesoo.reankour.model;

import java.io.Serializable;

/**
 * Created by JaneSoo on 18-Jun-17.
 */

public class User implements Serializable {

    private String accountType;
    private String address;
    private String dob;
    private String position;
    private String education;
    private String email;
    private String experience;
    private String fullname;
    private String phone;
    private String sex;
    private String skill;
    private String isPublish;

    public User(){

    }


    public User(String isPublish,String position, String accountType, String address, String dob, String education, String email, String experience, String fullname, String phone, String sex, String skill) {
        this.isPublish=isPublish;
        this.position=position;
        this.accountType = accountType;
        this.address = address;
        this.dob = dob;
        this.education = education;
        this.email = email;
        this.experience = experience;
        this.fullname = fullname;
        this.phone = phone;
        this.sex = sex;
        this.skill = skill;
    }

    public String getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(String isPublish) {
        this.isPublish = isPublish;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
