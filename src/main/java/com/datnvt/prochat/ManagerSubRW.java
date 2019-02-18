/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class ManagerSubRW {

    private static final String MS_FILE_NAME = "ManagerSub.txt";

    //save list student to file with object
    public void write(ArrayList<ManagerSub> StuList) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(MS_FILE_NAME));
            ObjectOutputStream fo = new ObjectOutputStream(fos);
            fo.writeObject(StuList);
            fo.close();
            fos.close();
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(StudentRW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//            Logger.getLogger(StudentRW.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<ManagerSub> read() {
        ArrayList<ManagerSub> ans = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(MS_FILE_NAME));
            ObjectInputStream fi = new ObjectInputStream(fis);
            ans = (ArrayList<ManagerSub>) fi.readObject();
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(StudentRW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//            Logger.getLogger(StudentRW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(StudentRW.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ans;
    }

    public static void main(String[] args) {
        ManagerSubRW x = new ManagerSubRW();
        ArrayList<ManagerSub> gg = new ArrayList<>();
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        gg.add(new ManagerSub(new Student()));
        x.write(gg);

        ArrayList<ManagerSub> xx = new ArrayList<ManagerSub>();
        xx = x.read();
        System.out.println(xx);
//        System.out.println(gg);
    }
}
