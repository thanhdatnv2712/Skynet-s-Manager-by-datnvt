/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author nguye
 */
public class Manager extends JFrame {

    private JFrame frame;
    private JTextField username;
    private JPanel Jpa;
    private JTextField pass;

    public Manager() {
        //init with title
        frame = new JFrame("Manager");
        Jpa = new JPanel();
        Jpa.setBounds(0, 0, 1040, 780);
        //set size
        frame.setSize(1040, 780);
        //exit app and complier
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
    }

    public JFrame getFrame() {
        return frame;
        // TODO code application logic here
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }


    /**
     * @param pass
     */
    public void setPass(JPasswordField pass) {
        this.pass = pass;
    }

    public void addUsername() {
        JLabel user = new JLabel("Name");
        user.setForeground(java.awt.Color.BLACK);
        user.setBounds(230, 300, 80, 32);
        Jpa.add(user);

        username = new JTextField(20);
        username.setBounds(430, 300, 330, 32);
        Jpa.add(username);

        JLabel password = new JLabel("Adress");
        //pass.setFont(newfont);
        password.setForeground(java.awt.Color.BLACK);
        password.setBounds(230, 350, 200, 32);
        Jpa.add(password);

        pass = new JTextField(50);
        pass.setBounds(430, 350, 330, 32);
        Jpa.add(pass);
        Jpa.setVisible(false);
        frame.add(Jpa);
        frame.validate();
        frame.repaint();
    }

    public void RW() {
        JButton JBu = new JButton("Save");
        JBu.setBounds(500, 500, 50, 50);
        JBu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                boolean check = false;
                ArrayList<Account> x = new ArrayList<>();
                x = new AccountRW().read();

                Account ac = new Account(username.getText(), pass.getText(), "0762104404");
                x.forEach(each -> {
                    System.out.println(each.toString());
                });
                for (int i = 0; i < x.size(); i++) {
                    if (x.get(i).equals(ac)) {
                        check = true;
                        break;
                    }
                }
                if (check == false) {
                    JOptionPane.showMessageDialog(null, "Account does not exist...");
                } else {
                    JOptionPane.showMessageDialog(null, "Log-in Successfull");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//     /           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        frame.add(JBu);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Manager x = new Manager();
        x.RW();
        x.addUsername();

    }

}
