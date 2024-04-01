package com.ders17.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
	private static final String DB_URL = "jdbc:mysql://emre-eser-lp:3306/sys";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "emreeser123";

	public void run() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Veritabanına bağlanma
            System.out.println("Veritabanına bağlanıldı.");

            String query = "SELECT * FROM employees WHERE department = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, "IT");

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println("Employee ID: " + resultSet.getInt("id"));
                        System.out.println("Name: " + resultSet.getString("name"));
                        System.out.println("Department: " + resultSet.getString("department"));
                        System.out.println("Salary: " + resultSet.getDouble("salary"));
                        System.out.println("--------------------");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
