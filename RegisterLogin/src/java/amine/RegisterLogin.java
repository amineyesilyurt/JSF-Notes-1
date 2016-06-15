/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;



/**
 *
 * @author John
 */
@ManagedBean
@RequestScoped
public class RegisterLogin {

    private String nickname, password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection GetConnection() throws SQLException {

        Connection con;
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String database = "jdbc:mysql://localhost:3306/dbregister";
            con = (Connection) DriverManager.getConnection(database, "root", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString(), "ERROR connection to database", JOptionPane.INFORMATION_MESSAGE);
        }
        return con;
    }

    public String login() throws SQLException {
        try (Connection conn = GetConnection()) {
            Statement statement = conn.createStatement();
            String sql = "SELECT* FROM register_table";
            ResultSet rs = statement.executeQuery(sql);

            while ((rs != null) && rs.next()) {

                System.out.println("name =" + rs.getString("nickname") + "pasword =" + rs.getString("pasword"));

                if (nickname.equals(rs.getString("nickname")) && password.equals(rs.getString("pasword"))) {
                    return "home";
                }
            }

            conn.close();
        } catch (SQLException e) {
            //Logger.getLogger(DataOperation.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("ERROR is here " + e.getMessage());
        }
        return "";
    }
    
    
     public void register() throws SQLException {
        try (Connection conn = GetConnection()) {
            String sql = "INSERT INTO register_table (nickname,pasword) values (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nickname);
            statement.setString(2, password);

            int row = statement.executeUpdate();
            conn.close();
            if (row > 0) {
                System.out.println("Recorded");
            } else {
                System.out.println("Cannot recorded");
            }
        } catch (SQLException e) {
            System.out.println("ERROR is here " + e.getMessage());
        }
    }


    /**
     * Creates a new instance of RegisterLogin
     */
    public RegisterLogin() {
    }

}
