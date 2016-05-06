package model;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import item.*;

public class Table{
public  ArrayList<Firm> firmsBuilder(Element root) throws SAXException, IOException {
	ArrayList<Firm> listFirms = new ArrayList<Firm>();
	NodeList firmNodes = root.getElementsByTagName("Firm");
	Firm firm = null;
	for (int i = 0; i < firmNodes.getLength(); i++) {
		firm = new Firm();
		Info info = new Info();
		Element infoElement = (Element) firmNodes.item(i).getChildNodes().item(1);
		info.setId(i + 1);
		info.setsECRgnCD(infoElement.getAttribute("SECRgnCD"));
		info.setFirmCrdNb(infoElement.getAttribute("FirmCrdNb"));
		info.setsECNb(infoElement.getAttribute("SECNb"));
		info.setBusNm(infoElement.getAttribute("BusNm"));
		info.setLegalNm(infoElement.getAttribute("LegalNm"));
		firm.setInfo(info);

		MainAddr mainaddr = new MainAddr();
		Element MainAddrElement = (Element) firmNodes.item(i).getChildNodes().item(3);
		mainaddr.setStrt1(MainAddrElement.getAttribute("Strt1"));
		mainaddr.setStrt2(MainAddrElement.getAttribute("Strt2"));
		mainaddr.setCity(MainAddrElement.getAttribute("City"));
		mainaddr.setState(MainAddrElement.getAttribute("State"));
		mainaddr.setCntry(MainAddrElement.getAttribute("Cntry"));
		mainaddr.setPostlCd(MainAddrElement.getAttribute("PostlCd"));
		mainaddr.setPhNb(MainAddrElement.getAttribute("PhNb"));
		firm.setMainaddr(mainaddr);

		Rgstn rgstn = new Rgstn();
		Element RgstnElement = (Element) firmNodes.item(i).getChildNodes().item(7);
		rgstn.setFirmType(RgstnElement.getAttribute("FirmType"));
		rgstn.setSt(RgstnElement.getAttribute("St"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String Dt = RgstnElement.getAttribute("Dt");
		try {
			rgstn.setDt(sdf.parse(Dt));
		} catch (Exception e) {
			e.printStackTrace();
		}
		firm.setRgstn(rgstn);

		Filing filing = new Filing();
		Element FilingElement = (Element) firmNodes.item(i).getChildNodes().item(11);
		String Dt1 = FilingElement.getAttribute("Dt");
		try {
			filing.setDt(sdf.parse(Dt1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/yyyy");
		String formVrsn = FilingElement.getAttribute("FormVrsn");
		try {
			filing.setFormVrsn(sdf2.parse(formVrsn));
		} catch (Exception e) {
			e.printStackTrace();
		}
		firm.setFiling(filing);

		ArrayList<States> states = new ArrayList<States>();
		States state = null;
		NoticeFiled noticefiled = new NoticeFiled();
		Node statesNode = firmNodes.item(i).getChildNodes().item(9);
		NodeList stateslist = statesNode.getChildNodes();
		for (int j = 0; j < stateslist.getLength(); j++) {
			if (stateslist.item(j).getNodeType() == Node.ELEMENT_NODE) {
				state = new States();
				Element StatesElement = (Element) stateslist.item(j);
				state.setInfoid(i + 1);
				state.setRgltrCd(StatesElement.getAttribute("RgltrCd"));
				state.setSt(StatesElement.getAttribute("St"));
				SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
				String Dt3 = StatesElement.getAttribute("Dt");
				try {
					state.setDt(sdf3.parse(Dt3));
				} catch (Exception e) {
					e.printStackTrace();
				}
				states.add(state);
			}
		}
		noticefiled.setListStates(states);
		firm.setNoticeFiled(noticefiled);
		
		WebAddr webAddr = new WebAddr();
		webAddr.setEmail(firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1).getChildNodes().item(1)
				.getChildNodes().item(1).getTextContent());
		FormInfo formInfo = new FormInfo();
		Part1A part1A = new Part1A();
		Item1 item1 = new Item1();
		WebAddrs webAddrs = new WebAddrs();
		firm.setFormInfo(formInfo);
		formInfo.setPart1A(part1A);
		part1A.setItem1(item1);
		item1.setWebAddrs(webAddrs);
		WebAddrs.setWebAddr(webAddr);

		Item1 items1 = new Item1();
		Element item1Element = (Element) firmNodes.item(i).getChildNodes().item(13).getChildNodes().item(1)
				.getChildNodes().item(3);
		items1.setQ1I(item1Element.getAttribute("Q1I"));
		items1.setQ1M(item1Element.getAttribute("Q1M"));
		items1.setQ1N(item1Element.getAttribute("Q1N"));
		items1.setQ1O(item1Element.getAttribute("Q1O"));
		firm.getFormInfo().getPart1A().setItem1(items1);

		Item2A item2A = new Item2A();
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
		firm.getFormInfo().getPart1A().setItem2A(item2A);

		/*Item2B item2B = new Item2B();
		Element item2BElement = (Element) firmNodes.item(i).getChildNodes().item(14).getChildNodes().item(1)
				.getChildNodes().item(4);
		item2B.setQ2B1(item2BElement.getAttribute("Q2B1"));
		item2B.setQ2B2(item2BElement.getAttribute("Q2B2"));
		item2B.setQ2B3(item2BElement.getAttribute("Q2B3"));
		firm.getFormInfo().getPart1A().setItem2A(item2A);
		
		Item3A item3A = new Item3A();
		Element item3AElement = (Element) firmNodes.item(i).getChildNodes().item(15).getChildNodes().item(1)
				.getChildNodes().item(3);
		item3A.setOrgFormNm(item3AElement.getAttribute("OrgFormNm"));
		firm.getFormInfo().getPart1A().setItem3A(item3A);*/

	}

	return listFirms;
}
}
/*public class table {
	public ArrayList<Info> InfoBuilder(Element root) throws SAXException, IOException {
		ArrayList<Info> infos = new ArrayList<Info>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		Info info = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			info = new Info(null, null, null, null, null);
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String Dt = FilingElement.getAttribute("Dt");
			try {
				filing.setDt(sdf.parse(Dt));
			} catch (Exception e) {
				e.printStackTrace();
			}
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/yyyy");
			String formVrsn = FilingElement.getAttribute("FormVrsn");
			try {
				filing.setFormVrsn(sdf2.parse(formVrsn));
			} catch (Exception e) {
				e.printStackTrace();
			}
			filings.add(filing);
		}
		return filings;
	}
	
	public ArrayList<States> StatesBuilder(Element root) throws SAXException, IOException {
		ArrayList<States> states = new ArrayList<States>();
		NodeList firmNodes = root.getElementsByTagName("Firm");
		States state = null;
		for (int i = 0; i < firmNodes.getLength(); i++) {
			Node nNode = firmNodes.item(i);
			NodeList firm = nNode.getChildNodes();
			Node Notice = firm.item(9);
			NodeList stateslist = Notice.getChildNodes();
			for (int j = 0; j < stateslist.getLength(); j++) {
				if (stateslist.item(j).getNodeType() == Node.ELEMENT_NODE) {
					state = new States();
					Element StatesElement = (Element) stateslist.item(j);
					state.setInfoid(i + 1);
					state.setRgltrCd(StatesElement.getAttribute("RgltrCd"));
					state.setSt(StatesElement.getAttribute("St"));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String Dt = StatesElement.getAttribute("Dt");
					try {
						state.setDt(sdf.parse(Dt));
					} catch (Exception e) {
						e.printStackTrace();
					}

					states.add(state);
				}
			}
		}
		return states;
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

}*/
