/*package dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Firm;
import model.Info;

public class InsertInfoImpl implements IInfo {

	public void insertInfo(ArrayList<Firm> listFirms, int a, Info info) throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("config.xml");

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("Info.insert", listFirms.get(a).getInfo());

		} finally {
			session.commit();
			session.close();
		}
	}

}*/