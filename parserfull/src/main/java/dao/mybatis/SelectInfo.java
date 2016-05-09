package dao.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.logging.Logger;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Info;

public class SelectInfo {
	public static Logger log = Logger.getLogger(SelectInfo.class.getName());

	public void SelectInfogetAll() throws IOException {
		SqlSession session = null;
		try {
			Reader reader = Resources.getResourceAsReader("Config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			session = sqlSessionFactory.openSession();

			/*
			 * List<Info> info = session.selectList("Info.getAll");
			 * 
			 * for (Info in : info) { log.info(in.getSECRgnCD() + " " +
			 * in.getFirmCrdNb() + " " + in.getSECNb() + " " + in.getLegalNm() +
			 * " " + in.getBusNm());
			 * 
			 * }
			 */
			/*
			 * Info infobyID = (Info) session.selectOne("Info.getById", 2);
			 * log.info(infobyID.getFirmCrdNb() + " " + infobyID.getBusNm());
			 */
			List<Info> info = session.selectList("Info.getStates");
			List<Integer> abc = session.selectList("Info.getCount");
			for (int i = 0; i < info.size(); i++)
				log.info(info.get(i).getLegalNm() + " " + abc.get(i).intValue());
		} finally {
			session.commit();
			session.close();
		}
	}
}
