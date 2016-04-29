package ru.apache_maven.parser;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import item.*;
 
public class XmlReader {
 
    public static void main(String[] args) {
    	//DAO.Insertinto();
    	try {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document document = db.parse("src/main/resources/test_ng_full.xml");

			System.out.println("Root element: " + document.getDocumentElement().getNodeName());
			System.out.println("Value: " + document.getElementsByTagName("IAPDFirmSECReport").item(0).getAttributes()
					.item(0).getNodeValue());
			System.out.println(document.getDocumentElement().getChildNodes().item(1).getNodeName());
			Element root = document.getDocumentElement();
			table table = new table();
			ArrayList<Info> infos = table.InfoBuilder(root);
			ArrayList<MainAddr> mainaddrs = table.MainAddrBuilder(root);
			ArrayList<Rgstn> rgstns = table.RgstnBuilder(root);
			ArrayList<Filing> filings = table.FilingBuilder(root);
			ArrayList<WebAddr> webAddrs = table.WebAddrBuilder(root);
			ArrayList<Item5D> items5D = table.Item5DBuilder(root);
			ArrayList<Item1> items1 = table.Item1Builder(root);
			ArrayList<Item2A> items2A = table.Item2ABuilder(root);
			ArrayList<Item2B> items2B = table.Item2BBuilder(root);
			ArrayList<Item3A> items3A = table.Item3ABuilder(root);
			ArrayList<Item3B> items3B = table.Item3BBuilder(root);
			ArrayList<Item3C> items3C = table.Item3CBuilder(root);
			ArrayList<Item5A> items5A = table.Item5ABuilder(root);
			//ArrayList<States> states = table.StatesBuilder(root);
			for (int i = 0; i < infos.size(); i++) {
				System.out.println("\t"
						+ document.getDocumentElement().getChildNodes().item(1).getChildNodes().item(1).getNodeName());
				System.out.println(infos.get(i));
				System.out.println(mainaddrs.get(i));
				System.out.println(rgstns.get(i));
				System.out.println(filings.get(i));
				System.out.println(webAddrs.get(i));
				System.out.println(items5A.get(i));
				System.out.println(items5D.get(i));
				System.out.println(items1.get(i));
				System.out.println(items2A.get(i));
				System.out.println(items2B.get(i));
				System.out.println(items3A.get(i));
				System.out.println(items3B.get(i));
				System.out.println(items3C.get(i));
			}
			InsertInfoDAO insertinfodao = new InsertInfoDAO();
			insertinfodao.InsertInfo(infos);
			InsertMainAddrDAO insertMainAddr = new InsertMainAddrDAO();
			insertMainAddr.InsertMainAddr(mainaddrs);
			InsertRgstnDAO insertRgstnDAO = new InsertRgstnDAO();
			insertRgstnDAO.InsertRgstn(rgstns);

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}








/*import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import item.*;
 
public class XmlReader {
 
    private static Info getinfo(Node node) throws SAXException, IOException {
        Info info = new Info();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            info.setsECRgnCD(getTagValue("sECRgnCD", element));
            info.setFirmCrdNb(getTagValue("FirmCrdNb", element));
            info.setsECNb(getTagValue("sECNb", element));
            info.setBusNm(getTagValue("BusNm", element));
            info.setLegalNm(getTagValue("LegalNm", element));
        }
 
        return info;
    }
    
    private static MainAddr getmainaddr(Node node) throws SAXException, IOException{
    	MainAddr mainaddr = new MainAddr();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            mainaddr.setStrt1(getTagValue("Strt1", element));
            mainaddr.setStrt2(getTagValue("Strt2", element));
            mainaddr.setCity(getTagValue("City", element));
            mainaddr.setState(getTagValue("State", element));
            mainaddr.setCntry(getTagValue("Cntry", element));
            mainaddr.setPostlCd(getTagValue("PostlCd", element));
            mainaddr.setPhNb(getTagValue("PhNb", element));
        }
 
        return mainaddr;
    }
    
    private static Rgstn getRgstn(Node node) throws SAXException, IOException{
    	Rgstn rgstn = new Rgstn();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            rgstn.setFirmType(getTagValue("FirmType", element));
            rgstn.setSt(getTagValue("St", element));
            rgstn.setDt(getTagValue("Dt", element));
        }
 
        return rgstn;
    }

    private static Filing getFiling(Node node) throws SAXException, IOException{
    	Filing filing = new Filing();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            filing.setDt(getTagValue("Dt", element));
            filing.setFormVrsn(getTagValue("FormVrsn", element));
        }
 
        return filing;
    }
    
    private static States getStates(Node node) throws SAXException, IOException{
    	States states = new States();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            states.setRgltrCd(getTagValue("RgltrCd", element));
            states.setSt(getTagValue("St", element));
            states.setDt(getTagValue("Dt", element));
        }
 
        return states;
    }
    
    private static Item1 getitem1(Node node) throws SAXException, IOException{
    	Item1 item1 = new Item1();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            item1.setQ1I(getTagValue("Q1I", element));
            item1.setQ1M(getTagValue("Q1M", element));
            item1.setQ1N(getTagValue("Q1N", element));
            item1.setQ1O(getTagValue("Q1O", element));
        }
 
        return item1;
    }
    
    private static WebAddr getwebaddr(Node node) throws SAXException, IOException{
    	WebAddr webaddr = new WebAddr();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            webaddr.setEmail(getTagValue("Email", element));
        }
 
        return webaddr;
    }
    
    private static Item2A getitem2a(Node node) throws SAXException, IOException{
    	Item2A item2a = new Item2A();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            item2a.setQ2A1(getTagValue("Q2A1", element));
            item2a.setQ2A2(getTagValue("Q2A2", element));
            item2a.setQ2A3(getTagValue("Q2A3", element));
            item2a.setQ2A4(getTagValue("Q2A4", element));
            item2a.setQ2A5(getTagValue("Q2A5", element));
            item2a.setQ2A6(getTagValue("Q2A6", element));
            item2a.setQ2A7(getTagValue("Q2A7", element));
            item2a.setQ2A8(getTagValue("Q2A8", element));
            item2a.setQ2A9(getTagValue("Q2A9", element));
            item2a.setQ2A10(getTagValue("Q2A10", element));
            item2a.setQ2A11(getTagValue("Q2A11", element));
            item2a.setQ2A12(getTagValue("Q2A12", element));
            item2a.setQ2A13(getTagValue("Q2A13", element));
        }
 
        return item2a;
    }
    
    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
 
    public static void main(String[] args) {
        String filepath = "src/main/resources/IA_FIRM_SEC_Feed_01_25_2016.xml";
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
			System.out.println("Current element: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("Firm");
            List<Info> infoList = new ArrayList<Info>();
            for (int i = 0; i < nodeList.getLength(); i++) {
            	infoList.add(getinfo(nodeList.item(i)));
            }

            for (Info info : infoList) {
                System.out.println(info.toString());
            }
            
            List<MainAddr> mainaddrList = new ArrayList<MainAddr>();
            for (int i = 0; i < nodeList.getLength(); i++) {
            	mainaddrList.add(getmainaddr(nodeList.item(i)));
            }

            for (MainAddr mainaddr : mainaddrList) {
                System.out.println(mainaddr.toString());
            }
            
            List<Rgstn> rgstnList = new ArrayList<Rgstn>();
            for (int i = 0; i < nodeList.getLength(); i++) {
            	rgstnList.add(getRgstn(nodeList.item(i)));
            }

            for (Rgstn rgstn : rgstnList) {
                System.out.println(rgstn.toString());
            }
            
            List<States> statesList = new ArrayList<States>();
            for (int i = 0; i < nodeList.getLength(); i++) {
            	statesList.add(getStates(nodeList.item(i)));
            }

            for (States states : statesList) {
                System.out.println(states.toString());
            }
            
            List<Filing> filingList = new ArrayList<Filing>();
            for (int i = 0; i < nodeList.getLength(); i++) {
            	filingList.add(getFiling(nodeList.item(i)));
            }

            for (Filing filing : filingList) {
                System.out.println(filing.toString());
            }
            
            List<Item1> item1List = new ArrayList<Item1>();
            for (int i = 0; i < nodeList.getLength(); i++) {
            	item1List.add(getitem1(nodeList.item(i)));
            }

            for (Item1 item1 : item1List) {
                System.out.println(item1.toString());
            }
            
            List<WebAddr> webaddr1List = new ArrayList<WebAddr>();
            for (int i = 0; i < nodeList.getLength(); i++) {
            	webaddr1List.add(getwebaddr(nodeList.item(i)));
            }

            for (WebAddr webaddr : webaddr1List) {
                System.out.println(webaddr.toString());
            }
            
            List<Item2A> item2aList = new ArrayList<Item2A>();
            for (int i = 0; i < nodeList.getLength(); i++) {
            	item2aList.add(getitem2a(nodeList.item(i)));
            }

            for (Item2A item2a : item2aList) {
                System.out.println(item2a.toString());
            }
            
        } catch (Exception exc) {
            exc.printStackTrace();
        }
 
    }

}*/