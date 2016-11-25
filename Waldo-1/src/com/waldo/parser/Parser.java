package com.waldo.parser;

import java.util.List;

import com.waldo.datastore.EXIFContent;

public interface Parser {

  public abstract List<EXIFContent> parse();

}
