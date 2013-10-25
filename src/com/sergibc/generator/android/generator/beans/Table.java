package com.sergibc.generator.android.generator.beans;

import java.util.List;

import org.apache.commons.lang3.text.WordUtils;

import com.sergibc.generator.android.generator.constants.PropertyConstants;

public class Table {

	private String name;
	private String className;
	private String varName;
	private String columnsName;
	private boolean extendsBaseColumns;
	private List<String> columnsList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		String cn = WordUtils.capitalize(name);
		StringBuilder sb = new StringBuilder(cn);
		sb.append(PropertyConstants.TABLE_NAME_SUFIX);
		className = sb.toString().trim();
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}

	public String getColumnsName() {
		String cn = WordUtils.capitalize(name);
		StringBuilder sb = new StringBuilder(cn);
		sb.append(PropertyConstants.DATABASE_COLUMNS_CLASS_SUFIX);
		columnsName = sb.toString().trim();
		return columnsName;
	}

	public void setColumnsName(String columnsName) {
		this.columnsName = columnsName;
	}

	public boolean isExtendsBaseColumns() {
		return extendsBaseColumns;
	}

	public void setExtendsBaseColumns(boolean extendsBaseColumns) {
		this.extendsBaseColumns = extendsBaseColumns;
	}

	public List<String> getColumnsList() {
		return columnsList;
	}

	public void setColumnsList(List<String> columnsList) {
		this.columnsList = columnsList;
	}

}
