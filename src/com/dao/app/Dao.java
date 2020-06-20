package com.dao.app;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dao {
	private static Dao instance;

	public Connection getConnection() {
		Connection connection = null;
		try {    //nom dyal la base données cryptage
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/cryptage?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		} catch (Exception e) {
			System.out.println("Erreur " + e.getMessage());
		}
		return connection;
	}
	
	public static Dao getInstance() {
		if(instance == null) {
			instance = new Dao();
		}
		return instance;
	}

}
