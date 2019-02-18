/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author nguye
 */
public class test {

//          frame = new JFrame("Test");
//        frame.setSize(1200, 720);
//        //       this.setIconImage("icon.png");
//        frame.setLocationRelativeTo(null);//dua ra giua man hinh
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//dong 
////        frame.setVisible(true);//cho hien thi   
//        //lấy đối tượng FirebaseDatabase
//
//        // lien ket toi firebase
//        FileInputStream serviceAccount;
//        try {
//            serviceAccount = new FileInputStream("prochat-19242-firebase-adminsdk-70bx8-be2c5f0b31.json");
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("https://prochat-19242.firebaseio.com")
//                    .build();
//
//            FirebaseApp.initializeApp(options);
//        } catch (FileNotFoundException ex) {
////            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
////            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        //ghi toi firebas
//        DatabaseReference myRef01 = FirebaseDatabase.getInstance().getReference("Person");
//        myRef01.child("Person3").setValueAsync(new Person());
//
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
////Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
//        DatabaseReference myRef = database.getReference("Person");
//        ArrayList<Person> s = new ArrayList<>();
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot ds) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                s.clear();
//                for (DataSnapshot data : ds.getChildren()) {
////                    String key = data.getKey();
////                    String value = data.getValue().toString();
////                    s.add(key + "\n" + value);
//                    Person tmp = data.getValue(Person.class);
//                    s.add(tmp);
//                }
//                s.forEach(each -> {
//                    System.out.println(each);
//                });
//            }
//
//            @Override
//            public void onCancelled(DatabaseError de) {
//                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//    }  
//    public void Register() {
//
//        JLabel mail = new JLabel("Mail");
//        mail.setForeground(java.awt.Color.RED);
//        mail.setBounds(250, 300, 50, 50);
//        Jpa.add(mail);
//        JTextField mailText = new JTextField(20);
//        mailText.setBounds(430, 300, 50, 50);
//        Jpa.add(mailText);
//
//        JLabel pass = new JLabel("Password");
//        pass.setForeground(java.awt.Color.RED);
//        pass.setBounds(250, 500, 50, 50);
//        Jpa.add(pass);
//        JPasswordField passText = new JPasswordField(50);
//        passText.setBounds(680, 500, 50, 50);
//        Jpa.add(passText);
//
//        JButton Register = new JButton("Sign-in");
//        Register.setBounds(500, 500, 60, 60);
//        ConnectFB();
//        Register.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
////                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                String user = mailText.getText();
//                String pass = passText.getText();
//                ArrayList<Account> users = new ArrayList<>();
////                users.add(new Account("datdeptrai", "dat123"));
//
//                //        //ghi toi firebas
////                DatabaseReference myRef01 = FirebaseDatabase.getInstance().getReference("Register");
////                myRef01.child("User2").setValueAsync(new Account(user, pass));
//                //doc file
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//////Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
//                DatabaseReference myRef = database.getReference("Register");
//                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot ds) {
//                        users.clear();
////                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                        for (DataSnapshot data : ds.getChildren()) {
//                            Account x = data.getValue(Account.class);
//                            users.add(x);
//                        }
//                        users.forEach(each -> {
//                            System.out.println(each.toString());
//                        });
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError de) {
////                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                    }
//                });
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
////                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
////                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
////                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
////                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        Jpa.add(Register);
//    }
}
