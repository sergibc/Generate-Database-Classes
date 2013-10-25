package com.sergibc.generator.android.generator.utils;

import com.sergibc.generator.android.generator.constants.Constants;

public class TextUtils {

	public static final String addLine(String code, String content, boolean lineEnds) {
		StringBuilder sb = new StringBuilder();
		if (code != null) {
			sb.append(code);
			sb.append(Constants.BLANK);
		}
		if (content != null) {
			sb.append(content);
			sb.append(Constants.BLANK);
		}
		if (lineEnds) {
			sb.append(Constants.END_LINE);
		}
		return sb.toString();
	}

	public static final String addLineWithValue(String code, String var, String value, boolean lineEnds) {
		StringBuilder sb = new StringBuilder();
		if (code != null) {
			sb.append(code);
			sb.append(Constants.BLANK);
		}
		if (var != null) {
			sb.append(var);
			sb.append(Constants.BLANK);
		}
		sb.append(Constants.EQUALS);
		if (value != null) {
			sb.append(Constants.CONTENT_VAR);
			sb.append(value);
			sb.append(Constants.CONTENT_VAR);
			sb.append(Constants.BLANK);
		}
		if (lineEnds) {
			sb.append(Constants.END_LINE);
		}
		return sb.toString();
	}

	public static final String addClassLineStart(String code, String content) {
		StringBuilder sb = new StringBuilder();
		if (code != null) {
			sb.append(code);
			sb.append(Constants.BLANK);
		}
		if (content != null) {
			sb.append(content);
			sb.append(Constants.BLANK);
		}
		sb.append(Constants.BRACE_START);
		sb.append(Constants.FINAL_LINE);
		return sb.toString();
	}

	public static final String addMethodLineStart(String code, String content) {
		StringBuilder sb = new StringBuilder();
		if (code != null) {
			sb.append(code);
			sb.append(Constants.BLANK);
		}
		if (content != null) {
			sb.append(content);
			sb.append(Constants.BLANK);
		}
		sb.append(Constants.BRACE_START);
		sb.append(Constants.FINAL_LINE);
		return sb.toString();
	}

	public static final String addClassMethodEnd() {
		StringBuilder sb = new StringBuilder();
		sb.append(Constants.BRACE_END);
		sb.append(Constants.FINAL_LINE);
		return sb.toString();
	}

	public static final String trimBeginning(String s) {
		String result = null;
		String[] elements = s.split(Constants.BLANK);
		for (String e : elements) {
			if (e.length() > 0 && !Constants.FINAL_LINE.equals(e)) {
				result = e;
				break;
			}
		}
		return result;
	}

}
