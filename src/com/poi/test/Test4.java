package com.poi.test;

/**
 * ²âÊÔÀà
 * @author thin
 *
 */
public class Test4 {
	public static void main(String[] args) {
		String ss ="\"ÄÚÈİ\"";
		String name=ss.substring(ss.indexOf("\"")+1,ss.lastIndexOf("\""));
		System.out.println(name);
	}
}
