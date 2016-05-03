package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import item.Item1;
import model.IAPDFirmSECReport;


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
				stmt.setInt(1, 0);
				stmt.setString(2, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem1().getQ1I());
				stmt.setString(3, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem1().getQ1M());
				stmt.setString(4, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem1().getQ1N());
				stmt.setString(5, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem1().getQ1O());
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
