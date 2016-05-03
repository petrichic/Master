package model;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

 
public class XmlReader {
 
    public static IAPDFirmSECReport main(String[] args) {
    	IAPDFirmSECReport iAPDFirmSECReport = new IAPDFirmSECReport();
		Firms firms1 = new Firms();
    	try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document document = db.parse("src/main/resources/IA_FIRM_SEC_Feed_01_25_2016.xml");

			Element root = document.getDocumentElement();
			Table ob = new Table();
			ArrayList<Firm> firms = ob.firmsBuilder(root);
			firms1.setListFirms(firms);
			iAPDFirmSECReport.setFirms(firms1);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return iAPDFirmSECReport;
    }
 
}