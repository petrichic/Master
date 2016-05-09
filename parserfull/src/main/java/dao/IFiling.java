package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filing;
import model.Firm;

public interface IFiling {
	void insertFiling(ArrayList<Firm> listFirms, Connection conn, int a, Filing filing) throws SQLException, IOException;
}