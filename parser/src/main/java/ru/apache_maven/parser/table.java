package ru.apache_maven.parser;

import java.io.IOException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import item.*;

public class table {
	public ArrayList<Info> InfoBuilder(Element root) throws SAXException, IOException {
		ArrayList<Info> infos = new ArrayList<Info>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Info info = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			info = new Info();
			Element infoElement = (Element) firmNodes.item(i).getChildNodes().item(1);
			info.setsECRgnCD(infoElement.getAttribute("SECRgnCD"));
			info.setFirmCrdNb(infoElement.getAttribute("FirmCrdNb"));
			info.setsECNb(infoElement.getAttribute("SECNb"));
			info.setBusNm(infoElement.getAttribute("BusNm"));
			info.setLegalNm(infoElement.getAttribute("LegalNm"));
			infos.add(info);
		}
		return infos;
	}

	public ArrayList<MainAddr> MainAddrBuilder(Element root) throws SAXException, IOException {
		ArrayList<MainAddr> mainaddrs = new ArrayList<MainAddr>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		MainAddr mainaddr = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			mainaddr = new MainAddr();
			Element MainAddrElement = (Element) firmNodes.item(i).getChildNodes().item(3);
			mainaddr.setStrt1(MainAddrElement.getAttribute("Strt1"));
			mainaddr.setStrt2(MainAddrElement.getAttribute("Strt2"));
			mainaddr.setCity(MainAddrElement.getAttribute("City"));
			mainaddr.setState(MainAddrElement.getAttribute("State"));
			mainaddr.setCntry(MainAddrElement.getAttribute("Cntry"));
			mainaddr.setPostlCd(MainAddrElement.getAttribute("PostlCd"));
			mainaddr.setPhNb(MainAddrElement.getAttribute("PhNb"));
			mainaddrs.add(mainaddr);
		}
		return mainaddrs;
	}

	public ArrayList<Rgstn> RgstnBuilder(Element root) throws SAXException, IOException {
		ArrayList<Rgstn> rgstns = new ArrayList<Rgstn>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Rgstn rgstn = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			rgstn = new Rgstn();
			Element RgstnElement = (Element) firmNodes.item(i).getChildNodes().item(7);

			rgstn.setFirmType(RgstnElement.getAttribute("FirmType"));
			rgstn.setSt(RgstnElement.getAttribute("St"));
			rgstn.setDt(RgstnElement.getAttribute("Dt"));
			rgstns.add(rgstn);
		}
		return rgstns;
	}

	public ArrayList<Filing> FilingBuilder(Element root) throws SAXException, IOException {
		ArrayList<Filing> filings = new ArrayList<Filing>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Filing filing = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			filing = new Filing();
			Element FilingElement = (Element) firmNodes.item(i).getChildNodes().item(11);
			filing.setDt(FilingElement.getAttribute("FirmType"));
			filing.setFormVrsn(FilingElement.getAttribute("FormVrsn"));
			filings.add(filing);
		}
		return filings;
	}

	public ArrayList<WebAddr> WebAddrBuilder(Element root) throws SAXException, IOException {
		ArrayList<WebAddr> webAddrs = new ArrayList<WebAddr>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		WebAddr webAddr = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			webAddr = new WebAddr();
			webAddr.setEmail(firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1).getChildNodes().item(1)
					.getChildNodes().item(1).getTextContent());

			webAddrs.add(webAddr);
		}
		return webAddrs;
	}

	public ArrayList<Item1> Item1Builder(Element root) throws SAXException, IOException {
		ArrayList<Item1> items1 = new ArrayList<Item1>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Item1 item1 = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			item1 = new Item1();
			Element item1Element = (Element) firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1)
					.getChildNodes().item(1);
			item1.setQ1I(item1Element.getAttribute("Q1I"));
			item1.setQ1M(item1Element.getAttribute("Q1M"));
			item1.setQ1N(item1Element.getAttribute("Q1N"));
			item1.setQ1O(item1Element.getAttribute("Q1O"));

			items1.add(item1);
		}
		return items1;
	}

	public ArrayList<Item2A> Item2ABuilder(Element root) throws SAXException, IOException {
		ArrayList<Item2A> items2A = new ArrayList<Item2A>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Item2A item2A = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			item2A = new Item2A();
			Element item2AElement = (Element) firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1)
					.getChildNodes().item(3);
			item2A.setQ2A1(item2AElement.getAttribute("Q2A1"));
			item2A.setQ2A2(item2AElement.getAttribute("Q2A2"));
			item2A.setQ2A3(item2AElement.getAttribute("Q2A3"));
			item2A.setQ2A4(item2AElement.getAttribute("Q2A4"));
			item2A.setQ2A5(item2AElement.getAttribute("Q2A5"));
			item2A.setQ2A6(item2AElement.getAttribute("Q2A6"));
			item2A.setQ2A7(item2AElement.getAttribute("Q2A7"));
			item2A.setQ2A8(item2AElement.getAttribute("Q2A8"));
			item2A.setQ2A9(item2AElement.getAttribute("Q2A9"));
			item2A.setQ2A10(item2AElement.getAttribute("Q2A10"));
			item2A.setQ2A11(item2AElement.getAttribute("Q2A11"));
			item2A.setQ2A12(item2AElement.getAttribute("Q2A12"));
			item2A.setQ2A13(item2AElement.getAttribute("Q2A13"));

			items2A.add(item2A);
		}
		return items2A;
	}

	public ArrayList<Item2B> Item2BBuilder(Element root) throws SAXException, IOException {
		ArrayList<Item2B> items2B = new ArrayList<Item2B>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Item2B item2B = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			item2B = new Item2B();
			Element item2BElement = (Element) firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1)
					.getChildNodes().item(5);
			item2B.setQ2B1(item2BElement.getAttribute("Q2B1"));
			item2B.setQ2B2(item2BElement.getAttribute("Q2B2"));
			item2B.setQ2B3(item2BElement.getAttribute("Q2B3"));
			items2B.add(item2B);
		}
		return items2B;
	}

	public ArrayList<Item3A> Item3ABuilder(Element root) throws SAXException, IOException {
		ArrayList<Item3A> items3A = new ArrayList<Item3A>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Item3A item3A = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			item3A = new Item3A();
			Element item3AElement = (Element) firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1)
					.getChildNodes().item(7);
			item3A.setOrgFormNm(item3AElement.getAttribute("OrgFormNm"));
			items3A.add(item3A);
		}
		return items3A;
	}

	public ArrayList<Item3B> Item3BBuilder(Element root) throws SAXException, IOException {
		ArrayList<Item3B> items3B = new ArrayList<Item3B>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Item3B item3B = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			item3B = new Item3B();
			Element item3BElement = (Element) firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1)
					.getChildNodes().item(9);
			item3B.setQ3B(item3BElement.getAttribute("Q3B"));
			items3B.add(item3B);
		}
		return items3B;
	}

	public ArrayList<Item3C> Item3CBuilder(Element root) throws SAXException, IOException {
		ArrayList<Item3C> items3C = new ArrayList<Item3C>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Item3C item3C = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			item3C = new Item3C();
			Element item3BElement = (Element) firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1)
					.getChildNodes().item(11);
			item3C.setStateCD(item3BElement.getAttribute("StateCD"));
			item3C.setCntryNm(item3BElement.getAttribute("CntryNm"));
			items3C.add(item3C);
		}
		return items3C;
	}

	public ArrayList<Item5A> Item5ABuilder(Element root) throws SAXException, IOException {
		ArrayList<Item5A> items5A = new ArrayList<Item5A>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Item5A item5A = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			item5A = new Item5A();
			Element item5AElement = (Element) firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1)
					.getChildNodes().item(13);
			item5A.setTtlEmp(item5AElement.getAttribute("TtlEmp"));

			items5A.add(item5A);
		}
		return items5A;
	}

	public ArrayList<Item5D> Item5DBuilder(Element root) throws SAXException, IOException {
		ArrayList<Item5D> items5D = new ArrayList<Item5D>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Item5D item5D = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			item5D = new Item5D();
			Element item5DElement = (Element) firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1)
					.getChildNodes().item(19);
			item5D.setQ5D1A(item5DElement.getAttribute("Q5D1A"));
			item5D.setQ5D1B(item5DElement.getAttribute("Q5D1B"));
			item5D.setQ5D1C(item5DElement.getAttribute("Q5D1C"));
			item5D.setQ5D1D(item5DElement.getAttribute("Q5D1D"));
			item5D.setQ5D1E(item5DElement.getAttribute("Q5D1E"));
			item5D.setQ5D1F(item5DElement.getAttribute("Q5D1F"));
			item5D.setQ5D1G(item5DElement.getAttribute("Q5D1G"));
			item5D.setQ5D1H(item5DElement.getAttribute("Q5D1H"));
			item5D.setQ5D1I(item5DElement.getAttribute("Q5D1I"));
			item5D.setQ5D1J(item5DElement.getAttribute("Q5D1J"));
			item5D.setQ5D1K(item5DElement.getAttribute("Q5D1K"));
			item5D.setQ5D1L(item5DElement.getAttribute("Q5D1L"));
			item5D.setQ5D1M(item5DElement.getAttribute("Q5D1M"));
			item5D.setQ5D2A(item5DElement.getAttribute("Q5D2A"));
			item5D.setQ5D2B(item5DElement.getAttribute("Q5D2B"));
			item5D.setQ5D2C(item5DElement.getAttribute("Q5D2C"));
			item5D.setQ5D2D(item5DElement.getAttribute("Q5D2D"));
			item5D.setQ5D2E(item5DElement.getAttribute("Q5D2E"));
			item5D.setQ5D2F(item5DElement.getAttribute("Q5D2F"));
			item5D.setQ5D2G(item5DElement.getAttribute("Q5D2G"));
			item5D.setQ5D2H(item5DElement.getAttribute("Q5D2H"));
			item5D.setQ5D2I(item5DElement.getAttribute("Q5D2I"));
			item5D.setQ5D2J(item5DElement.getAttribute("Q5D2J"));
			item5D.setQ5D2K(item5DElement.getAttribute("Q5D2K"));
			item5D.setQ5D2L(item5DElement.getAttribute("Q5D2L"));
			item5D.setQ5D2M(item5DElement.getAttribute("Q5D2M"));
			item5D.setQ5D2MOth(item5DElement.getAttribute("Q5D2MOth"));
			items5D.add(item5D);
		}
		return items5D;
	}
}
