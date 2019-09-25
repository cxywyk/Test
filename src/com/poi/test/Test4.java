package com.poi.test;

/**
 * 测试类
 * @author thin
 *
 */
public class Test4 {
	public static void main(String[] args) {
		String ss ="C:/Users/thin/Desktop/桐和源周销售预估.xlsx";
		String name=ss.substring(ss.lastIndexOf("/")+1);
		System.out.println(name);
	}
}
