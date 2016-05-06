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
import model.MainAddr;


public class InsertMainAddrDAO implements IMainAddr{
	public void insertMainAddr(ArrayList<Firm> listFirms, int size, MainAddr mainAddr)
			throws SQLException, IOException {
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
	
				for (int i = 0; i < size; i++) {
					stmt2 = con.prepareStatement("Insert into mydb.mainaddr VALUES(?,?,?,?,?,?,?,?,?)");
					stmt2.setInt(1, 0);
					stmt2.setString(2, listFirms.get(i).getMainaddr().getStrt1());
					stmt2.setString(3, listFirms.get(i).getMainaddr().getStrt2());
					stmt2.setString(4, listFirms.get(i).getMainaddr().getCity());
					stmt2.setString(5, listFirms.get(i).getMainaddr().getState());
					stmt2.setString(6, listFirms.get(i).getMainaddr().getCntry());
					stmt2.setString(7, listFirms.get(i).getMainaddr().getPostlCd());
					stmt2.setString(8, listFirms.get(i).getMainaddr().getPhNb());
					stmt2.setInt(9, listFirms.get(i).getMainaddr().getInfo_id());
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