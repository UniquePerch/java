package com.vol.JDBC.entity;

public class Volunt {
    private int No;
    private String name;
    private String work;
    private String lacation;
    private String Time;
    private String benefits;
    private String etc;
    private int maxpeo;
    private int nowpeo;

    public Volunt(String name, String work, String lacation, String time, String benefits, String etc, int maxpeo) {
        this.name = name;
        this.work = work;
        this.lacation = lacation;
        Time = time;
        this.benefits = benefits;
        this.etc = etc;
        this.maxpeo = maxpeo;
    }

    public Volunt(int no, String name, String time) {
        No = no;
        this.name = name;
        Time = time;
    }

    public Volunt(int no, String name, String work, String lacation, String time, String benefits, String etc, int maxpeo, int nowpeo) {
        No = no;
        this.name = name;
        this.work = work;
        this.lacation = lacation;
        Time = time;
        this.benefits = benefits;
        this.etc = etc;
        this.maxpeo = maxpeo;
        this.nowpeo = nowpeo;
    }

    public Volunt(int no, String name, String lacation, String time, int maxpeo, int nowpeo) {
        No = no;
        this.name = name;
        this.lacation = lacation;
        Time = time;
        this.maxpeo = maxpeo;
        this.nowpeo = nowpeo;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public int getNowpeo() {
        return nowpeo;
    }

    public void setNowpeo(int nowpeo) {
        this.nowpeo = nowpeo;
    }

    public Volunt() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getLacation() {
        return lacation;
    }

    public void setLacation(String lacation) {
        this.lacation = lacation;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public int getMaxpeo() {
        return maxpeo;
    }

    public void setMaxpeo(int maxpeo) {
        this.maxpeo = maxpeo;
    }
}
