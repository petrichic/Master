package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import item.Item1;


public class InsertItem1DAO {
	public void insertItem1(ArrayList<Item1> items1) {
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
			//for (int i = 0; i < itens1.size(); i++) {
				stmt = con.prepareStatement("Insert into mydb.item1 VALUES(?,?,?,?,?,?)");
				stmt.setInt(1, i + 1);
				stmt.setString(2, items1.get(i).getQ1I());
				stmt.setString(3, items1.get(i).getQ1M());
				stmt.setString(4, items1.get(i).getQ1N());
				stmt.setString(5, items1.get(i).getQ1O());
				stmt.setInt(6, i + 1);
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
