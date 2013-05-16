package org.switchyard.adapter.example.soap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class BaseTransformerUtil {
	
	protected Element createElement(String nodeName, String child, String value) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			Element fccr = document.createElementNS("urn", nodeName);
			if (child != null) {
				Element i = document.createElement(child);
				if (value != null) {
					i.setTextContent(value);
				}
				fccr.appendChild(i);
			}
			return fccr;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected Node getNode(Element from, String nodeUri, String child) {
		if (nodeUri.equals(from.getNodeName())) {
			NodeList list = from.getChildNodes();
			for (int index = 0; index < list.getLength(); index++) {
				Node c = list.item(index);
				if (child.equals(c.getNodeName())) {
					return c;
				}
			}
		}
		return null;
	}
}
