/*package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Firm;
import model.MainAddr;;

public class InsertMainAddrImpl implements IMainAddr {
	public void insertMainAddr(ArrayList<Firm> listFirms, int a, MainAddr mainAddr) throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();
			session.insert("MainAddr.insert", mainAddr);
		} finally {
			session.commit();
			session.close();
		}
	}
}
*/