/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnvt.prochat;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author nguye
 */
public class ManagerList {
    private ManagerSubRW fi = new ManagerSubRW();
    private ArrayList<ManagerSub> manList;

    public ManagerList() {
        manList = new ArrayList<>();
    }

    public ManagerList(ArrayList<ManagerSub> manList) {
        this.manList = manList;
    }

    public ManagerSubRW getFi() {
        return fi;
    }

    public void setFi(ManagerSubRW fi) {
        this.fi = fi;
    }

    public ArrayList<ManagerSub> getManList() {
        return manList;
    }

    public void setManList(ArrayList<ManagerSub> manList) {
        this.manList = manList;
    }

    public void add(ManagerSub student) {
        manList.add(student);
        fi.write(manList);
    }

    public void edit(String ID, ManagerSub student){
        boolean check = false;
        for(int i = 0; i < manList.size(); i++){
            if(manList.get(i).getPerson().getID().compareTo(ID) == 0){
                check = true;
                manList.get(i).setPerson(student.getPerson());
                manList.get(i).setSubList(student.getSubList());
                manList.get(i).setTotaltin(student.getTotaltin());
                manList.get(i).setTuition(student.getTuition());
                break;
            }
        }
        if(check == true) fi.write(manList);
    }
    
    public void delete(String ID){
        boolean check = false;
        ManagerSub tmp = null;
        for(int i = 0; i < manList.size(); i++){
            if(manList.get(i).getPerson().getID().compareTo(ID) == 0){
                check = true;
                tmp = manList.get(i);
                break;
            }
        }
        if(check == true){
            manList.remove(tmp);
            fi.write(manList);
        }
    }
    
    public void sortName(){
        manList.sort(new Comparator<ManagerSub>() {
            @Override
            public int compare(ManagerSub o1, ManagerSub o2) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(o1.getPerson().getID().compareTo(o2.getPerson().getID()) > 0) return 0;
                return 1;
            }
        });
        fi.write(manList);
    }
    
    public void sortHS4(){
        manList.sort(new Comparator<ManagerSub>() {
            @Override
            public int compare(ManagerSub o1, ManagerSub o2) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if(o1.Hs4() > o2.Hs4()) return 1;
                return 0;
            }
        });
        fi.write(manList);
    }

    @Override
    public String toString() {
        return "ManagerList{" + "manList=" + manList + '}';
    }
    
    
    public static void main(String[] args) {
        ArrayList<ManagerSub> gg = new ManagerSubRW().read();
        gg.forEach(each->{
            System.out.println(each.toString());
        });
        gg.add(new ManagerSub(new Student()));
        ManagerList x = new ManagerList(gg);
        //System.out.println(x);
    }
}
