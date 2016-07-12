package com.example.intern.intern;

/**
 * Created by Papang on 30/6/2559.
 */

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import org.parceler.Parcel;

import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
@Parcel

public class ContactData {

    boolean isHeader;
    String value;



    @PrimaryKey
    @SerializedName("_id")
    @Expose
    private String _id;


    @SerializedName("th_fname")
    @Expose
    private String fistName_TH;


    @SerializedName("th_lname")
    @Expose
    private String lastName_TH;


    @SerializedName("th_nickname")
    @Expose
    private String nickName_TH;


    @SerializedName("en_fname")
    @Expose
    private String fistName_EN;

    @Required
    @SerializedName("en_lname")
    @Expose
    private String lastName_EN;


    @SerializedName("en_nickname")
    @Expose
    private String nickName_EN;



    @SerializedName("position")
    @Expose
    private String position;


    @SerializedName("email")
    @Expose
    private String email;


    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("workphone")
    @Expose
    private String workphone;



    @SerializedName("line")
    @Expose
    private String line;

    @SerializedName("update")
    @Expose
    private String updateTime;

    public ContactData(String _id, String fistName_TH, String lastName_TH, String nickName_TH, String fistName_EN, String lastName_EN, String nickName_EN, String position, String email, String mobile, String workphone, String line) {
        this._id = _id;
        this.fistName_TH = fistName_TH;
        this.lastName_TH = lastName_TH;
        this.nickName_TH = nickName_TH;
        this.fistName_EN = fistName_EN;
        this.lastName_EN = lastName_EN;
        this.nickName_EN = nickName_EN;
        this.position = position;
        this.email = email;
        this.mobile = mobile;
        this.workphone = workphone;
        this.line = line;

    }

//    public ContactData(String id, String fName, String lName, String nName, String job, String mobile, String workPhone,String email ,String line){
//        set_id(id);
//        setFistName_EN(fName);
//        setLastName_EN(lName);
//        setNickName_EN(nName);
//        setPosition(job);
//        setMobile(mobile);
//        setWorkphone(workPhone);
//        setEmail(email);
//        setLine(line);
//    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

//    public  ContactData(String value, boolean isHeader , String fistName_EN , String nickName_EN , String position) {
//        this.isHeader = isHeader;
//        this.value = value;
////        this.fistName_EN = fistName_EN;
////        this.nickName_EN = nickName_EN;
////        this.position = position;
//        setFistName_EN(fistName_EN);
//        setNickName_EN(nickName_EN);
//        setPosition(position);
//
//    }
    public ContactData(String value, boolean isHeader) {
        this.isHeader = isHeader;
        this.value = value;
        //Log.e("vlue",value);

        //this.fistName_EN = fistName_EN;


    }

    public ContactData() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFistName_TH() {
        return fistName_TH;
    }

    public void setFistName_TH(String fistName_TH) {
        this.fistName_TH = fistName_TH;
    }

    public String getLastName_TH() {
        return lastName_TH;
    }

    public void setLastName_TH(String lastName_TH) {
        this.lastName_TH = lastName_TH;
    }

    public String getNickName_TH() {
        return nickName_TH;
    }

    public void setNickName_TH(String nickName_TH) {
        this.nickName_TH = nickName_TH;
    }

    public String getFistName_EN() {
        return fistName_EN;
    }

    public void setFistName_EN(String fistName_EN) {
        this.fistName_EN = fistName_EN;
    }

    public String getLastName_EN() {
        return lastName_EN;
    }

    public void setLastName_EN(String lastName_EN) {
        this.lastName_EN = lastName_EN;
    }

    public String getNickName_EN() {
        return nickName_EN;
    }

    public void setNickName_EN(String nickName_EN) {
        this.nickName_EN = nickName_EN;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWorkphone() {
        return workphone;
    }

    public void setWorkphone(String workphone) {
        this.workphone = workphone;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }
}
