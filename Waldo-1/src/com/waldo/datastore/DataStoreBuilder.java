package com.waldo.datastore;

public class DataStoreBuilder {
  public enum Type {
    MAP_BASED
  }

  private static DataStore dataStore;

  public static DataStore build(Type type, String name, String marker,
      int maxKeys, boolean isTruncated) {
    dataStore = new MapBasedDataStore(name, marker, maxKeys, isTruncated);
    return dataStore;
  }

  public static DataStore build() {
    dataStore = new MapBasedDataStore();
    return dataStore;
  }

  public static void addContent(EXIFContent content) {
    dataStore.addContent(content);
  }

  public EXIFContent getEXIFContent(String key) {
    return dataStore.getEXIFContent(key);
  }

}
