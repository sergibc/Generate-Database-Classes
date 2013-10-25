package com.sergibc.generator.android.generator.constants;

public interface ParserConstants {
	
	public static final String CREATE_TABLE = "CREATE TABLE";
	public static final String INIT_COLUMNS = "(";
	public static final String END_TABLE = ");";
	public static final String COLUMNS_SEPARATOR = ",";
	
	public static final String TYPE_TEXT = "TEXT";
	public static final String TYPE_INT = "INTEGER";
	public static final String TYPE_REAL = "REAL";
	public static final String[] TYPES = {TYPE_TEXT, TYPE_INT, TYPE_REAL};
	
	public static final String PRIMARY_KEY = "PRIMARY KEY";
	public static final String AUTOINCREMENT = "AUTOINCREMENT";

}
