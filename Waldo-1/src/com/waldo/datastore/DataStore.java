package com.waldo.datastore;

/**
 * Base class for all the datastores
 * @author Kalyan
 *
 */
public abstract class DataStore {

  private String name;
  private String marker;
  private int maxKeys;
  private boolean isTruncated;

  public DataStore(String name, String marker, int maxKeys, boolean isTruncated) {
    super();
    this.name = name;
    this.marker = marker;
    this.maxKeys = maxKeys;
    this.isTruncated = isTruncated;
  }

  public DataStore() {
  }

  /**
   * Getter method for name property
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter method for name property
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter method for marker property
   * @return marker
   */
  public String getMarker() {
    return marker;
  }

  /**
   * Setter method for marker property
   * @param marker
   */
  public void setMarker(String marker) {
    this.marker = marker;
  }

  /**
   * Getter method for maxKeys
   * @return maxKeys
   */
  public int getMaxKeys() {
    return maxKeys;
  }

  /**
   * Setter method for maxKeys
   * @param maxKeys
   */
  public void setMaxKeys(int maxKeys) {
    this.maxKeys = maxKeys;
  }

  /**
   * Getter method for truncated field
   * @return
   */
  public boolean isTruncated() {
    return isTruncated;
  }

  /**
   * Setter method for truncated field
   * @param isTruncated
   */
  public void setTruncated(boolean isTruncated) {
    this.isTruncated = isTruncated;
  }

  /**
   * Add content to the datastore
   * @param content
   */
  public abstract void addContent(EXIFContent content);

  /**
   * Retrieve the content for given key
   * @param key
   * @return
   */
  public abstract EXIFContent getEXIFContent(String key);
  

  @Override
  public String toString() {
    return name + " - " + marker + " - " + maxKeys + " - " + isTruncated;
  }

}
