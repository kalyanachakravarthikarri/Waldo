package com.waldo;

import java.util.List;

import com.waldo.datastore.DataStore;
import com.waldo.datastore.DataStoreBuilder;
import com.waldo.datastore.EXIFContent;
import com.waldo.parser.Parser;
import com.waldo.parser.ParserBuilder;
import com.waldo.parser.ParserBuilder.Type;

public class Main {

  public static void main(String[] args) {
//    System.setProperty("http.proxyHost", "host");
//    System.setProperty("http.proxyPort", "port");
    List<EXIFContent> exifContents = null;
    try {
      Parser networkParser = ParserBuilder.build(Type.NETWORK);
      exifContents = networkParser.parse();
    } catch (Exception e) {
      System.out.println("Invalid parser, Unable to continue..");
      e.printStackTrace();
      System.exit(0);
    }
    DataStore mapBasedDataStore = DataStoreBuilder.build();
    for (EXIFContent content : exifContents) {
      // System.out.println(content);
      mapBasedDataStore.addContent(content);
    }

    System.out
        .println(mapBasedDataStore
            .getEXIFContent("0003b8d6-d2d8-4436-a398-eab8d696f0f9.68cccdd4-e431-457d-8812-99ab561bf867.jpg"));

  }
}
