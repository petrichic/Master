package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Firm;
import model.Info;

public interface IInfo {
	void insertInfo(ArrayList<Firm> listFirms, int size, Info info) throws SQLException, IOException;
}
