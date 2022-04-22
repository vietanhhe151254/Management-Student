package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private String id;
    private String fistname;
    private String lastname;
    private String phone;
    private String address;
    private Date dob;
    private String sex;

    public Student() {
    }

    public Student(String id, String fistname, String lastname, String phone, String address, Date dob, String sex) {
        this.id = id;
        this.fistname = fistname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
    }
    public String fullName(){
        String fullname = fistname +" "+lastname;
        String splitName[]= fullname.split("//s+");
        String results ="";
        for (String str: splitName) {
            String st = str.substring(0,1).toUpperCase();
            results += st+str.substring(1)+"";
        }
        return results;
    }
    public String formatDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        return df.format(dob);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fistname='" + fistname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + formatDate() +
                ", sex='" + sex + '\'' +
                '}';
    }
}
