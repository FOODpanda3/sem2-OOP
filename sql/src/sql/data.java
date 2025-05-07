package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class data {

    public void SaveData(String name, int age, String course) {
       try {
        Connection c = DBConnection.getConnection();
        if (c == null) {
            System.out.println("Failed to connect");
            return;
        }

        String query = "INSERT INTO students (name, age, course) VALUES (?, ?, ?)";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, course);

        ps.executeUpdate();
        System.out.println("Successfully Saved");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }

    public void PrintData() {
       try {
        Connection c = DBConnection.getConnection();
        if (c == null) {
            System.out.println("Failed to connect.");
            return;
        }

        String query = "SELECT * FROM students";
        PreparedStatement ps = c.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        System.out.println("ID | Name | Age | Course");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " +
                               rs.getString("name") + " | " +
                               rs.getInt("age") + " | " +
                               rs.getString("course"));
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }}}
