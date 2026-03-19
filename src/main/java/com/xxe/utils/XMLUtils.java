package com.xxe.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLUtils {

  public static Document parseXml(Object obj) throws SAXException, IOException, ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
    factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "all");
    DocumentBuilder parser = factory.newDocumentBuilder();
    Document doc;
    
    switch (obj) {
        case File file -> doc = parser.parse(file);
        case InputStream inputStream -> doc = parser.parse(inputStream);
        case Reader reader -> doc = parser.parse(new InputSource(reader));
        case String xmlPath -> doc = parser.parse(xmlPath);
        default -> throw new IllegalArgumentException("Unsupported XML source type: " + (obj.getClass().getName()));
    }
    return doc;
  }

  // private static String readAll(Reader reader) throws IOException {
  //   StringBuilder sb = new StringBuilder();
  //   char[] buffer = new char[1024];
  //   int len;
  //   while ((len = reader.read(buffer)) != -1) {
  //     sb.append(buffer, 0, len);
  //   }
  //   return sb.toString();
  // }

  // private static String stripLeadingBomAndWhitespace(String xml) {
  //   if (xml == null || xml.isEmpty()) {
  //     return xml;
  //   }

  //   int start = 0;
  //   if (xml.charAt(0) == '\uFEFF') {
  //     start = 1;
  //   }

  //   while (start < xml.length() && Character.isWhitespace(xml.charAt(start))) {
  //     start++;
  //   }

  //   return xml.substring(start);
  // }

  public static String getContentsByTagName(Document doc, String tagName) {
    NodeList nList = doc.getElementsByTagName(tagName);

    if (nList != null && nList.getLength() != 0) {
      Node node = nList.item(0);
      if (node != null) {
        return node.getTextContent().trim();
      }
    }
    return null;
  }

  public static int toInteger(String context) throws NumberFormatException {
    return Integer.parseInt(context);
  }
  
}
