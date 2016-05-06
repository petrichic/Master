package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Filing;
import model.Firm;

public class InsertFilingImpl implements IFiling {
	public void insertFiling(ArrayList<Firm> listFirms, int a, Filing filing) throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
		} finally {
			session.commit();
			session.close();
		}
	}
}
