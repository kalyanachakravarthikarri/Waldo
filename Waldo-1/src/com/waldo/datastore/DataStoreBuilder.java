package com.waldo.datastore;

/**
 * Builder class for <code>DataStore</code> instances
 * @author Kalyan
 *
 */
public class DataStoreBuilder {
  
  //Type of DataStore(currently we support map based)
  public enum Type {
    MAP_BASED
  }

  //DataStore instance
  private static DataStore dataStore;

  /**
   * Builder method for DataStore
   * @param type type of datastore
   * @param name 
   * @param marker 
   * @param maxKeys
   * @param isTruncated
   * @return
   */
  public static DataStore build(Type type, String name, String marker,
      int maxKeys, boolean isTruncated) {
    dataStore = new MapBasedDataStore(name, marker, maxKeys, isTruncated);
    return dataStore;
  }

  /**
   * Builder method for DataStore
   * This method returns <code>MapBasedDataStore</code>
   * @return
   */
  public static DataStore build() {
    dataStore = new MapBasedDataStore();
    return dataStore;
  }
}
