package ru.aston;

import ru.aston.Connection.MainClass;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        MainClass mainClass = new MainClass();
        mainClass.getConnection();
        mainClass.selectAllStudents();
        mainClass.selectAll();
        mainClass.insertIntoStudents("John Malkovich", "1202 2020202020");
        mainClass.deleteByName("John Malkovich");
    }
}