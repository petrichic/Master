import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParsDom {

	public static void main(String[] args) {
		try {
			File xmlFile = new File("parserDOM.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			document.getDocumentElement().normalize();
			System.out.println("Root element: " + document.getDocumentElement().getNodeName());
			NodeList nodeList = document.getElementsByTagName(document.getDocumentElement().getChildNodes().item(1).getNodeName());// онял
			System.out.println("----------------------------");
			for (int tmp = 0; tmp < nodeList.getLength(); tmp++) {
				Node node = nodeList.item(tmp);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					System.out.println("name : " + element.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("mfr : " + element.getElementsByTagName("mfr").item(0).getTextContent());
					System.out.println("serving : " + element.getElementsByTagName("serving").item(0).getTextContent()
							+ " units : "
							+ element.getElementsByTagName("serving").item(0).getAttributes().item(0).getNodeValue());
					System.out.println("calories : " + " total : "
							+ element.getElementsByTagName("calories").item(0).getAttributes().item(1).getNodeValue()
							+ ", fat : "
							+ element.getElementsByTagName("calories").item(0).getAttributes().item(0).getNodeValue());
					System.out.println(
							"total-fat : " + element.getElementsByTagName("total-fat").item(0).getTextContent());
					System.out.println("saturated-fat : "
							+ element.getElementsByTagName("saturated-fat").item(0).getTextContent());
					System.out.println(
							"cholesterol : " + element.getElementsByTagName("cholesterol").item(0).getTextContent());
					System.out.println("sodium : " + element.getElementsByTagName("sodium").item(0).getTextContent());
					System.out.println("carb : " + element.getElementsByTagName("carb").item(0).getTextContent());
					System.out.println("fiber : " + element.getElementsByTagName("fiber").item(0).getTextContent());
					System.out.println("protein : " + element.getElementsByTagName("protein").item(0).getTextContent());
					System.out.println("vitamins : " + "a : "
							+ element.getElementsByTagName("a").item(0).getChildNodes().item(0).getTextContent()
							+ ", c : "
							+ element.getElementsByTagName("c").item(0).getChildNodes().item(0).getTextContent());
					System.out.println("minerals : " + "ca : "
							+ element.getElementsByTagName("ca").item(0).getChildNodes().item(0).getTextContent()
							+ ", fe : "
							+ element.getElementsByTagName("fe").item(0).getChildNodes().item(0).getTextContent());
					System.out.println();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
