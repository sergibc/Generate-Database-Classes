package com.sergibc.generator.android.parser;

import org.apache.commons.lang3.text.WordUtils;

import com.sergibc.generator.android.constants.Constants;
import com.sergibc.generator.android.constants.ParserConstants;
import com.sergibc.generator.android.constants.PropertyConstants;
import com.sergibc.generator.android.generator.utils.TextUtils;

public class TableParser {

	private String content;
	private StringBuilder out;

	int startContent = 0;

	public TableParser(String content) {
		this.content = content;
		this.out = new StringBuilder();
	}

	public String parse() {
		init();
		startContent = content.indexOf(ParserConstants.INIT_COLUMNS) + ParserConstants.INIT_COLUMNS.length();
		int endContent = content.indexOf(ParserConstants.END_TABLE);
		String temp = content.substring(startContent, endContent);
		String[] columns = temp.split(ParserConstants.COLUMNS_SEPARATOR);
		for (String c : columns) {
			out.append(Constants.PB_S_F_STRING);
			String columnName = TextUtils.trimBeginning(c);
			out.append(columnName.toUpperCase());
			out.append(Constants.EQUALS);
			out.append(Constants.CONTENT_VAR);
			out.append(columnName.trim());
			out.append(Constants.CONTENT_VAR);
			out.append(Constants.END_LINE);
		}
		out.append(Constants.FINAL_LINE);
		out.append(Constants.BRACE_END);
		out.append(Constants.FINAL_LINE);
		out.append(Constants.BRACE_END);
		out.append(Constants.FINAL_LINE);
		out.append(Constants.BRACE_END);
		return out.toString();
	}

	private void init() {
		// start class of table
		out.append(Constants.PB_S_F_CLASS);
		String tableName = getTableName();
		String tableClassName = getTableClassName(tableName);
		out.append(tableClassName.trim());
		out.append(PropertyConstants.TABLE_NAME_SUFIX);
		out.append(Constants.BLANK);
		out.append(Constants.BRACE_START);
		out.append(Constants.FINAL_LINE);
		// declare table var
		out.append(Constants.PB_S_F_STRING);
		out.append(PropertyConstants.TABLE_NAME_VAR);
		out.append(Constants.EQUALS);
		out.append(Constants.CONTENT_VAR);
		out.append(tableName.trim());
		out.append(Constants.CONTENT_VAR);
		out.append(Constants.END_LINE);
		// start class of columns
		out.append(Constants.PB_S_F_CLASS);
		out.append(tableClassName.trim());
		out.append(PropertyConstants.DATABASE_COLUMNS_CLASS_SUFIX);
		out.append(Constants.BLANK);
		out.append(Constants.BRACE_START);
		out.append(Constants.FINAL_LINE);
	}

	private String getTableName() {
		return content.substring(content.indexOf(ParserConstants.CREATE_TABLE) + ParserConstants.CREATE_TABLE.length(),
				content.indexOf(ParserConstants.INIT_COLUMNS));
	}
	
	private String getTableClassName(String tableName) {
		StringBuilder result = new StringBuilder();
		String[] parts = tableName.split(Constants.UNDERSCORE);
		if (parts.length > 1) {
			for (String p : parts) {
				result.append(WordUtils.capitalize(p));
			}
		} else {
			result.append(tableName);
		}
		return result.toString();
	}

}
