package ru.aston;

import ru.aston.Connection.MainClass;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainClass mainClass = new MainClass();
        mainClass.getConnection();
        mainClass.selectAllStudents();
        mainClass.selectAll();
   //     mainClass.insertIntoStudents("Jojo1", "1233");
        mainClass.deleteByName("John%");
    }
}