package com.example.and;

public class Donor {

    private String  Dname;
    private String  Age;
    private  String Bg;
    private String  Uname;
    private String  Add;
    private  String  Email;
    private String  Phno;
    private   String  Pass;

    public Donor() {
    }

    public Donor(String dname, String age, String bg, String uname, String phno) {
        Dname = dname;
        Age = age;
        Bg = bg;
        Uname = uname;
        Phno = phno;
    }

    public String getDname() {
        return Dname;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getBg() {
        return Bg;
    }

    public void setBg(String bg) {
        Bg = bg;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String add) {
        Add = add;
    }

    public  String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhno() {
        return Phno;
    }

    public void setPhno(String phno) {
        Phno = phno;
    }

    public  String getPass() {
        return Pass;
    }

    public  void setPass(String pass) {
        Pass = pass;
    }
}

