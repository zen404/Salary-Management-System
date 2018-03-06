package com.zensar.sps;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class SPS {
	DAO dao = new DAO();

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		SPS sps = new SPS();
		Processor pro = new Processor();
		try {
			sps.dao.createTable();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		pro.login();
		

	}

}
