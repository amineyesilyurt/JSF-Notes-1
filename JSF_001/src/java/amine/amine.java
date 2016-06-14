/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amine;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author John
 */
@ManagedBean(name="yonlendir")
public class amine {
 
    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @PostConstruct
    public void init(){
        name= name+ " Yeşilyurt";      
    }
    
    
}
