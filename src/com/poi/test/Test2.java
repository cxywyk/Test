package com.poi.test;

import java.util.*;

/**
 * ð������򵥷���
 * @author thin
 *
 */
public class Test2 {
	
	public static void main(String[] args) {
		int [] w ={4,9,6,8};
		int temp=0;				//��ʱ����
	 	for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w.length-i-1; j++) { //������-1����-1-i������,����-1-i����(��Ϊ�Ƚϴ�����) 
				if(w[j]<w[j+1])
				{
					temp=w[j+1];
					w[j+1]=w[j];
					w[j]=temp;
				}
			}
		}
		for (int i = 0; i < w.length; i++) {
			System.out.println(w[i]);
		}
	}
}

