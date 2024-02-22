package com.kok.Modal;
public class employee {
    int id,posts_id;
    String name,dob,city,state,country,mobilenumber,joined_date,relived_date,address;
    public void setid(int id){this.id = id;}
    public void setname(String name){this.name = name;}
    public void setdob(String dob){this.dob = dob;}
    public void setcity(String city){this.city = city;}
    public void setstate(String state){this.state = state;}
    public void setcountry(String country){this.country = country;}
    public void setmobilenumber(String mobilenumber){this.mobilenumber=mobilenumber;}
    public void setjoineddate(String joined_date){this.joined_date = joined_date;}
    public void setrelieveddate(String relived_date){this.relived_date = relived_date;}
    public void setaddress(String address){this.address = address;}
    public void setpostid(String postsid){
        String p_id = postsid;
        if(p_id.equalsIgnoreCase("M")){
        this.posts_id= 3;}
        else if(p_id.equalsIgnoreCase("S")){
        this.posts_id= 2;}
        else if(p_id.equalsIgnoreCase("E")){
            this.posts_id= 1;}
        else {
            this.posts_id=1;}
    }
    public int getid(){return this.id;};
    public String getname(){return this.name;}
    public String getdob(){return this.dob;}
    public String getstate(){return this.state;}
    public String getcountry(){return this.country;}
    public String getcity(){return this.city;}
    public String getMobileNumber(){return mobilenumber;}
    public String getjoinedddate(){return this.joined_date;}
    public String getrelieveddate(){return this.relived_date;}
    public String getAddress() {return this.address;}
    public int getpostid(){return this.posts_id;}
}