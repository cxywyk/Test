package com.poi.test;
public class English {

	public static void main(String[] args) {
		//��ȡ�ַ��������Ӣ��
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
