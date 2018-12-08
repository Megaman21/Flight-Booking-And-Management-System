/*package com.eL.webproject;

import com.sun.glass.ui.Size;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.out;

public class DAL {

    database.DBmanager db;
    Connection conn;
    UserClass currentUser = null;
    public DAL() {
        db = null;
        conn = db.getConnection();
    }
    public UserClass Login (String email, String password){
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1,email);
            stmt.setString(2,password);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                currentUser = new UserClass(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                return currentUser;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentUser;
    }
    public boolean Signup (String username, String email, String password, String userType){
        String checkSql = "SELECT * FROM user WHERE email = ?";
        String insertSql = "INSERT INTO user (email,username,password,usertype) VALUES (?,?,?,?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(checkSql);
            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return false;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement stmt1 = conn.prepareStatement(insertSql);
            stmt1.setString(1,email);
            stmt1.setString(2,username);
            stmt1.setString(3,password);
            stmt1.setString(4,userType);
            stmt1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void CloseConnetion() throws SQLException {
         conn.close();
    }
}
*/