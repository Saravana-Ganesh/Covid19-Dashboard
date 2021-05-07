package com.covid.utils;

public final class StringUtils {
	private StringUtils() {
		
	}
	public static String convertStringArrayToString(String...arr) {
		StringBuilder stringBuilder  = new StringBuilder();
		for(String str:arr) {
			stringBuilder.append(str+",");
		}
		stringBuilder.setLength(stringBuilder.length()-1);
		return new String(stringBuilder);		
	}
}
