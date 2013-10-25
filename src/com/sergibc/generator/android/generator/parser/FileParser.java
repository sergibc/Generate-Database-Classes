package com.sergibc.generator.android.generator.parser;

import java.util.ArrayList;
import java.util.List;

import com.sergibc.generator.android.generator.constants.ParserConstants;

public class FileParser {

	private String content;
	
	int startContent = 0;

	public FileParser(String content) {
		this.content = content;
	}

	public List<String> parse() {
		List<String> tablesList = new ArrayList<String>(0);
		String table;
		while (null != (table = getTable())) {
			tablesList.add(table);
		}
		return tablesList;
	}

	private String getTable() {
		String table = null;
		try {
			System.out.println("Start content: " + startContent);
			int startTable = content.indexOf(ParserConstants.CREATE_TABLE, startContent);
			int endTable = content.indexOf(ParserConstants.END_TABLE, startContent)
					+ ParserConstants.END_TABLE.length();
			System.out.println("Start table: " + startTable + " - End table: " + endTable);
			startContent = endTable;
			table = content.substring(startTable, endTable);
			System.out.println("Table: " + table);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return table;
	}

}
