package com.poi.test;

import java.util.*;

/**
 * 冒泡排序简单方法
 * @author thin
 *
 */
public class Test2 {
	
	public static void main(String[] args) {
		int [] w ={4,9,6,8};
		int temp=0;				//临时变量
	 	for (int i = 0; i < w.length; i++) {
			for (int j = 0; j < w.length-i-1; j++) { //在这里-1或者-1-i都可以,但是-1-i更快(因为比较次数少) 
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

