package com.waldo.datastore;

import java.util.Date;

/**
 * POJO to store EXIF content
 * 
 * @author Kalyan
 * 
 */
public class EXIFContent {

  private String key;
  private Date lastModified;
  private String eTag;
  private long size;
  private String storageClass;

  // getters and setters
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Date getLastModified() {
    return lastModified;
  }

  public void setLastModified(Date lastModified) {
    this.lastModified = lastModified;
  }

  public String geteTag() {
    return eTag;
  }

  public void seteTag(String eTag) {
    this.eTag = eTag;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public String getStorageClass() {
    return storageClass;
  }

  public void setStorageClass(String storageClass) {
    this.storageClass = storageClass;
  }

  @Override
  public String toString() {
    return key + " - " + eTag + " - " + lastModified + " - " + storageClass;
  }

}
