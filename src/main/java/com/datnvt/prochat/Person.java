/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

/**
 *
 * @author nguye
 */
public class Person {

    private String name, address, SDT, mail;

    public Person(String name, String address, String SDT, String mail) {
        this.name = name;
        this.address = address;
        this.SDT = SDT;
        this.mail = mail;
    }

    public Person() {
//        this.name = "Nguyễn Viết Thành Đạt";
//        this.address = "La Phù, Hoài Đức, Hà Nội";
//        this.SDT = "0762104404";
//        this.mail = "nguyenvietthanhdat2712@gmail.com";
        this.name = "Nguyen Viet Thanh Dat";
        this.address = "La Phu, Hoai Duc, Ha Noi";
        this.SDT = "0762104404";
        this.mail = "nguyenvietthanhdat2712@gmail.com";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", address=" + address + ", SDT=" + SDT + ", mail=" + mail + '}';
    }

    public static void main(String[] args) {
        System.out.println("dat");
        System.out.println(new Person());
    }

}
