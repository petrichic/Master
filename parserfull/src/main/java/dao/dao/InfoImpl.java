package dao.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import dao.ConnectionPoolDAO;
import dao.IInfo;
import model.Firm;
import model.Info;

public class InfoImpl implements IInfo {
	public static Logger log = Logger.getLogger(InfoImpl.class.getName());
	public void insertInfo(ArrayList<Firm> listFirms, Connection conn, int a, Info info)
			throws SQLException, IOException {
		Connection con = null;

		ConnectionPoolDAO dsc = new ConnectionPoolDAO();
		DataSource dataSource = null;
		try {
			dataSource = dsc.setupDataSource();
		} catch (FileNotFoundException e2) {
			log.info(e2.toString());
		} catch (IOException e2) {
			log.info(e2.toString());
		}

		PreparedStatement stmt;
		try {
			con = dataSource.getConnection();
			for (int i = 0; i < a; i++) {
				stmt = con.prepareStatement("Insert into mydb.info VALUES(?,?,?,?,?,?)");
				stmt.setInt(1, 0);
				stmt.setString(2, listFirms.get(i).getInfo().getSECRgnCD());
				stmt.setString(3, listFirms.get(i).getInfo().getFirmCrdNb());
				stmt.setString(4, listFirms.get(i).getInfo().getSECNb());
				stmt.setString(5, listFirms.get(i).getInfo().getBusNm());
				stmt.setString(6, listFirms.get(i).getInfo().getLegalNm());
				stmt.executeUpdate();
				int id = (int) ((com.mysql.jdbc.PreparedStatement) stmt).getLastInsertID();
				listFirms.get(i).getInfo().setInfo_id(id);
				/*for (int j = 0; j < listFirms.get(i).getFiling().getId(); j++) {
					listFirms.get(i).getFiling().get(j).setInfo_id(id);
				}
				for (int j = 0; j < listFirms.get(i).getMainaddr().getId(); j++) {
					listFirms.get(i).getMainaddr().get(j).setInfo_id(id);
				}
				for (int j = 0; j < listFirms.get(i).getRgstn().getId(); j++) {
					listFirms.get(i).getRgstn().get(j).setInfo_id(id);
				}*/
				for (int j = 0; j < listFirms.get(i).getNoticefiled().getListStates().size(); j++) {
					listFirms.get(i).getNoticefiled().getListStates().get(j).setInfo_id(id);
				}
			}
		} catch (Exception e) {
			log.info(e.toString());
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
