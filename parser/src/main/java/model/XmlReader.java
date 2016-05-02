package model;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import dao.*;
import item.*;
 
public class XmlReader {
 
    public static void main(String[] args) {
    	try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document document = db.parse("src/main/resources/IA_FIRM_SEC_Feed_01_25_2016.xml");

			Element root = document.getDocumentElement();
			table ob = new table();
			ArrayList<Info> infos = ob.InfoBuilder(root);
			ArrayList<MainAddr> mainaddrs = ob.MainAddrBuilder(root);
			ArrayList<Rgstn> rgstns = ob.RgstnBuilder(root);
			ArrayList<Filing> filings = ob.FilingBuilder(root);
			ArrayList<WebAddr> webaddrs = ob.WebAddrBuilder(root);
			ArrayList<Item1> items1 = ob.Item1Builder(root);
			ArrayList<Item2A> items2A = ob.Item2ABuilder(root);
			ArrayList<Item2B> items2B = ob.Item2BBuilder(root);
			ArrayList<Item3A> items3A = ob.Item3ABuilder(root);
			ArrayList<States> states = ob.StatesBuilder(root);

			InsertInfoDAO insertinfodao = new InsertInfoDAO();
			insertinfodao.InsertInfo(infos);
			InsertMainAddrDAO insertMainAddr = new InsertMainAddrDAO();
			insertMainAddr.InsertMainAddr(mainaddrs);
			InsertRgstnDAO insertRgstnDAO = new InsertRgstnDAO();
			insertRgstnDAO.InsertRgstn(rgstns);
			InsertFilingDAO insertFilingDAO = new InsertFilingDAO();
			insertFilingDAO.insertFiling(filings);
			InsertWebAddrDAO insertWebAddr = new InsertWebAddrDAO();
			insertWebAddr.insertWebAddr(webaddrs);
			InsertItem1DAO insertItem1DAO = new InsertItem1DAO();
			insertItem1DAO.insertItem1(items1);
			InsertItem2ADAO insertItem2ADAO = new InsertItem2ADAO();
			insertItem2ADAO.insertItem2A(items2A);
			InsertItem2BDAO insertItem2BDAO = new InsertItem2BDAO();
			insertItem2BDAO.insertItem2B(items2B);
			InsertItem3ADAO insertItem3ADAO = new InsertItem3ADAO();
			insertItem3ADAO.insertItem3A(items3A);
			InsertStatesDAO insertStatesDAO = new InsertStatesDAO();
			insertStatesDAO.insertStates(states);

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}