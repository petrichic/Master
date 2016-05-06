package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Firm;
import model.Rgstn;

public interface IRgstn {
	void insertRgstn(ArrayList<Firm> listFirms, int size, Rgstn rgstn) throws SQLException, IOException;
}
