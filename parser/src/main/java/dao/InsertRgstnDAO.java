package dao;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import model.Rgstn;

public class InsertRgstnDAO {
	public void InsertRgstn(ArrayList<Rgstn> rgstns) {
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

			for (int i = 0; i < rgstns.size(); i++) {
				stmt = con.prepareStatement("Insert into mydb.rgstn VALUES(?,?,?,?,?)");
				stmt.setInt(1, i + 1);
				stmt.setString(2, rgstns.get(i).getFirmType());
				stmt.setString(3, rgstns.get(i).getSt());
				stmt.setString(4, rgstns.get(i).getDt());
				stmt.setInt(5, i+1);
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