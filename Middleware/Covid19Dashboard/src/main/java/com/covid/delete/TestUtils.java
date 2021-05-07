package com.covid.delete;

import com.covid.utils.StringUtils;

public class TestUtils {

	public static void main(String[] args) {
		String[] str = {"Thirumala Balaji","Saravana Ganesh","Legend","Govindha","Srini"};
		System.out.println(str.length);
		System.out.println(StringUtils.convertStringArrayToString(str));
	}

}
