package com.cji.exam.demo.util;

public class Utility {
	public static boolean empty(Object obj) {
		if(obj == null) {
			return true;
		}
//		if(obj instanceof String == false) {
//			return true;
//		}
		return false;
	}

	public static String f(String format, Object...args) {
		return String.format(format, args);
	}
	
}
