package com.poi.test;

/**
 * ������
 * @author thin
 *
 */
public class Test4 {
	public static void main(String[] args) {
		String ss ="\"����\"";
		String name=ss.substring(ss.indexOf("\"")+1,ss.lastIndexOf("\""));
		System.out.println(name);
	}
}
