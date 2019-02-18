/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nguye
 */
public class ConnectFireBase extends JFrame {

    private JPanel Jpa;
    private JFrame frame;
    private Font newfont;
    private JPanel Login;
    private JPanel gJpa;
    private ArrayList<Account> AcList;
    private ArrayList<ManagerSub> subList;
    private ArrayList<Student> stuList;
    private ArrayList<Subject> subAll;
    private String username;
    private ArrayList<String> key;
    private int pre = 0;

    public ConnectFireBase() {
        frame = new JFrame("Skynet Manager");
        frame.setSize(1540, 1000);
        frame.setLayout(null);
        this.setIconBar();
        Jpa = new JPanel();
        Login = new JPanel();
        gJpa = new JPanel();
        Login.setBounds(0, 0, 1540, 1000);
        Login.setLayout(null);
        gJpa.setBounds(0, 0, 1540, 1000);
        gJpa.setLayout(null);
        newfont = new Font("vision", Font.ITALIC, 25);
        Jpa.setBounds(0, 0, 1540, 1000);
        Jpa.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        AcList = new ArrayList<>();
        AcList = GetAccount();
        subList = new ArrayList<>();
        stuList = new ArrayList<>();
        subAll = new ArrayList<>();
        key = new ArrayList<>();
        username = "";
        this.signin("Log.png");
        frame.setVisible(true);
        frame.validate();
        frame.repaint();
    }

    public void setIconBar() {
        Image icon = Toolkit.getDefaultToolkit().getImage("icons.png");
        frame.setIconImage(icon);
    }

    public void ConnectFB() {
        //         lien ket toi firebase
        FileInputStream serviceAccount;
        try {
            serviceAccount = new FileInputStream("prochat-19242-firebase-adminsdk-70bx8-be2c5f0b31.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://prochat-19242.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (FileNotFoundException ex) {
//                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
//                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Account> GetAccount() {
        ConnectFB();
        ArrayList<Account> ans = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Register");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                ans.clear();
                for (DataSnapshot data : ds.getChildren()) {
                    Account add = data.getValue(Account.class);
                    ans.add(add);
                }
            }

            @Override
            public void onCancelled(DatabaseError de) {
                System.out.println("Skynet Eror...");
            }
        });
        return ans;
    }

    public ArrayList<ManagerSub> getManagerFireBase() {
//        ConnectFB();
        ArrayList<ManagerSub> ans = new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String path = "ManagerSub/" + username;
        DatabaseReference myRef = database.getReference(path);
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                ans.clear();
                for (DataSnapshot data : ds.getChildren()) {
                    ManagerSub add = data.getValue(ManagerSub.class);
                    key.add(data.getKey());
                    System.out.println(data.getKey());
                    ans.add(add);
                }
            }

            @Override
            public void onCancelled(DatabaseError de) {
                System.out.println("Skynet Eror...");
            }
        });
        return ans;
    }

    public void WriteAccount(String path, String user, String pass) {
//        ConnectFB();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(path);
        myRef.push().setValueAsync(new Account(user, pass, "0762104404"));
//        int dem = 4;
//        myRef.child("dat123").child("User").child("subList").child("" + dem).setValueAsync(new Subject("ELE1330", "Xu ly tin hieu so", 4, 2, 0, 0, 0, 0));
//        dem++;
//        myRef.child("dat123").child("User").child("subList").child("" + dem).setValueAsync(new Subject("INT1306", "Cau truc du lieu giai thuat", 4, 3, 0, 0, 0, 0));
//        dem++;
//        myRef.child("dat123").child("User").child("subList").child("" + dem).setValueAsync(new Subject("INT1323", "Kien truc may tinh", 4, 2, 0, 0, 0, 0));
//        dem++;
//        myRef.child("dat123").child("User").child("subList").child("" + dem).setValueAsync(new Subject("INT1359", "Toan roi rac 2", 4, 3, 0, 0, 0, 0));
//        dem++;
//        myRef.child("dat123").child("User").child("subList").child("" + dem).setValueAsync(new Subject("SKD1103", "Ky nang tao lap van ban", 4, 1, 0, 0, 0, 0));
    }

    public void WriteManager(ManagerSub x) {
        String path = "ManagerSub/" + username;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(path);
        myRef.push().setValueAsync(x);
        key.clear();
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot ds) {
                for (DataSnapshot data : ds.getChildren()) {
                    key.add(data.getKey());
                }
            }

            @Override
            public void onCancelled(DatabaseError de) {
                System.out.println("Skynet Eror...");
            }
        });
    }

    public void editManager(ManagerSub x, int id) {
        String path = "ManagerSub/" + username;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        //Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
        DatabaseReference myRef = database.getReference(path);
        myRef.child(key.get(id)).child("person").setValue(x.getPerson(), null);
        myRef.child(key.get(id)).child("subList").setValue(x.getSubList(), null);
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void signin(String path) {
        //set background
        frame.add(Login);
        Login.setVisible(true);
        ImageIcon img = new ImageIcon(path);
        JLabel Jla = new JLabel("", img, JLabel.CENTER);
        Jla.setLayout(null);
        Jla.setBounds(0, 0, 1540, 1000);
        Login.add(Jla);
        //set mail
        JLabel mail = new JLabel("Account");
        mail.setFont(newfont);
        mail.setForeground(Color.white);
        mail.setBounds(1000, 400, 150, 32);
        Jla.add(mail);
        JTextField mailText = new JTextField(50);
        mailText.setBounds(1175, 400, 275, 32);
        mailText.setFont(new Font("gg", Font.PLAIN, 18));
        Jla.add(mailText);
        //set pass
        JLabel pass = new JLabel("Password");
        pass.setFont(newfont);
        pass.setForeground(Color.white);
        pass.setBounds(1000, 450, 150, 32);
        Jla.add(pass);
        JPasswordField passText = new JPasswordField(50);
        passText.setBounds(1175, 450, 275, 32);
        passText.setFont(new Font("gg", Font.PLAIN, 18));
        Jla.add(passText);
        //set button sign in
        JButton log = new JButton("Log-in");
        log.setFont(new Font("sinin", Font.ITALIC, 16));
        log.setBounds(1175, 500, 90, 60);
        log.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String usern = mailText.getText();
                String pass1 = passText.getText();
                Account User = new Account(usern, pass1, "0762104404");
                boolean check = false;
                for (int i = 0; i < AcList.size(); i++) {
                    if (User.equals(AcList.get(i))) {
                        check = true;
                        setUsername(usern);
                        subList = getManagerFireBase();
                        break;
                    }
                }
                if (check == true) {
                    JOptionPane.showMessageDialog(frame, "Log-in Successful!");
                    Login.setVisible(false);
                    createMenuBar("bg.jpg");
                } else {
                    JOptionPane.showMessageDialog(frame, "Account does not exist...");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        Jla.add(log);
        JButton register = new JButton("Click here!");
        register.setFont(new Font("sinin", Font.ITALIC, 13));
        register.setBounds(1280, 600, 100, 20);
        register.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Login.setVisible(false);
                register("sign.png");
//                Jpa.setVisible(true);
//                frame.add(Jpa);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        Jla.add(register);
        JLabel text = new JLabel("If you don't have a account.");
        text.setFont(new Font("rigister", Font.ITALIC, 13));
        text.setForeground(Color.LIGHT_GRAY);
        text.setBounds(1100, 600, 200, 13);
        Jla.add(text);

    }

    public void register(String path) {
        //set background
        frame.add(Jpa);
        ImageIcon img = new ImageIcon(path);
        JLabel Jla = new JLabel("", img, JLabel.CENTER);
        Jla.setLayout(null);
        Jla.setBounds(0, 0, 1540, 1000);
        Jpa.add(Jla);
        //set mail
        JLabel mail = new JLabel("Account");
        mail.setFont(newfont);
        mail.setForeground(Color.white);
        mail.setBounds(1000, 400, 150, 32);
        Jla.add(mail);
        JTextField mailText = new JTextField(50);
        mailText.setBounds(1175, 400, 275, 32);
        mailText.setFont(new Font("gg", Font.PLAIN, 18));
        Jla.add(mailText);
        //set phone
        JLabel phone = new JLabel("Phone");
        phone.setFont(newfont);
        phone.setForeground(Color.white);
        phone.setBounds(1000, 450, 150, 32);
        Jla.add(phone);
        JTextField phoneText = new JTextField(50);
        phoneText.setBounds(1175, 450, 275, 32);
        phoneText.setFont(new Font("gg", Font.PLAIN, 18));
        Jla.add(phoneText);
        //set pass
        JLabel pass = new JLabel("Password");
        pass.setFont(newfont);
        pass.setForeground(Color.white);
        pass.setBounds(1000, 500, 150, 32);
        Jla.add(pass);
        JPasswordField passText = new JPasswordField(50);
        passText.setBounds(1175, 500, 275, 32);
        passText.setFont(new Font("gg", Font.PLAIN, 18));
        Jla.add(passText);
        //set re enter pass
        JLabel rpass = new JLabel("RPassword");
        rpass.setFont(newfont);
        rpass.setForeground(Color.white);
        rpass.setBounds(1000, 550, 150, 32);
        Jla.add(rpass);
        JPasswordField rpassText = new JPasswordField(50);
        rpassText.setBounds(1175, 550, 275, 32);
        rpassText.setFont(new Font("gg", Font.PLAIN, 18));
        Jla.add(rpassText);
        //set button sign in
        JButton sign = new JButton("Sign-up");
        sign.setFont(new Font("sinin", Font.ITALIC, 16));
        sign.setBounds(1175, 600, 90, 60);
        sign.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String pass1 = passText.getText();
                String pass2 = rpassText.getText();

                if (pass1.compareTo(pass2) == 0) {

                    String username = mailText.getText();
                    Account newUser = new Account(username, pass1, "0762104404");
                    boolean check = false;
                    for (int i = 0; i < AcList.size(); i++) {
                        if (newUser.equals(AcList.get(i))) {
                            JOptionPane.showMessageDialog(frame, "Account already exist...");
                            check = true;
                            break;
                        }
                    }
                    if (check == false) {
                        JOptionPane.showMessageDialog(frame, "Register Successful!");
                        WriteAccount("Register", username, pass1);
                        AcList.add(newUser);
                        Jpa.setVisible(false);
                        Login.setVisible(true);
                        signin("Log.png");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Password mismatched...");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        Jla.add(sign);

    }

    public void createMenuBar(String path) {
        frame.add(gJpa);
        ImageIcon img = new ImageIcon(path);
        JLabel Jla = new JLabel("", img, JLabel.CENTER);
        Jla.setLayout(null);
        Jla.setBounds(0, 0, 1540, 1000);
        gJpa.add(Jla);
        //set menubar
        JMenuBar menuBar = null;

        JMenu menuFile;
        JMenu menuHelp;

        JMenuItem itemFileStudent;
        JMenuItem itemFileSubject;
        JMenuItem itemHelpAbout;
        Jla.setLayout(new BorderLayout());
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuHelp = new JMenu("Help");
        //phim tat
        menuFile.setMnemonic(KeyEvent.VK_F);
        menuHelp.setMnemonic(KeyEvent.VK_O);
        //phim tat item
        itemFileStudent = new JMenuItem("New Student");
        itemFileStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itemFileSubject = new JMenuItem("New Subject");
        itemFileSubject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        itemHelpAbout = new JMenuItem("About Author");
        itemHelpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        //add
        Jla.add(menuBar, BorderLayout.NORTH);
        //add menu
        menuBar.add(menuFile);
        menuBar.add(menuHelp);
        //add item
        menuFile.add(itemFileStudent);
        menuFile.add(itemFileSubject);
        menuHelp.add(itemHelpAbout);

        itemFileStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = JOptionPane.showInputDialog(frame, "Enter ID", "Add new Student", JOptionPane.QUESTION_MESSAGE);
                String classes = JOptionPane.showInputDialog(frame, "Enter Class", "Add new Student", JOptionPane.QUESTION_MESSAGE);
                String session = JOptionPane.showInputDialog(frame, "Enter Session", "Add new Student", JOptionPane.QUESTION_MESSAGE);
                String name = JOptionPane.showInputDialog(frame, "Enter Name", "Add new Student", JOptionPane.QUESTION_MESSAGE);
                String address = JOptionPane.showInputDialog(frame, "Enter Adress", "Add new Student", JOptionPane.QUESTION_MESSAGE);
                String SDT = JOptionPane.showInputDialog(frame, "Enter SDT", "Add new Student", JOptionPane.QUESTION_MESSAGE);
                String mail = JOptionPane.showInputDialog(frame, "Enter Mail", "Add new Student", JOptionPane.QUESTION_MESSAGE);
                Student add = new Student(classes, ID, Integer.valueOf(session), name, address, SDT, mail);
            }
        });

        itemFileSubject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = JOptionPane.showInputDialog(frame, "Enter ID", "Add new Subject", JOptionPane.QUESTION_MESSAGE);
                String Name = JOptionPane.showInputDialog(frame, "Enter Name", "Add new Subject", JOptionPane.QUESTION_MESSAGE);
                String Session = JOptionPane.showInputDialog(frame, "Enter Session", "Add new Subject", JOptionPane.QUESTION_MESSAGE);
                String stin = JOptionPane.showInputDialog(frame, "Enter Credit", "Add new Subject", JOptionPane.QUESTION_MESSAGE);
                ArrayList<Subject> subxList = new SubjectRW().read();
                subxList.add(new Subject(ID, Name, Integer.valueOf(Session), Integer.valueOf(stin), 0, 0, 0, 0));
                new SubjectRW().write(subxList);
            }
        });

        itemHelpAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Author: Nguyen Viet Thanh Dat\nDate of Birth: 27/12/1999\nAdress: La Phu, Hoai Duc, Ha noi\nCLB: ProPTIT");
            }
        });

        JLabel addx = new JLabel();
        Jla.add(addx);

        subList.forEach(each -> {
            stuList.add(each.getPerson());
        });
//        Jla.setVisible(false);
        addx.setBounds(0, 0, 1540, 500);
        JLabel ID = new JLabel("ID");
        ID.setFont(newfont);
        ID.setBounds(150, 150, 150, 25);
//        ID.setForeground(Color.red);
        addx.add(ID);
        JTextField idText = new JTextField(50);
        idText.setBounds(300, 150, 150, 30);
        idText.setFont(new Font("gg", Font.PLAIN, 18));
        addx.add(idText);

        JLabel name = new JLabel("Name");
        name.setFont(newfont);
        name.setBounds(600, 150, 150, 25);
        addx.add(name);
        JTextField nameText = new JTextField(50);
        nameText.setBounds(750, 150, 350, 30);
        nameText.setFont(new Font("gg", Font.PLAIN, 18));
        addx.add(nameText);

        JLabel classes = new JLabel("Class");
        classes.setFont(newfont);
        classes.setBounds(150, 200, 150, 25);
        addx.add(classes);
        JTextField classText = new JTextField(50);
        classText.setBounds(300, 200, 150, 30);
        classText.setFont(new Font("gg", Font.PLAIN, 18));
        addx.add(classText);

        JLabel add = new JLabel("Adress");
        add.setFont(newfont);
        add.setBounds(600, 200, 150, 25);
        addx.add(add);
        JTextField addText = new JTextField(50);
        addText.setBounds(750, 200, 350, 30);
        addText.setFont(new Font("gg", Font.PLAIN, 18));
        addx.add(addText);

        JLabel Session = new JLabel("Session");
        Session.setFont(newfont);
        Session.setBounds(150, 250, 150, 25);
        addx.add(Session);
        JTextField SessionText = new JTextField(50);
        SessionText.setBounds(300, 250, 150, 30);
        SessionText.setFont(new Font("gg", Font.PLAIN, 18));
        addx.add(SessionText);

        JLabel a = new JLabel("Mail");
        a.setFont(newfont);
        a.setBounds(150, 300, 150, 25);
        addx.add(a);
        JTextField aText = new JTextField(50);
        aText.setBounds(300, 300, 450, 30);
        aText.setFont(new Font("gg", Font.PLAIN, 18));
        addx.add(aText);

        JLabel m = new JLabel("Phone");
        m.setFont(newfont);
        m.setBounds(600, 250, 150, 25);
        addx.add(m);
        JTextField mText = new JTextField(50);
        mText.setBounds(750, 250, 350, 30);
        mText.setFont(new Font("gg", Font.PLAIN, 18));
        addx.add(mText);

        Icon addIcon = new ImageIcon("add.png");
        JButton addnew = new JButton(addIcon);
        addnew.setBounds(500, 450, 50, 50);
        addx.add(addnew);

        Icon clearIcon = new ImageIcon("clear.png");
        JButton clear = new JButton(clearIcon);
        clear.setBounds(600, 450, 50, 50);
        clear.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                idText.setText("");
                nameText.setText("");
                classText.setText("");
                SessionText.setText("");
                addText.setText("");
                mText.setText("");
                aText.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        addx.add(clear);

        Icon editIcon = new ImageIcon("edit.png");
        JButton edit = new JButton(editIcon);
        edit.setBounds(700, 450, 50, 50);
        addx.add(edit);

        Icon deIcon = new ImageIcon("delete.png");
        JButton delete = new JButton(deIcon);
        delete.setBounds(800, 450, 50, 50);
        addx.add(delete);

        Icon exitIcon = new ImageIcon("logout.png");
        JButton exit = new JButton(exitIcon);
        exit.setBounds(900, 450, 50, 50);
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                gJpa.setVisible(false);
                Login.setVisible(true);
                JOptionPane.showMessageDialog(null, "<GoodBye! See you again/>");
                signin("Log.png");
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        addx.add(exit);
        JLabel nsub = new JLabel();
        nsub.setLayout(new BorderLayout());
        JTable table = new JTable();
        showTable(table);

        JScrollPane pane = new JScrollPane();
        pane.setViewportView(table);
//        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        Jla.add(pane, BorderLayout.SOUTH);
        JLabel cen = new JLabel();
        nsub.add(cen);
        cen.setBounds(0, 50, 1540, 300);
        JLabel sID = new JLabel("ID");
        sID.setFont(newfont);
        sID.setBounds(100, 70, 150, 25);
//        ID.setForeground(Color.red);
        cen.add(sID);
        JTextField sidText = new JTextField(50);
        sidText.setBounds(200, 70, 150, 30);
        sidText.setFont(new Font("gg", Font.PLAIN, 18));
        cen.add(sidText);

        JLabel sname = new JLabel("Subject");
        sname.setFont(newfont);
        sname.setBounds(500, 70, 150, 25);
        cen.add(sname);
        JTextField snameText = new JTextField(50);
        snameText.setBounds(600, 70, 450, 30);
        snameText.setFont(new Font("gg", Font.PLAIN, 18));
        cen.add(snameText);

        JLabel session = new JLabel("Session");
        session.setFont(newfont);
        session.setBounds(1100, 70, 150, 25);
        cen.add(session);
        JTextField sessionText = new JTextField(50);
        sessionText.setBounds(1200, 70, 50, 30);
        sessionText.setFont(new Font("gg", Font.PLAIN, 18));
        cen.add(sessionText);

        JLabel cre = new JLabel("Credits");
        cre.setFont(newfont);
        cre.setBounds(1300, 70, 150, 25);
        cen.add(cre);
        JTextField creText = new JTextField(50);
        creText.setBounds(1400, 70, 50, 30);
        creText.setFont(new Font("gg", Font.PLAIN, 18));
        cen.add(creText);

        JLabel ccan = new JLabel("Diligence");
        ccan.setFont(newfont);
        ccan.setBounds(100, 150, 150, 25);
        cen.add(ccan);
        JTextField ccanText = new JTextField(50);
        ccanText.setBounds(300, 150, 50, 30);
        ccanText.setFont(new Font("gg", Font.PLAIN, 18));
        cen.add(ccanText);

        JLabel mid = new JLabel("Middle");
        mid.setFont(newfont);
        mid.setBounds(450, 150, 150, 25);
        cen.add(mid);
        JTextField midText = new JTextField(50);
        midText.setBounds(550, 150, 50, 30);
        midText.setFont(new Font("gg", Font.PLAIN, 18));
        cen.add(midText);

        JLabel f = new JLabel("Final");
        f.setFont(newfont);
        f.setBounds(650, 150, 150, 25);
        cen.add(f);
        JTextField fText = new JTextField(50);
        fText.setBounds(750, 150, 50, 30);
        fText.setFont(new Font("gg", Font.PLAIN, 18));
        cen.add(fText);

        JLabel r = new JLabel("Result");
        r.setFont(newfont);
        r.setBounds(850, 150, 150, 25);
        cen.add(r);
        JTextField rText = new JTextField(50);
        rText.setBounds(950, 150, 50, 30);
        rText.setFont(new Font("gg", Font.PLAIN, 18));
        cen.add(rText);

        JLabel rank = new JLabel("Rank");
        rank.setFont(newfont);
        rank.setBounds(1050, 150, 150, 25);
        cen.add(rank);
        JTextField rankText = new JTextField(50);
        rankText.setBounds(1150, 150, 50, 30);
        rankText.setFont(new Font("gg", Font.PLAIN, 18));
        cen.add(rankText);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] ob = {"Information", "Grades of subjects"};
                int x = JOptionPane.showOptionDialog(null, "Your choice?", "Don't forget tick it!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[0]);
                if (x == 0) {
                    nsub.setVisible(false);
                    addx.setVisible(true);
                    if (table.getSelectedRow() != -1) {
                        int row = table.getSelectedRow();
                        idText.setText(stuList.get(row).getID());
                        nameText.setText(stuList.get(row).getName());
                        classText.setText(stuList.get(row).getClasses());
                        SessionText.setText(String.valueOf(stuList.get(row).getSession()));
                        addText.setText(stuList.get(row).getAddress());
                        mText.setText(stuList.get(row).getSDT());
                        aText.setText(stuList.get(row).getMail());
                    }
                } else {
                    addx.setVisible(false);
                    nsub.setVisible(true);
                    int row = table.getSelectedRow();
                    Jla.add(nsub);
                    subAll = subList.get(row).getSubList();
                    JTable subTable = new JTable();
//                    showSubTable(subTable, pre, nsub, subList);
                    showSubTable(subTable, row, nsub, subList);
                    subTable.setRowHeight(27);
                    subTable.setFont(new Font("table", Font.PLAIN, 20));
                    JScrollPane spane = new JScrollPane();
                    spane.setViewportView(subTable);
                    spane.setPreferredSize(new Dimension(1540, 250));
//        table.setPreferredScrollableViewportSize(table.getPreferredSize());
                    subTable.setFillsViewportHeight(true);
                    nsub.add(spane, BorderLayout.SOUTH);
                    subTable.validate();
                    subTable.repaint();
                    subTable.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int srow = subTable.getSelectedRow();
                            Subject esub = subList.get(row).getSubList().get(srow);
                            sidText.setText(esub.getID());
                            snameText.setText(esub.getName());
                            sessionText.setText(String.valueOf(esub.getSession()));
                            creText.setText(String.valueOf(esub.getStin()));
                            ccanText.setText(String.valueOf(esub.getCcan()));
                            midText.setText(String.valueOf(esub.getMiddle()));
                            fText.setText(String.valueOf(esub.getFinaltest()));
                            rText.setText(String.valueOf(esub.getDtb()));
                            rankText.setText(String.valueOf(esub.getRank()));
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                        }
                    });

                    Icon addIcon = new ImageIcon("addsub.png");
                    JButton addnew = new JButton(addIcon);
                    addnew.setBounds(300, 200, 50, 50);
                    addnew.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            String tmp = JOptionPane.showInputDialog(null, "Enter ID?", JOptionPane.QUESTION_MESSAGE);
                            ArrayList<Subject> con = new SubjectRW().read();
                            boolean check = false;
                            for (int i = 0; i < con.size(); i++) {
                                if (con.get(i).getID().compareTo(tmp) == 0) {
                                    subAll.add(con.get(i));
                                    subList.get(row).setSubList(subAll);
                                    editManager(subList.get(row), row);
                                    check = true;
                                    break;
                                }
                            }
                            if (check == false) {
                                JOptionPane.showMessageDialog(null, "Subject does not exist...");
                            } else {
                                JOptionPane.showMessageDialog(null, "Add new Subject Successful!");
                            }
                            showSubTable(subTable, row, nsub, subList);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                    cen.add(addnew);

                    Icon clearIcon = new ImageIcon("clear.png");
                    JButton clear = new JButton(clearIcon);
                    clear.setBounds(400, 200, 50, 50);
                    clear.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            sidText.setText("");
                            snameText.setText("");
                            sessionText.setText("");
                            creText.setText("");
                            ccanText.setText("");
                            midText.setText("");
                            fText.setText("");
                            rText.setText("");
                            rankText.setText("");
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                    cen.add(clear);

                    Icon editIcon = new ImageIcon("edit.png");
                    JButton edit = new JButton(editIcon);
                    edit.setBounds(500, 200, 50, 50);
                    edit.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int srow = subTable.getSelectedRow();
                            subAll.get(srow).setID(sidText.getText());
                            subAll.get(srow).setName(snameText.getText());
                            subAll.get(srow).setSession(Integer.valueOf(sessionText.getText()));
                            subAll.get(srow).setStin(Integer.valueOf(creText.getText()));
                            subAll.get(srow).setMiddle(Float.valueOf(midText.getText()));
                            subAll.get(srow).setFinaltest(Float.valueOf(fText.getText()));
                            subAll.get(srow).setCcan(Float.valueOf(ccanText.getText()));
                            subAll.get(srow).EditDtb();
                            subAll.get(srow).setDtb(subAll.get(srow).getDtb());
                            subList.get(row).setSubList(subAll);
                            showSubTable(subTable, row, nsub, subList);
                            editManager(subList.get(row), row);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                    cen.add(edit);

                    Icon deIcon = new ImageIcon("delete.png");
                    JButton delete = new JButton(deIcon);
                    delete.setBounds(600, 200, 50, 50);
                    delete.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int srow = subTable.getSelectedRow();
                            subAll.remove(subAll.get(srow));
                            subList.get(row).setSubList(subAll);
                            showSubTable(subTable, row, nsub, subList);
                            editManager(subList.get(row), row);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                    cen.add(delete);

                    Icon reIcon = new ImageIcon("return.png");
                    JButton re = new JButton(reIcon);
                    re.setBounds(700, 200, 50, 50);
                    re.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            nsub.setVisible(false);
                            addx.setVisible(true);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                    cen.add(re);

                    Icon aiIcon = new ImageIcon("ai.png");
                    JButton ai = new JButton(aiIcon);
                    ai.setBounds(800, 200, 50, 50);
                    ai.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            JOptionPane.showConfirmDialog(null, subList.get(row).xetHB());
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                    cen.add(ai);

                    Icon se1Icon = new ImageIcon("search.png");
                    JButton se1 = new JButton(se1Icon);
                    se1.setBounds(900, 200, 50, 50);
                    se1.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            subList.get(row).sortID();
                            showSubTable(subTable, row, nsub, subList);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                    cen.add(se1);

                    Icon seIcon = new ImageIcon("search1.png");
                    JButton se = new JButton(seIcon);
                    se.setBounds(1000, 200, 50, 50);
                    se.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            subList.get(row).sortName();
                            showSubTable(subTable, row, nsub, subList);
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });
                    cen.add(se);

                    Icon exitIcon = new ImageIcon("logout.png");
                    JButton exit = new JButton(exitIcon);
                    exit.setBounds(1100, 200, 50, 50);
                    exit.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            gJpa.setVisible(false);
                            Login.setVisible(true);
                            JOptionPane.showMessageDialog(null, "<GoodBye! See you again/>");
                            signin("Log.png");
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                    cen.add(exit);
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        addnew.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Student nstu = new Student(classText.getText(), idText.getText(), Integer.valueOf(SessionText.getText()), nameText.getText(), addText.getText(), mText.getText(), aText.getText());
                stuList.add(nstu);
                subList.add(new ManagerSub(nstu));
                WriteManager(new ManagerSub(nstu));
                showTable(table);
                JOptionPane.showMessageDialog(null, "Add new Student Successful!");
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        edit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                stuList.get(row).setClasses(classText.getText());
                stuList.get(row).setID(idText.getText());
                stuList.get(row).setSession(Integer.valueOf(SessionText.getText()));
                stuList.get(row).setName(nameText.getText());
                stuList.get(row).setAddress(addText.getText());
                stuList.get(row).setSDT(mText.getText());
                stuList.get(row).setMail(aText.getText());
//                System.out.println(stuList.get(row).toString());
                subList.get(row).setPerson(stuList.get(row));
                JOptionPane.showMessageDialog(null, "Edit Infomation Student Successful!");
                showTable(table);
                editManager(subList.get(row), row);
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        delete.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (stuList.remove(stuList.get(row))) {
                    JOptionPane.showMessageDialog(null, "Delete Successful!");
                    showTable(table);
                    String path = "ManagerSub/" + username;
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    //Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
                    DatabaseReference myRef = database.getReference(path);
                    myRef.child(key.get(row)).removeValue(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Delete Error...");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        table.validate();
        table.repaint();

    }

    public void showTable(JTable table) {
        Vector cols = new Vector();
        cols.add("ID");
        cols.add("Name");
        cols.add("Class");
        cols.add("Session");
        cols.add("Address");
        cols.add("Phone Number");
        cols.add("Mail");

        Vector data = new Vector();

//        subList.forEach(each->{
//        stuList.add(each.getPerson());
//        });
        stuList.forEach(each -> {
            Vector g = new Vector();
            g.add(each.getID());
            g.add(each.getName());
            g.add(each.getClasses());
            g.add(each.getSession());
            g.add(each.getAddress());
            g.add(each.getSDT());
            g.add(each.getMail());

            data.add(g);
        });

        table.setModel(new DefaultTableModel(data, cols));
        table.setRowHeight(27);
        table.setFont(new Font("table", Font.PLAIN, 20));
        table.getColumnModel().getColumn(1).setPreferredWidth(250);
        table.getColumnModel().getColumn(4).setPreferredWidth(300);
        table.getColumnModel().getColumn(6).setPreferredWidth(300);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public void showSubTable(JTable subTable, int row, JLabel sub, ArrayList<ManagerSub> gsub) {
        String gx = "ID: " + stuList.get(row).getID() + "                                    Name: " + stuList.get(row).getName();
        JLabel info = new JLabel(gx);
        info.setFont(newfont);
        info.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        sub.add(info, BorderLayout.NORTH);
        Vector cols = new Vector();
        cols.add("ID");
        cols.add("Subject");
        cols.add("Credits");
        cols.add("Session");
        cols.add("Diligence");
        cols.add("Middle");
        cols.add("Final");
        cols.add("Result");
        cols.add("Rank");

        Vector data = new Vector();

//        subList.forEach(each->{
//        stuList.add(each.getPerson());
//        });
        ManagerSub real = gsub.get(row);
        real.getSubList().forEach(each -> {
            Vector g = new Vector();
            g.add(each.getID());
            g.add(each.getName());
            g.add(each.getStin());
            g.add(each.getSession());
            g.add(each.getCcan());
            g.add(each.getMiddle());
            g.add(each.getFinaltest());
            each.EditDtb();
            g.add(each.getDtb());
            g.add(each.getRank());
            data.add(g);
        });

        subTable.setModel(new DefaultTableModel(data, cols));
        subTable.getColumnModel().getColumn(1).setPreferredWidth(650);
        subTable.setRowHeight(27);
        subTable.setFont(new Font("table", Font.PLAIN, 20));
    }

}
