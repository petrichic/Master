package dao;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import model.IAPDFirmSECReport;
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
				stmt2.setInt(1, 0);
				stmt2.setString(2, IAPDFirmSECReport.getFirms().getListFirms().get(i).getMainaddr().getStrt1());
				stmt2.setString(3, IAPDFirmSECReport.getFirms().getListFirms().get(i).getMainaddr().getStrt2());
				stmt2.setString(4, IAPDFirmSECReport.getFirms().getListFirms().get(i).getMainaddr().getCity());
				stmt2.setString(5, IAPDFirmSECReport.getFirms().getListFirms().get(i).getMainaddr().getState());
				stmt2.setString(6, IAPDFirmSECReport.getFirms().getListFirms().get(i).getMainaddr().getCntry());
				stmt2.setString(7, IAPDFirmSECReport.getFirms().getListFirms().get(i).getMainaddr().getPostlCd());
				stmt2.setString(8, IAPDFirmSECReport.getFirms().getListFirms().get(i).getMainaddr().getPhNb());
				int j = IAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getId();
				stmt2.setInt(9, j);
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