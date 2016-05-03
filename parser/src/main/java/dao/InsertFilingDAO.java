package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import model.Filing;
import model.IAPDFirmSECReport;

public class InsertFilingDAO {
	public void insertFiling(ArrayList<Filing> filings) {
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
			//for (int i = 0; i < filings.size(); i++) {
				stmt = con.prepareStatement("Insert into mydb.filing VALUES(?,?,?,?)");
				stmt.setInt(1, 0);
				Date Dt = new Date(IAPDFirmSECReport.getFirms().getListFirms().get(i).getFiling().getDt().getTime()); 
				stmt.setDate(2, Dt);
				Date FormVrsn = new Date(IAPDFirmSECReport.getFirms().getListFirms().get(i).getFiling().getFormVrsn().getTime()); 
				stmt.setDate(3, FormVrsn);
				stmt.setInt(4, i+1);
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
