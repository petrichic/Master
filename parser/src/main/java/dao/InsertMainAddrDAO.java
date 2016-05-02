package dao;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import model.MainAddr;


public class InsertMainAddrDAO {
	public void InsertMainAddr(ArrayList<MainAddr> mainaddrs) {
		Connection con = null;
		PreparedStatement stmt2;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Properties prop = new Properties();
			prop.load(new FileInputStream("src/main/resources/database.properties"));
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			String url = prop.getProperty("url");
			con = DriverManager.getConnection(url, user, password);

			for (int i = 0; i < mainaddrs.size(); i++) {
				stmt2 = con.prepareStatement("Insert into mydb.mainaddr VALUES(?,?,?,?,?,?,?,?,?)");
				stmt2.setInt(1, i + 1);
				stmt2.setString(2, mainaddrs.get(i).getStrt1());
				stmt2.setString(3, mainaddrs.get(i).getStrt2());
				stmt2.setString(4, mainaddrs.get(i).getCity());
				stmt2.setString(5, mainaddrs.get(i).getState());
				stmt2.setString(6, mainaddrs.get(i).getCntry());
				stmt2.setString(7, mainaddrs.get(i).getPostlCd());
				stmt2.setString(8, mainaddrs.get(i).getPhNb());
				stmt2.setInt(9, i + 1);
				stmt2.executeUpdate();

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