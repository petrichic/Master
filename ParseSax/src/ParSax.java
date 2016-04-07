
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class ParSax extends DefaultHandler {
	private String currentElement = null;

	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.sun.org.apache.xerces.internal.parsers.SAXParser");
			XMLReader reader = (XMLReader) c.newInstance();
			ParSax ss = new ParSax();
			reader.setContentHandler(ss);
			reader.parse("Sax.xml");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void startElement(String uri, String local_name, String raw_name, Attributes amap) throws SAXException {
		currentElement = local_name;
		System.out.println("start " + local_name + " found ");
	}

	public void endElement(String uri, String local_name, String raw_name) throws SAXException {
		System.out.println("end " + local_name + " found");
	}

	public void startDocument() throws SAXException {
		System.out.println("start document");
	}

	public void endDocument() throws SAXException {
		System.out.println("end document");
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch, start, length);
		if (!Character.isISOControl(value.charAt(0))) {
			System.out.println("characters " + value + " found " + currentElement);
		}
	}
}