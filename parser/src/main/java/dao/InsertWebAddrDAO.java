package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import item.WebAddr;
import model.IAPDFirmSECReport;


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
				stmt = con.prepareStatement("Insert into mydb.states VALUES(?,?,?)");
				stmt.setInt(1, 0);
				//stmt.setNString(2, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem1().getWebAddrs().getWebAddr());
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
