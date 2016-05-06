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
import model.States;


public class InsertStatesDAO implements IStates{
	public void insertStates(ArrayList<Firm> listFirms, int size, States states) throws SQLException, IOException {
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
				for (int j = 0; j < listFirms.get(i).getNoticeFiled().getListStates()
						.size(); j++) {
					stmt = con.prepareStatement("Insert into mydb.states VALUES(?,?,?,?,?)");
					stmt.setInt(1, 0);
					stmt.setString(2, listFirms.get(i).getNoticeFiled().getListStates().get(j).getRgltrCd());
					stmt.setString(3, listFirms.get(i).getNoticeFiled().getListStates().get(j).getSt());
					Date Dt = new Date(listFirms.get(i).getNoticeFiled().getListStates().get(j).getDt().getTime());
					stmt.setDate(4, Dt);
					stmt.setInt(5, listFirms.get(i).getNoticeFiled().getListStates().get(j).getInfoid());
					stmt.executeUpdate();
				}
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
