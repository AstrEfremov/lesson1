package ru.aston.Connection;

import java.sql.*;
import java.util.Properties;

public class MainClass {
    public Connection getConnection() throws SQLException {
        Connection connection;
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "postgres");
        connectionProperties.put("password", "postgres");

        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                connectionProperties
        );
        return connection;
    }

    public void selectAllStudents() throws SQLException {
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from students");
        while (rs.next()) {
            String str = rs.getInt("id" ) +
                    ": " +
                    rs.getString("name")
                    + ": " + rs.getString(3);
            System.out.println(str);
        }
        rs.close();
        stmt.close();
    }

    public void selectAll() throws SQLException {
        Statement stmt = getConnection().createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from students JOIN academic_perfomance ON students.id = academic_perfomance.student JOIN postgres.subjects s on academic_perfomance.subject = s.id");
        while (rs.next()) {
            String str = rs.getInt("id") +
                    ": " +
                    rs.getString("name")
                    + ": " + rs.getString(3) +
                    rs.getString("passport")
                    + ": " + rs.getString(4) +
                    rs.getString("mark")
                    + ": " + rs.getString(5) +
                    rs.getString("subject")
                    + ": " + rs.getString(6) +
                    rs.getString("name")
                    + ": " + rs.getString(7) +
                    rs.getString("name")
                    + ": " + rs.getString(8);
            System.out.println(str);
        }
        rs.close();
        stmt.close();
    }

    public void deleteByName(String studentName) throws SQLException{
        Statement stmt = getConnection().createStatement();
        String res = "DELETE from students WHERE name = "+ "'"+studentName+ "'"+ ";";
        stmt.executeUpdate(res);
        stmt.close();
    }
    public void insertIntoStudents(String studentName, String passport) throws SQLException{
        Statement stmt = getConnection().createStatement();
        String res = "INSERT into students (name, passport) VALUES ('" +studentName+ "', '"+ passport+"');";
        ResultSet rs = stmt.executeQuery(res);
        System.out.println(studentName+ " Добавлен");
        stmt.executeUpdate(res);
        rs.close();
        stmt.close();
    }
}
