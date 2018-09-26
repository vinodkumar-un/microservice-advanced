package com.rt.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public Connection getConnection() throws IOException,
			ClassNotFoundException, SQLException {
		Properties props = null;
		Connection con = null;

		props = new Properties();
		props.load(this.getClass().getClassLoader()
				.getResourceAsStream("db.properties"));
		Class.forName(props.getProperty("db.driverClassname"));
		con = DriverManager.getConnection(props.getProperty("db.url"),
				props.getProperty("db.username"),
				props.getProperty("db.password"));
		return con;
	}
}
