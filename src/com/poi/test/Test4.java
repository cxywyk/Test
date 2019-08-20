package com.poi.test;

/**
 * 判断英语多还是数字多
 * @author thin
 *
 */
public class Test4 {
	public static void main(String[] args) {
		String   ooo="qweq4weqweqwe";
		int  number = 0,english=0;
		for (int i = 0; i < ooo.length(); i++) {
			if(ooo.charAt(i)<57)
				number++;
			else
				english++;
		}
		System.out.println("数字共有:"+number+"\nEnglish共有:"+english);
	}
}
