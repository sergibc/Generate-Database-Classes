package com.sergibc.generator.android.constants;

/**
 * Constants that should be in a properties file
 * 
 * @author sergibc
 * 
 */
public interface PropertyConstants {

	public static final String PACKAGE_DATABASE = "com.sergibc.project.core.db";
	public static final String BASE_COLUMNS_IMPORT = "android.provider.BaseColumns";
	public static final String BASE_COLUMNS_EXTENDS = "extends BaseColumns";
	public static final String IMPORT_BASE_COLUMNS = "true";
	public static final String DATABASE_CLASS_NAME = "DatabaseContract";
	public static final String DATABASE_NAME_VAR_NAME = "DATABASE_NAME";
	public static final String DATABAE_NAME_VAR_VALUE = "database.db";
	public static final String DATABASE_VERSION_VAR_NAME = "DATABASE_VERSION";
	public static final String DATABASE_VERSION_VAR_VALUE = "1";
	public static final String TABLE_NAME_SUFIX = "Table";
	public static final String TABLE_NAME_VAR = "TABLE_NAME";
	public static final String DATABASE_COLUMNS_CLASS_SUFIX = "Columns";

	public static final String CURSOR_NAME_SUFIX = "Cursor";
	public static final String CURSOR_COLUMNS_CLASS_SUFIX = "Columns";
}
