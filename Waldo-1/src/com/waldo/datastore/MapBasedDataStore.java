package com.waldo.datastore;

import java.util.HashMap;
import java.util.Map;

/**
 * Map based implementation to store EXIF content.
 * 
 * @author Kalyan
 * 
 */
public class MapBasedDataStore extends DataStore {

  /*
   * Map to store the data
   */
  private static Map<String, EXIFContent> dataStore = new HashMap<String, EXIFContent>();

  public MapBasedDataStore(String name, String marker, int maxKeys,
      boolean isTruncated) {
    super(name, marker, maxKeys, isTruncated);

  }

  public MapBasedDataStore() {
  }

  /**
   * Implementation for addContent method.
   */
  @Override
  public synchronized void addContent(EXIFContent content) {
    dataStore.put(content.getKey(), content);
  }

  /**
   * Implementation for getEXIFContent method.
   */
  @Override
  public EXIFContent getEXIFContent(String key) {
    return dataStore.get(key);
  }

}
