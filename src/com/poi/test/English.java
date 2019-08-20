package com.poi.test;
public class English {

	public static void main(String[] args) {
		//提取字符串里面的英文
		String wowo ="123456tostring1234";
		String ss="";
		for (int i = 0; i < wowo.length(); i++) {
			if(wowo.charAt(i)>58)
			{
				ss+=wowo.charAt(i);
			}
		}
		System.out.println(ss.toUpperCase());
		
	}
}
