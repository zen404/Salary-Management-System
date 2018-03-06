package com.zensar.sps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DAO {
	Connection con = null;
	ResultSet rs = null;
	Statement stmt = null;
	FileReader fr;
	BufferedReader br;
	Scanner in = new Scanner(System.in);

	public final static String drvClass = "oracle.jdbc.driver.OracleDriver";
	public final static String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	public final static String userName = "System";
	public final static String password = "hr";

	// Create connection
	public void createConnection() throws ClassNotFoundException, SQLException {
		Class.forName(drvClass);

		con = DriverManager.getConnection(jdbcURL, userName, password);
		System.out.println("Connection Established");
	}

	// Create Employee table
	public void createTable() throws ClassNotFoundException, SQLException, IOException {
		createConnection();
		stmt = con.createStatement();

		rs = stmt.executeQuery(
				"create table Employee(ID number primary key,First_Name varchar(20),Last_Name varchar(20),Attendance Number,Band Varchar(1))");
		System.out.println("Table Created...");
		populateTable();

	}

	// Populate table
	public void populateTable() throws IOException, SQLException {
		fr = new FileReader("payrollsystem.csv");
		br = new BufferedReader(fr);
		String str = null;
		while ((str = br.readLine()) != null) {
			String[] data = str.split(",");

			int id = Integer.valueOf(data[0]);
			String first_Name = data[1];
			String last_Name = data[2];
			int attendance = Integer.valueOf(data[3]);
			String band = data[4];

			PreparedStatement stmt = con.prepareStatement("insert into Employee values(?,?,?,?,?)");
			stmt.setInt(1, id);
			stmt.setString(2, first_Name);
			stmt.setString(3, last_Name);
			stmt.setInt(4, attendance);
			stmt.setString(5, band);
			stmt.executeUpdate();
		}
		System.out.println("Inserted into Database...");
	}

	

	// Search method
	public void searchSalaryData() throws ClassNotFoundException, SQLException {
		System.out.println("Enter Employee-ID: ");
		int empid = in.nextInt();
		createConnection();
		PreparedStatement stmt = con.prepareStatement("select * from employee where id=?");
		stmt.setInt(1, empid);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " "
					+ rs.getString(5));
		}

	}

	// Display all employee data
	public void displaySalaryData() throws ClassNotFoundException, SQLException {

		createConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from employee");
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();

		for (int i = 1; i <= colCount; i++) {
			System.out.print(rsmd.getColumnName(i) + "  ");
		}
		System.out.println();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   " + rs.getInt(4)
					+ "   " + rs.getString(5));
		}

	}

}
