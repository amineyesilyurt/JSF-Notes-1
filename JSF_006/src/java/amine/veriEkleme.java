package amine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
@ManagedBean
@RequestScoped
public class veriEkleme {

    String name, surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Veritabanına bağlantı sağlıyor
     */
    public Connection GetConnection() throws SQLException{

        Connection con;
        con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String database="jdbc:mysql://localhost:3306/ders_6";
            con= (Connection) DriverManager.getConnection(database, "root","1234");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR connection to database", JOptionPane.INFORMATION_MESSAGE);
        }
        return con;
    }
    
    public void kayit_ekle() throws SQLException{
        try (Connection conn = GetConnection()){
            String sql = "INSERT INTO jsfders_6_table (name,surname) values (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,surname);  
            
            int row = statement.executeUpdate();
            conn.close();
            if(row>0){
                System.out.println("Recorded");
            }
            else{
                System.out.println("Cannot recorded"); 
            }
        }catch(SQLException e){
            System.out.println("ERROR is here "+ e.getMessage()); 
        }
    }
 
    /**
     * Creates a new instance of veriEkleme
     */
    public veriEkleme() {
    }

}
