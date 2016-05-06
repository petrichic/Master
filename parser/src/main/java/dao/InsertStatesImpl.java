/*package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Firm;
import model.States;

public class InsertStatesImpl implements IStates {
	public void insertStates(ArrayList<Firm> listFirms, int a, States states) throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("States.insert", states);
		} finally {
			session.commit();
			session.close();
		}
	}
}
*/