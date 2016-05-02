package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import item.Item2A;


public class InsertItem2ADAO {
	public void insertItem2A(ArrayList<Item2A> items2A) {
		Connection con = null;
		PreparedStatement stmt;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/main/resources/database.properties"));
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			String url = prop.getProperty("url");
			con = DriverManager.getConnection(url, user, password);

			for (int i = 0; i < 50; i++){
				// for (int i = 0; i < items2A.size(); i++) {
				stmt = con.prepareStatement("Insert into mydb.item2A VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				stmt.setInt(1, i + 1);
				stmt.setString(2, items2A.get(i).getQ2A1());
				stmt.setString(3, items2A.get(i).getQ2A2());
				stmt.setString(4, items2A.get(i).getQ2A3());
				stmt.setString(5, items2A.get(i).getQ2A4());
				stmt.setString(6, items2A.get(i).getQ2A5());
				stmt.setString(7, items2A.get(i).getQ2A6());
				stmt.setString(8, items2A.get(i).getQ2A7());
				stmt.setString(9, items2A.get(i).getQ2A8());
				stmt.setString(10, items2A.get(i).getQ2A9());
				stmt.setString(11, items2A.get(i).getQ2A10());
				stmt.setString(12, items2A.get(i).getQ2A11());
				stmt.setString(13, items2A.get(i).getQ2A12());
				stmt.setString(14, items2A.get(i).getQ2A13());
				stmt.setInt(15, i + 1);
				stmt.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
