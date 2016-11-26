package com.waldo.parser;

/**
 * Builder class for parsers.
 * @author Kalyan
 *
 */
public class ParserBuilder {

  private static Parser parser;

  public enum Type {
    NETWORK
  }

  /**
   * Return parser instance depending on the type.
   * Default implementation is Network based.
   * @param type
   * @return
   * @throws Exception
   */
  public static Parser build(Type type) throws Exception {
    parser = new NetworkParser();
    return parser;
  }
}
