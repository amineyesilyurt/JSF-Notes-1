/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amine;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author John
 */
@ManagedBean
@RequestScoped
public class ilk {
    
    private String name;
    private String pasword="1234";
    /**
     * Creates a new instance of ilk
     */
    public ilk() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPasword() {
        return pasword;
    }
    
    public String  sorgula(){
        if( name.equals(pasword))
            return "sayfa";
        else
            return "";
    }
}
