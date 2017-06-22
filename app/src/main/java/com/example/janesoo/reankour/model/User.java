package com.example.janesoo.reankour.model;

import java.io.Serializable;

/**
 * Created by JaneSoo on 18-Jun-17.
 */

public class User implements Serializable {

    private String fullname, sex, email, password, address, skill, phone, education, position, experience;
    String usertype;
    private int picture;

    public User(){

    }

    public User(String name, String email, String password, String usertype) {
        this.fullname = name;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
    }

    public User(String name, String address, String skill, String experience, int picture) {
        this.fullname = name;
        this.address = address;
        this.skill = skill;
        this.experience = experience;
        this.picture = picture;
    }

    public User(String sex, String address, String skill, String phone, String education, String position, String experience, int picture) {
        this.sex = sex;
        this.address = address;
        this.skill = skill;
        this.phone = phone;
        this.education = education;
        this.position = position;
        this.experience = experience;
        this.picture = picture;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getfullname() {
        return fullname;
    }

    public void setfullname(String name) {
        this.fullname = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

}
