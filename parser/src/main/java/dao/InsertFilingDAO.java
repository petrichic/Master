package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import model.Filing;
import model.Firm;

public class InsertFilingDAO implements IFiling{
	public void insertFiling(ArrayList<Firm> listFirms, int size, Filing filing) throws SQLException, IOException {
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
				stmt = con.prepareStatement("Insert into mydb.filing VALUES(?,?,?,?)");
				stmt.setInt(1, 0);
				Date Dt = new Date(listFirms.get(i).getFiling().getDt().getTime()); 
				stmt.setDate(2, Dt);
				Date FormVrsn = new Date(listFirms.get(i).getFiling().getFormVrsn().getTime()); 
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
