package ExecuteParser;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.mybatis.FilingImpl;
import dao.mybatis.InfoImpl;
import dao.mybatis.MainAddrImpl;
import dao.mybatis.RgstnImpl;
import dao.mybatis.StatesImpl;
import model.Firm;
import model.Firms;

public class MyBatis {
	public ArrayList<Firm> listFirms = null;
	public Connection conn = null;
	
	public void insertInfo(Firms firms, int a) throws IOException,SQLException {
		InfoImpl mbf = new InfoImpl();
		for (int i = 0; i < a; i++) {
			mbf.insertInfo(listFirms, conn, a, firms.getListFirms().get(i).getInfo());
		}
	}
	public void insertFiling(Firms firms, int a) throws IOException,SQLException {
		FilingImpl mbf = new FilingImpl();
		for (int i = 0; i < a; i++) {
			mbf.insertFiling(listFirms, conn, a, firms.getListFirms().get(i).getFiling());
		}
	}
	public void insertMainAddr(Firms firms, int a) throws IOException,SQLException {
		MainAddrImpl mbf = new MainAddrImpl();
		for (int i = 0; i < a; i++) {
			mbf.insertMainAddr(listFirms, conn, a, firms.getListFirms().get(i).getMainaddr());
		}
	}
	public void insertRgstn(Firms firms, int a) throws IOException,SQLException {
		RgstnImpl mbf = new RgstnImpl();
		for (int i = 0; i < a; i++) {
			mbf.insertRgstn(listFirms, conn, a, firms.getListFirms().get(i).getRgstn());
		}
	}
	public void insertStates(Firms firms, int a) throws IOException,SQLException {
		StatesImpl mbf = new StatesImpl();
		for (int i = 0; i < a; i++) {
			mbf.insertStates(listFirms, conn, a, firms.getListFirms().get(i).getNoticefiled().getListStates());
		}
	}
}
