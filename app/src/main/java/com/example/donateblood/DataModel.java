package com.example.donateblood;

public class DataModel {

    String id, email, pass, name, age, phone, address, lastdate, bloodgroup;



    public DataModel(String id, String email, String pass, String name, String age, String bloodgroup, String phone, String address, String lastdate) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.age = age;
        this.bloodgroup = bloodgroup;
        this.phone = phone;
        this.address = address;
        this.lastdate = lastdate;
    }

    public DataModel(){

    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }
}
