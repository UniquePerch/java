package com.vol.JDBC.entity;

public class User {
    private String name;
    private String number;
    private String tel;
    private int volnum;
    private String QQ;

    public User(String name, String number, String tel, int volnum, String QQ) {
        this.name = name;
        this.number = number;
        this.tel = tel;
        this.volnum = volnum;
        this.QQ = QQ;
    }

    public User(String name, String number, String tel, String QQ) {
        this.name = name;
        this.number = number;
        this.tel = tel;
        this.QQ = QQ;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getVolnum() {
        return volnum;
    }

    public void setVolnum(int volnum) {
        this.volnum = volnum;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }
}
