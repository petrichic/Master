package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import item.Item2A;
import model.IAPDFirmSECReport;


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
				stmt.setInt(1, 0);
				stmt.setString(2, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A1());
				stmt.setString(3, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A2());
				stmt.setString(4, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A3());
				stmt.setString(5, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A4());
				stmt.setString(6, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A5());
				stmt.setString(7, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A6());
				stmt.setString(8, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A7());
				stmt.setString(9, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A8());
				stmt.setString(10, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A9());
				stmt.setString(11, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A10());
				stmt.setString(12, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A11());
				stmt.setString(13, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A12());
				stmt.setString(14, IAPDFirmSECReport.getFirms().getListFirms().get(i).getFormInfo().getPart1A().getItem2A().getQ2A13());
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
