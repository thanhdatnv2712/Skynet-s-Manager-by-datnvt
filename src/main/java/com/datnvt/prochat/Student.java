/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

import java.io.Serializable;

/**
 *
 * @author nguye
 */
public class Student extends Person implements Serializable{//imple read and write object 
    private String classes, ID;
    private int session;

    public Student(String classes, String ID, int session, String name, String address, String SDT, String email) {
        super(name, address, SDT, email);
        this.classes = classes;
        this.ID = ID;
        this.session = session;
    }
    
    public Student(){
        super();
        this.classes = "D17CQCN09-B";
        this.ID = "B17DCCN117";
        this.session = 4;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return super.toString() + "\nStudent{" + "classes=" + classes + ", ID=" + ID + ", session=" + session + '}';
    }
    
    public static void main(String[] args) {
        System.out.println(new Student().toString());
    }
    
}
