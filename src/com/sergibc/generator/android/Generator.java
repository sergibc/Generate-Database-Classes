package com.sergibc.generator.android;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.sergibc.generator.android.constants.Constants;
import com.sergibc.generator.android.constants.PropertyConstants;
import com.sergibc.generator.android.generator.utils.TextUtils;
import com.sergibc.generator.android.parser.FileParser;
import com.sergibc.generator.android.parser.TableParser;

public class Generator {

	private static final String TEMP_IN_FILE = "script.sql";
	private static final String TEMP_OUT_FILE = "";

	private static StringBuilder out = new StringBuilder();

	private void startFile() {
		out.append(TextUtils.addLine(Constants.PACKAGE, PropertyConstants.PACKAGE_DATABASE, true));
		if (Constants.TRUE.equals(PropertyConstants.IMPORT_BASE_COLUMNS)) {
			out.append(TextUtils.addLine(Constants.IMPORT, PropertyConstants.BASE_COLUMNS_IMPORT, true));
		}
		out.append(TextUtils.addClassLineStart(Constants.PB_S_F_CLASS, PropertyConstants.DATABASE_CLASS_NAME));
		out.append(TextUtils.addLineWithValue(Constants.PB_S_F_STRING, PropertyConstants.DATABASE_NAME_VAR_NAME,
				PropertyConstants.DATABAE_NAME_VAR_VALUE, true));
		out.append(TextUtils.addLineWithValue(Constants.PB_S_F_STRING, PropertyConstants.DATABASE_VERSION_VAR_NAME,
				PropertyConstants.DATABASE_VERSION_VAR_VALUE, true));
		
	}
	
	private void endFile(){
		out.append(Constants.BRACE_END);
	}

	private void doIt() {
		try {
			File file = new File(TEMP_IN_FILE);
			// FileInputStream fis = new FileInputStream(TEMP_IN_FILE);
			String contents = FileUtils.readFileToString(file);
//			System.out.println("Contents: " + contents);
			FileParser parser = new FileParser(contents);
			List<String> tablesList = parser.parse();
			for(String table : tablesList){
				TableParser  tableParser = new TableParser(table);
				String out = tableParser.parse();
				System.out.println(out);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting process...");
		Generator generator = new Generator();
//		generator.startFile();
		generator.doIt();
//		generator.endFile();
		System.out.println(out.toString());
		System.out.println("Process ended.");
	}

}
