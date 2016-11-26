package com.waldo.parser;

import java.util.List;

import com.waldo.datastore.EXIFContent;

/**
 * Base interface for Parser.
 * @author Kalyan
 *
 */
public interface Parser {

  /**
   * Parse and return List of EXIFContent.
   * @return
   */
  public abstract List<EXIFContent> parse();

}
