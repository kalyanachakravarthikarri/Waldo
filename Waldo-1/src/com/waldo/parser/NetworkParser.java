package com.waldo.parser;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.waldo.datastore.EXIFContent;

/**
 * Parser to read the contents from network
 * SAX based implementation for XML content
 * @author Kalyan
 *
 */
public class NetworkParser extends DefaultHandler implements Parser {

  private URL networkStoreURL;
  private String tmpValue;
  private EXIFContent exifContent;
  private List<EXIFContent> exifContentList = new ArrayList<EXIFContent>();

  public NetworkParser() throws Exception {
    networkStoreURL = new URL("http://s3.amazonaws.com/waldo-recruiting");//TODO externalize
  }

  @Override
  public List<EXIFContent> parse() {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      SAXParser parser = factory.newSAXParser();
      parser.parse(new InputSource(networkStoreURL.openStream()), this);
    } catch (ParserConfigurationException e) {
      System.out.println("ParserConfig error");
    } catch (SAXException e) {
      System.out.println("SAXException : xml not well formed");
    } catch (IOException e) {
      System.out.println("IO error");
      e.printStackTrace();
    }

    return exifContentList;
  }

  @Override
  public void startElement(String s, String s1, String element,
      Attributes attributes) throws SAXException {

    if (element.equalsIgnoreCase("contents")) {
      exifContent = new EXIFContent();
    }
  }

  @Override
  public void endElement(String s, String s1, String element)
      throws SAXException {
    if (element.equalsIgnoreCase("contents")) {
      exifContentList.add(exifContent);
    }

    if (element.equalsIgnoreCase("key")) {
      exifContent.setKey(tmpValue);
    }

    if (element.equalsIgnoreCase("LastModified")) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
      Date date = null;
      try {
        date = sdf.parse(tmpValue);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      exifContent.setLastModified(date);
    }

    if (element.equalsIgnoreCase("Etag")) {
      exifContent.seteTag(tmpValue);
    }

    if (element.equalsIgnoreCase("Size")) {
      try {
        exifContent.setSize(Long.parseLong(tmpValue));
      } catch (NumberFormatException e) {
        // TODO: handle exception
      }
    }

    if (element.equalsIgnoreCase("StorageClass")) {
      exifContent.setStorageClass(tmpValue);
    }
  }

  @Override
  public void characters(char[] ac, int i, int j) throws SAXException {
    tmpValue = new String(ac, i, j);
  }

}
