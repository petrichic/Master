package dao.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao.IStates;
import model.Firm;
import model.States;

public class StatesImpl implements IStates {
	public void insertStates(ArrayList<Firm> listFirms, Connection conn, int a, ArrayList<States> listStates)
			throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("States.insert", listStates);
		} finally {
			session.commit();
			session.close();
		}
	}
}
