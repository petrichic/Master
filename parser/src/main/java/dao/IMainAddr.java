package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Firm;
import model.MainAddr;

public interface IMainAddr {
	void insertMainAddr(ArrayList<Firm> listFirms, int size, MainAddr mainAddr) throws SQLException, IOException;
}
