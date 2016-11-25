Initial implementation 
The design consists of two major components Parsers and DataStore
DataStore :
---------
 DataStore is abstract super class for all the DataStore implementations. The main methods are addContent and getEXIFContent(String key)
 
 MapBasedDataStore is hashmap implementation of DataStore
 
 EXIFContent is the entity to store all the EXIF related data
 
 DataStoreBuilder provides a way to build DataStore instances

Parser
------
 Parser abstracts reading the available data and constructing entities out of it.
 
 NetworkParser is Parser implementation to read from network, the current format of data is XML.
 
 ParserBuilder provides a way to build Parser instances.

