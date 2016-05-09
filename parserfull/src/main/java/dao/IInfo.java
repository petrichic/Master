package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Firm;
import model.Info;

public interface IInfo {
	void insertInfo(ArrayList<Firm> listFirms, Connection conn, int a, Info info) throws SQLException, IOException;
}
