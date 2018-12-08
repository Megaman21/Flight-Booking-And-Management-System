package Models;

import database.DBmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int userId;
    private String type, fullName, email,password;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }
   public User()
    {}

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setPassword(String password) {this.password=password;}
    public String getPassword(){return password;}
    public boolean signup_user()
    {
        DBmanager db=null;
        Connection conn=null;
        conn=db.getConnection();
        String sql="SELECT * FROM airline.users WHERE Emailid=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();
            if(!rs.next()){

                stmt.close();

                 sql = "INSERT INTO users (Emailid, password,type)" +
                        "VALUES (?, ?, ?)";
                 stmt=conn.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2,password);
                stmt.setString(3,type);
                stmt.execute();
                return true;
                }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
