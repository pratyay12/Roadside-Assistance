package com.example.roadsideassistant;

public class Refreshments {
    private String refreshmentid;
    private String refreshmentname;
    private  String Refreshmentcity;

    public Refreshments(){

    }

    public Refreshments(String refreshmentid,String refreshmentname, String getRefreshmentcity) {
        this.refreshmentid = refreshmentid;
        this.refreshmentname = refreshmentname;
        this.Refreshmentcity = getRefreshmentcity;
    }

    public String getRefreshmentid() {
        return refreshmentid;
    }

    public void setRefreshmentid(String refreshmentid) {
        this.refreshmentid = refreshmentid;
    }

    public String getRefreshmentname() {
        return refreshmentname;
    }

    public void setRefreshmentname(String refreshmentname) {
        this.refreshmentname = refreshmentname;
    }

    public String getRefreshmentcity() {
        return Refreshmentcity;
    }

    public void setRefreshmentcity(String getRefreshmentcity) {
        this.Refreshmentcity = getRefreshmentcity;
    }

}


