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
public class AccountRW {
    private static final String ACCOUNT_FILE_NAME = "Users.txt";
    
    public void write(ArrayList<Account> user){
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(new File(ACCOUNT_FILE_NAME));
            ObjectOutputStream fo = new ObjectOutputStream(fos);
            fo.writeObject(user);
            fo.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(AccountRW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(AccountRW.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public ArrayList<Account> read(){
        ArrayList<Account> ans = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(ACCOUNT_FILE_NAME));
            ObjectInputStream fi = new ObjectInputStream(fis);
            ans = (ArrayList<Account>) fi.readObject();
            fi.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(AccountRW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(AccountRW.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(AccountRW.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ans;
    }
}
