package com.poi.test;

/**
 * СтаЮ
 * @author thin
 *
 */
public class Test3 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = i; j<5; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for (int i = 1; i < 5; i++) {
			for (int j = 0; j<i+1; j++) {
				System.out.print(" ");
			}
			for (int j =i+1; j<5*2-i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
