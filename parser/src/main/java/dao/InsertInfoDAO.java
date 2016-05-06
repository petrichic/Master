package dao;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import model.Firm;
import model.Info;

public class InsertInfoDAO implements IInfo{
	public void insertInfo(ArrayList<Firm> listFirms, int size, Info info) throws SQLException, IOException {
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

			for (int i = 0; i < size; i++) {
				stmt = con.prepareStatement("Insert into mydb.info VALUES(?,?,?,?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, listFirms.get(i).getInfo().getsECRgnCD());
				stmt.setString(3, listFirms.get(i).getInfo().getFirmCrdNb());
				stmt.setString(4, listFirms.get(i).getInfo().getsECNb());
				stmt.setString(5, listFirms.get(i).getInfo().getBusNm());
				stmt.setString(6, listFirms.get(i).getInfo().getLegalNm());
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