/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author nguye
 */
public class Subject implements Serializable {

    private String name, ID;
    private int Session, stin;
    private double ccan, middle, finaltest, dtb;

    public Subject(String ID, String name, int Session, int stin, double ccan, double middle, double finaltest, double dtb) {
        this.ID = ID;
        this.name = name;
        this.Session = Session;
        this.stin = stin;
        this.ccan = ccan;
        this.middle = middle;
        this.finaltest = finaltest;
        this.dtb = dtb;
    }

    public Subject() {
        this.ID = "December27";
        this.name = "ProPTIT";
        this.Session = 1;
        this.stin = 2;
        this.ccan = 10;
        this.middle = 10;
        this.finaltest = 10;
        this.dtb = 10;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSession() {
        return Session;
    }

    public void setSession(int Session) {
        this.Session = Session;
    }

    public int getStin() {
        return stin;
    }

    public void setStin(int stin) {
        this.stin = stin;
    }

    public double getCcan() {
        return ccan;
    }

    public void setCcan(double ccan) {
        this.ccan = ccan;
    }

    public double getMiddle() {
        return middle;
    }

    public void setMiddle(double middle) {
        this.middle = middle;
    }

    public double getFinaltest() {
        return finaltest;
    }

    public void setFinaltest(double finaltest) {
        this.finaltest = finaltest;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    public void EditDtb() {
        this.dtb = (double) 0.1 * ccan + 0.2 * middle + 0.7 * finaltest;
    }

    public double Get4() {
        double ans;
        if (dtb >= 9) {
            ans = 4;
        } else if (dtb >= 8.5) {
            ans = 3.7;
        } else if (dtb >= 8) {
            ans = 3.5;
        } else if (dtb >= 7) {
            ans = 3;
        } else if (dtb >= 6.5) {
            ans = 2.5;
        } else if (dtb >= 5.5) {
            ans = 2;
        } else if (dtb >= 5) {
            ans = 1.5;
        } else if (dtb >= 4) {
            ans = 1;
        } else {
            ans = 0;
        }
        return ans;
    }

    public String getRank() {
        double tmp = Get4();
        if (ccan == 0 || middle == 0 || finaltest == 0) {
            return "None";
        }
        if (tmp == 4) {
            return "A+";
        } else if (tmp == 3.7) {
            return "A";
        } else if (tmp == 3.5) {
            return "B+";
        } else if (tmp == 3.0) {
            return "B";
        } else if (tmp == 2.5) {
            return "C+";
        } else if (tmp == 2.0) {
            return "C";
        } else if (tmp == 1.5) {
            return "D+";
        } else if (tmp == 1.0) {
            return "D";
        }
        return "F";
    }

    @Override
    public String toString() {
        return "Subject{" + "name=" + name + ", Session=" + Session + ", stin=" + stin + ", ccan=" + ccan + ", middle=" + middle + ", finaltest=" + finaltest + ", dtb=" + dtb + '}';
    }

    public static void main(String[] args) {
        ArrayList<Subject> SubList = new ArrayList<>();
        SubList.add(new Subject("BAS1203", "Giai tich 1", 1, 3, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1111", "Nhung nguyen ly co ban cua chu nghia Mac - Lenin 1", 1, 2, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1106", "Giao duc the chat 1", 1, 2, 0, 0, 0, 0));
        SubList.add(new Subject("INT1154", "Tin hoc co so 1", 1, 2, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1201", "Dai so", 1, 3, 0, 0, 0, 0));
        SubList.add(new Subject("INT1155", "Tin hoc co so 2", 2, 2, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1107", "Giao duc the chat 2", 2, 2, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1204", "Giai tich 2", 2, 3, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1141", "Tieng anh A11", 2, 3, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1226", "Xac suat thong ke", 2, 2, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1224", "Vat ly 1 va thi nghiem", 2, 4, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1112", "Nhung nguyen ly co ban cua chu nghia Mac - Lenin 2", 2, 3, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1122", "Tu tuong Ho Chi Minh", 3, 2, 0, 0, 0, 0));
        SubList.add(new Subject("ELE1433", "Ky thuat so", 3, 2, 0, 0, 0, 0));
        SubList.add(new Subject("INT1358", "Toan roi rac 1", 3, 3, 0, 0, 0, 0));
        SubList.add(new Subject("INT1339", "Ngon ngu lap trinh C++", 3, 3, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1227", "Vat ly 3 va thi nghiem", 3, 4, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1142", "Tieng anh A12", 3, 4, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1102", "Duong loi cach mang cua Dang cong san Viet Nam", 4, 3, 0, 0, 0, 0));
        SubList.add(new Subject("BAS1143", "Tieng anh A21", 4, 3, 0, 0, 0, 0));
        SubList.add(new Subject("ELE1319", "Ly thuyet thong tin", 4, 3, 0, 0, 0, 0));
        SubList.add(new Subject("ELE1330", "Xu ly tin hieu so", 4, 2, 0, 0, 0, 0));
        SubList.add(new Subject("INT1306", "Cau truc du lieu giai thuat", 4, 3, 0, 0, 0, 0));
        SubList.add(new Subject("INT1323", "Kien truc may tinh", 4, 2, 0, 0, 0, 0));
        SubList.add(new Subject("INT1359", "Toan roi rac 2", 4, 3, 0, 0, 0, 0));
        SubList.add(new Subject("SKD1103", "Ky nang tao lap van ban", 4, 1, 0, 0, 0, 0));
        new SubjectRW().write(SubList);
        ArrayList<Subject> test = new SubjectRW().read();
        test.forEach(each -> {
            System.out.println(each.toString());
        });
    }
}
