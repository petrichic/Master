package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filing;
import model.Firm;

public interface IFiling {
	void insertFiling(ArrayList<Firm> listFirms, int size, Filing filing) throws SQLException, IOException;
}
