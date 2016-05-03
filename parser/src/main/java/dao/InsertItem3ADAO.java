package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import item.Item3A;
import model.IAPDFirmSECReport;


public class InsertItem3ADAO {
	public void insertItem3A(ArrayList<Item3A> items3A) {
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
				// for (int i = 0; i < items3A.size(); i++) {
				stmt = con.prepareStatement("Insert into mydb.item3A VALUES(?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem3A().getOrgFormNm());
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
