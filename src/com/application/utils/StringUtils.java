package com.application.utils;

public class StringUtils {

	public static String join(String[] list, String delimiter) {
		
		if(list == null)
			return null;
		
		if(list.length == 0)
			return "";
		
		StringBuffer sb = new StringBuffer();
		String delim = "";
		
		for(String item: list) {
			sb.append(item);
			sb.append(delim);
			delim = delimiter;
		}
		
		return sb.toString();
	}
	
	public static boolean IsNullOrEmpty(String str) {
		
		return (str == null || str.equals(""));
	}
}
