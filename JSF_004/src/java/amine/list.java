/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amine;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author John
 */
@ManagedBean
@RequestScoped
public class list {

    ArrayList<String> manycb = new ArrayList<>();
    ArrayList<String> manycbMembers = new ArrayList<>();
    
    

    public ArrayList<String> getOneSelectList() {
        return oneSelectList;
    }

    public void setOneSelectList(ArrayList<String> oneSelectList) {
        this.oneSelectList = oneSelectList;
    }
    ArrayList<String> oneSelectList = new ArrayList<>();

    public String getOneSelect() {
        return oneSelect;
    }

    public void setOneSelect(String oneSelect) {
        this.oneSelect = oneSelect;
    }

    String oneSelect;

    public ArrayList<String> getManycb() {
        return manycb;
    }

    public void setManycb(ArrayList<String> manycb) {
        this.manycb = manycb;
    }

    public ArrayList<String> getManycbMembers() {
        return manycbMembers;
    }

    public void setManycbMembers(ArrayList<String> manycbMembers) {
        this.manycbMembers = manycbMembers;
    }

    /**
     * Creates a new instance of list
     */
    public list() {
        manycbMembers.add("Elma");
        manycbMembers.add("Portakal");
        manycbMembers.add("Karpuz");

        oneSelectList.add("Roka");
        oneSelectList.add("Nane");
        oneSelectList.add("Biber");
        
        
    }

}
