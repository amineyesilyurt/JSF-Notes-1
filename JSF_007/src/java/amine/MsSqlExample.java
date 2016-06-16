/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amine;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;

/**
 *
 * @author John
 */
@ManagedBean
@RequestScoped
public class MsSqlExample {

    private String name, surname;

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

    public Connection getConnection() {

        //Şifreyi değiştir
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=dbStudents;user=amine;password=789";
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(connectionURL);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "Student", JOptionPane.INFORMATION_MESSAGE);
        }
        return conn;
    }

    public void kayit_ekle() throws SQLException {
        try (Connection conn = getConnection()) {
            String sql = "INSERT INTO student_table (name,surname) values (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, surname);

            int row = statement.executeUpdate();
            conn.close();
            if (row > 0) {
                System.out.println("Recorded");
                //JOptionPane.showMessageDialog(null, "Kayıt başarılı");
            } else {
                System.out.println("Cannot recorded");
            }
        } catch (SQLException e) {
            System.out.println("ERROR is here " + e.getMessage());

        }

    }

    /**
     * Creates a new instance of MsSqlExample
     */
    public MsSqlExample() {
    }

}
