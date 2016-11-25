package com.waldo.datastore;

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name + " - " + marker + " - " + maxKeys + " - " + isTruncated;
  }

  public String getMarker() {
    return marker;
  }

  public void setMarker(String marker) {
    this.marker = marker;
  }

  public int getMaxKeys() {
    return maxKeys;
  }

  public void setMaxKeys(int maxKeys) {
    this.maxKeys = maxKeys;
  }

  public boolean isTruncated() {
    return isTruncated;
  }

  public void setTruncated(boolean isTruncated) {
    this.isTruncated = isTruncated;
  }

  public abstract void addContent(EXIFContent content);

  public abstract EXIFContent getEXIFContent(String key);

}
