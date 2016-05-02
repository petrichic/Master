package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import item.WebAddr;


public class InsertWebAddrDAO {
	public void insertWebAddr(ArrayList<WebAddr> webaddrs) {
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

			for (int i = 0; i < 50; i++) {
				// for (int i = 0; i < webaddrs.size(); i++) {
				stmt = con.prepareStatement("Insert into mydb.webaddr VALUES(?,?,?)");
				stmt.setInt(1, i + 1);
				stmt.setString(2, webaddrs.get(i).getEmail());
				stmt.setInt(3, i + 1);
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
