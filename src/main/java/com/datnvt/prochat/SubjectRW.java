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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguye
 */
public class SubjectRW {

    private static final String STUDENT_FILE_NAME = "SubjectList.txt";

    //save list student to file with object
    public void write(ArrayList<Subject> SubList) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
            ObjectOutputStream fo = new ObjectOutputStream(fos);
            fo.writeObject(SubList);
            fo.close();
            fos.close();
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(StudentRW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//            Logger.getLogger(StudentRW.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Subject> read() {
        ArrayList<Subject> ans = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(STUDENT_FILE_NAME));
            ObjectInputStream fi = new ObjectInputStream(fis);
            ans = (ArrayList<Subject>) fi.readObject();
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
        ArrayList<Subject> gg = new SubjectRW().read();
        System.out.println(gg);
        
    }
}
