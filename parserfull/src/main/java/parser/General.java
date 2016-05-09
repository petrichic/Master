package parser;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;

import model.*;
import dao.mybatis.SelectInfo;
import dao.dao.*;


public class General {
	public static void main(String[] args) throws IOException, SQLException {
		try {
			File file = new File("src//main/resources/IA_FIRM_SEC_Feed_01_25_2016.xml");
			//JaxB parser = new JaxB();
			Dom parser = new Dom();
			IAPDFirmSECReport iAPDFirmSECReport = (IAPDFirmSECReport) parser.getObject(file, IAPDFirmSECReport.class);
			int a = 50;
			//dao import dao.dao.*
			InfoImpl insertinfoDAO = new InfoImpl();		
			insertinfoDAO.insertInfo(iAPDFirmSECReport.getFirms().getListFirms(),null, a, null);
			MainAddrImpl insertMainAddrDAO = new MainAddrImpl();
			insertMainAddrDAO.insertMainAddr(iAPDFirmSECReport.getFirms().getListFirms(), null, a, null);
			FilingImpl insertFilingDAO = new FilingImpl();
			insertFilingDAO.insertFiling(iAPDFirmSECReport.getFirms().getListFirms(), null, a, null);
			RgstnImpl insertRgstnDAO = new RgstnImpl();
			insertRgstnDAO.insertRgstn(iAPDFirmSECReport.getFirms().getListFirms(), null, a, null);
			StatesImpl insertStatesDAO = new StatesImpl();
			insertStatesDAO.insertStates(iAPDFirmSECReport.getFirms().getListFirms(), null, a, null);
			
			/*InsertInfoImpl iii = new InsertInfoImpl();
			InsertMainAddrImpl imi = new InsertMainAddrImpl();
			InsertFilingImpl ifi = new InsertFilingImpl();
			InsertRgstnImpl iri = new InsertRgstnImpl();
			InsertStatesImpl isi = new InsertStatesImpl();		
			for (int i = 0; i<a; i++){
				iii.insertInfo(iAPDFirmSECReport.getFirms().getListFirms(), a, iAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo());
				iAPDFirmSECReport.getFirms().getListFirms().get(i).getMainaddr().setInfo_id(iAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getInfo_id());
				iAPDFirmSECReport.getFirms().getListFirms().get(i).getFiling().setInfo_id(iAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getInfo_id());
				iAPDFirmSECReport.getFirms().getListFirms().get(i).getRgstn().setInfo_id(iAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getInfo_id());
				imi.insertMainAddr(iAPDFirmSECReport.getFirms().getListFirms(), a, iAPDFirmSECReport.getFirms().getListFirms().get(i).getMainaddr());
				ifi.insertFiling(iAPDFirmSECReport.getFirms().getListFirms(), a, iAPDFirmSECReport.getFirms().getListFirms().get(i).getFiling());
				iri.insertRgstn(iAPDFirmSECReport.getFirms().getListFirms(), a, iAPDFirmSECReport.getFirms().getListFirms().get(i).getRgstn());
				for(int j = 0; j< iAPDFirmSECReport.getFirms().getListFirms().get(i).getNoticefiled().getListStates().size(); j++ ){
					iAPDFirmSECReport.getFirms().getListFirms().get(i).getNoticefiled().getListStates().get(j).setInfoid(iAPDFirmSECReport.getFirms().getListFirms().get(i).getInfo().getInfo_id());
					isi.insertStates(iAPDFirmSECReport.getFirms().getListFirms(), a, iAPDFirmSECReport.getFirms().getListFirms().get(i).getNoticefiled().getListStates().get(j));
				}
			}*/
						
			SelectInfo selectinfo = new SelectInfo();
			selectinfo.SelectInfogetAll();
		} catch (JAXBException ex) {
			Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}