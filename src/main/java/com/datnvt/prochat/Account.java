/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author nguye
 */
public class Account implements Serializable{
    private String username, pass, SDT;

    public Account() {
        username = "geniusfire99";
        pass = "thanhdatnv2712";
        SDT = "0762104404";
    }

    public Account(String username, String pass, String SDT) {
        this.username = username;
        this.pass = pass;
        this.SDT = SDT;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", pass=" + pass + ", SDT=" + SDT + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.username);
        hash = 53 * hash + Objects.hashCode(this.pass);
        hash = 53 * hash + Objects.hashCode(this.SDT);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.pass, other.pass)) {
            return false;
        }
        if (!Objects.equals(this.SDT, other.SDT)) {
            return false;
        }
        return true;
    }


    
    
}
