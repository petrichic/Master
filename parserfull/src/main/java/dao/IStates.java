package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Firm;
import model.States;

public interface IStates {
	void insertStates(ArrayList<Firm> listFirms, Connection conn, int a, ArrayList<States> listStates) throws SQLException, IOException;

}
