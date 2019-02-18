/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author nguye
 */
public class ManagerSub implements Serializable {

    private static final ArrayList<Subject> containers = new SubjectRW().read();
    private Student person;
    private ArrayList<Subject> subList;
    private int Totaltin;
    private long tuition;

    public ManagerSub(Student person, ArrayList<Subject> subList, int Totaltin, long tuition) {
        this.person = person;
        this.subList = subList;
        this.Totaltin = Totaltin;
        this.tuition = tuition;
    }

    public ManagerSub(Student person) {
        this.person = person;
        this.Totaltin = 0;
        this.tuition = 0;
        this.subList = new ArrayList<>();
        containers.forEach(each -> {
            if (each.getSession() == person.getSession()) {
                this.subList.add(each);
                this.Totaltin += each.getStin();
            }
        });
        this.tuition = 460000 * this.Totaltin;
    }

    public ManagerSub() {
        this.person = new Student();
        subList = new ArrayList<>();
        this.Totaltin = 0;
        this.tuition = 0;
        containers.forEach(each -> {
            if (each.getSession() == person.getSession()) {
                this.subList.add(each);
                this.Totaltin += each.getStin();
            }
        });
        this.tuition = 460000 * this.Totaltin;
    }

    public Student getPerson() {
        return person;
    }

    public void setPerson(Student person) {
        this.person = person;
    }

    public ArrayList<Subject> getSubList() {
        return subList;
    }

    public void setSubList(ArrayList<Subject> subList) {
        this.subList = subList;
    }

    public int getTotaltin() {
        return Totaltin;
    }

    public void setTotaltin(int Totaltin) {
        this.Totaltin = Totaltin;
    }

    public long getTuition() {
        return tuition;
    }

    public void setTuition(long tuition) {
        this.tuition = tuition;
    }

    public void addSub(String ID) {
        for (int i = 0; i < containers.size(); i++) {
            if (containers.get(i).getID().compareTo(ID) == 0) {
                this.subList.add(containers.get(i));
                this.Totaltin += containers.get(i).getStin();
                this.tuition += 460000 * containers.get(i).getStin();
                break;
            }
        }
    }

    public void deleteSub(String ID) {
        for (int i = 0; i < subList.size(); i++) {
            if (subList.get(i).getID().compareTo(ID) == 0) {
                this.Totaltin -= subList.get(i).getStin();
                this.tuition -= subList.get(i).getStin() * 460000;
                this.subList.remove(subList.get(i));
                break;
            }
        }
    }

    public double Hs4() {
        double ans = 0;
        for (int i = 0; i < subList.size(); i++) {
            ans += subList.get(i).Get4() * subList.get(i).getStin();
        }
        ans = (double) ans / this.Totaltin;
        return ans;
    }

    public String xetHB() {
        Random rd = new Random();
        if (this.Hs4() > 3.2) {
            int sx = rd.nextInt(40);
            sx += 59;
            String tmp = "" + sx;
            return "Cơ hội được hổng bổng khoảng " + tmp + "%";
        } else if (this.Hs4() > 2.9) {
            int sx = rd.nextInt(30);
            sx += 30;
            String tmp = "" + sx;
            return "Cơ hội được hổng bổng khoảng " + tmp + "%\n có thể được vào danh sách xét học bổng";
        }
        return "Không có cơ hội được học bổng!!!";
    }

    @Override
    public String toString() {
        return "ManagerSub{" + "person=" + person + ", subList=" + subList + ", Totaltin=" + Totaltin + ", tuition=" + tuition + '}';
    }

    public void sortID() {
        
        subList.sort(new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return o1.getID().compareTo(o2.getID());
            }
        });
    }

    public void sortName(){
        subList.sort(new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return o1.getName().compareTo(o2.getName());
            }
        });    
}
    public static void main(String[] args) {
        System.out.println(new ManagerSub().toString());
//        containers.forEach(each->{
//            System.out.println(each.toString());
//        });
    }
}
