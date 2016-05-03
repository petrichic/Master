package dao;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import model.IAPDFirmSECReport;
import model.Info;

public class InsertInfoDAO {
	public void InsertInfo(ArrayList<Info> infos) {
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

			for (int i = 0; i < infos.size(); i++) {
				stmt = con.prepareStatement("Insert into mydb.info VALUES(?,?,?,?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, IAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getsECRgnCD());
				stmt.setString(3, IAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getFirmCrdNb());
				stmt.setString(4, IAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getsECNb());
				stmt.setString(5, IAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getBusNm());
				stmt.setString(6, IAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getLegalNm());
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