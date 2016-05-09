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

import dao.IFiling;
import model.Filing;
import model.Firm;

public class FilingImpl implements IFiling {

	public void insertFiling(ArrayList<Firm> listFirms, Connection conn, int a, Filing filing)
			throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("Filing.insert", filing);
		} finally {
			session.commit();
			session.close();
		}
	}
}
