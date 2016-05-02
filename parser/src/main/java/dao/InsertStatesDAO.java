package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;

import model.States;


public class InsertStatesDAO {
	public void insertStates(ArrayList<States> states) {
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
				// for (int i = 0; i < states.size(); i++) {
				stmt = con.prepareStatement("Insert into mydb.states VALUES(?,?,?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, states.get(i).getRgltrCd());
				stmt.setString(3, states.get(i).getSt());
				Date Dt = new Date(states.get(i).getDt().getTime());
				stmt.setDate(4, Dt);
				stmt.setInt(5, states.get(i).getInfoid());
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
