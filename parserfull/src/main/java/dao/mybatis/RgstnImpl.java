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

import dao.IRgstn;
import model.Firm;
import model.Rgstn;

public class RgstnImpl implements IRgstn{
	public void insertRgstn(ArrayList<Firm> listFirms, Connection conn, int a, Rgstn rgstn)
			throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("Rgstn.insert", rgstn);
		} finally {
			session.commit();
			session.close();
		}
	}
}
