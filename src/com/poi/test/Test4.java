package com.poi.test;

/**
 * �ж�Ӣ��໹�����ֶ�
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
		System.out.println("���ֹ���:"+number+"\nEnglish����:"+english);
	}
}
