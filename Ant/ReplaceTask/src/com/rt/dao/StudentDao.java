package com.rt.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rt.util.ConnectionUtil;

public class StudentDao {
	public static void main(String[] args) throws ClassNotFoundException,
			IOException, SQLException {
		ConnectionUtil cu = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		cu = new ConnectionUtil();
		con = cu.getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM STUDENT");
		while (rs.next()) {
			System.out.println("Id : " + rs.getInt("STUDENT_ID") + " Name: "
					+ rs.getString("NAME"));
		}
	}
}
