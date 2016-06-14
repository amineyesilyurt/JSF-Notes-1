/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amine;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.jboss.weld.util.collections.ArrayListSupplier;

/**
 *
 * @author John
 */
@ManagedBean
@RequestScoped
public class receive {
    
    String radio,oneList;
    
    
    ArrayList<String> manyList= new ArrayList<>();
    ArrayList<String> checkbox= new ArrayList<>();
//    ArrayList<String> radio= new ArrayList<>();
//    ArrayList<String> manyList= new ArrayList<>();
//    ArrayList<String> oneList= new ArrayList<>();

    public ArrayList<String> getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(ArrayList<String> checkbox) {
        this.checkbox = checkbox;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public ArrayList<String> getManyList() {
        return manyList;
    }

    public void setManyList(ArrayList<String> manyList) {
        this.manyList = manyList;
    }
    

    public String getOneList() {
        return oneList;
    }

    public void setOneList(String oneList) {
        this.oneList = oneList;
    }
    
  
    /**
     * Creates a new instance of receive
     */
    public receive() {
    }
    
}
