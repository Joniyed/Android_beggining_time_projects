package com.example.smartdeviceappdevelopementfall2019.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Employee {

    @SerializedName("id")
    public String id;
    @SerializedName("employee_name")
    public  String name;
    @SerializedName("employee_salary")
    public String salary;
    @SerializedName("employee_age")
    public  String age;
    @SerializedName("profile_image")
    public String profile_image;

//    private  int id;
//    private String name;
//    private String salary;
//    private String age;
//    private String profilepicture;
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSalary() {
//        return salary;
//    }
//
//    public void setSalary(String salary) {
//        this.salary = salary;
//    }
//
//    public String getAge() {
//        return age;
//    }
//
//    public void setAge(String age) {
//        this.age = age;
//    }
//
//    public String getProfilepicture() {
//        return profilepicture;
//    }
//
//    public void setProfilepicture(String profilepicture) {
//        this.profilepicture = profilepicture;
//    }

}
