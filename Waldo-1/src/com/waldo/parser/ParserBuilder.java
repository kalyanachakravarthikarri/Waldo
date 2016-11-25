package com.waldo.parser;

public class ParserBuilder {

  private static Parser parser;

  public enum Type {
    NETWORK
  }

  public static Parser build(Type type) throws Exception {
    parser = new NetworkParser();
    return parser;
  }
}
