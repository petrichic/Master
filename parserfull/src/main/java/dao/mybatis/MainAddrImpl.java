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

import dao.IMainAddr;
import model.Firm;
import model.MainAddr;;

public class MainAddrImpl implements IMainAddr {
	public void insertMainAddr(ArrayList<Firm> listFirms, Connection conn, int a, MainAddr mainAddr)
			throws SQLException, IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("MainAddr.insert", mainAddr);
		} finally {
			session.commit();
			session.close();
		}
	}
}
