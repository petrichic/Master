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

import model.Firm;
import model.Rgstn;

public class InsertRgstnDAO implements IRgstn{
	public void insertRgstn(ArrayList<Firm> listFirms, int size, Rgstn rgstn) throws SQLException, IOException{
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
				stmt = con.prepareStatement("Insert into mydb.rgstn VALUES(?,?,?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, listFirms.get(i).getRgstn().getFirmType());
				stmt.setString(3, listFirms.get(i).getRgstn().getSt());
				Date Dt = new Date(listFirms.get(i).getRgstn().getDt().getTime());
				stmt.setDate(4, Dt);
				stmt.setInt(5, listFirms.get(i).getInfo().getId());
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