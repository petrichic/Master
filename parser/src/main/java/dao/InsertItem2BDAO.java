package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import item.Item2B;
import model.IAPDFirmSECReport;


public class InsertItem2BDAO {
	public void insertItem2B(ArrayList<Item2B> items2B) {
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
				stmt = con.prepareStatement("Insert into mydb.item2B VALUES(?,?,?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2B().getQ2B1());
				stmt.setString(3, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2B().getQ2B2());
				stmt.setString(4, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2B().getQ2B3());
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
