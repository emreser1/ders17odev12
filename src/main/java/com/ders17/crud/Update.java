package com.ders17.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	private static final String DB_URL = "jdbc:mysql://emre-eser-lp:3306/sys";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "emreeser123";

	public void run() {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			// Veritabanına bağlanma
			System.out.println("Veritabanına bağlanıldı.");

			String query = "UPDATE employees SET id = ?, name = ? salary = ? WHERE department = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, "a49fe11e7e6d4d11b1941b39f81fc982");
				preparedStatement.setString(2, "emre");
				preparedStatement.setString(3, "35000");
				preparedStatement.setString(4, "IT");
				int affectedRows = preparedStatement.executeUpdate();
				if (affectedRows > 0) {
					System.out.println("updated.");
				} else {
					System.out.println("can not updated.");
				}
				preparedStatement.close();
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
