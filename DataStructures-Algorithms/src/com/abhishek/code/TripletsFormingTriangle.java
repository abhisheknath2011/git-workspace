/**
 * 
 */
package com.abhishek.code;

import java.util.Arrays;

/**
 * @author Abhishek Nath
 * Print all combination of triplets that can for a triangle
 */
public class TripletsFormingTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 10, 5, 3, 4, 7, 1 };
		System.out.println("Printing triplets");
		findTripletsFormingTriangle(a);

		int b[] = { 4, 6, 3, 7 };
		System.out.println("Printing triplets");
		findTripletsFormingTriangle(b);
	}

	private static void findTripletsFormingTriangle(int a[]) {
		Arrays.sort(a);
		for (int i = a.length - 1; i >= 2; i--) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				if (a[left] + a[right] > a[i]) {
					if (a[left] + a[i] > a[right] && a[right] + a[i] > a[left]) {
						System.out.println(a[left] + " " + a[right] + " " + a[i]);
					}
				}
				left++;
			}
		}
	}

}
