/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek
 *
 */
public class CommonElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		findCommonElements();

	}
	
	public static void findCommonElements() {
		int a [] = {3, 5, 6, 6, 9};
		int b [] = {1, 4, 5, 6, 6, 7, 7, 9};
		int c [] = {2, 2, 3, 5, 6 , 6, 8, 9};
		int i = 0;
		int j = 0;
		int k = 0;
		while(i <= a.length -1 && j <= b.length - 1 && k <= c.length - 1) {
			if(a[i] < b[j] && a[i] <= c[k]) {
					i++;
			}else if(b[j] < a[i] && b[j] <= c[k]) {
					j++;
			}else if(c[k] < a[i] && c[k] <= b[j]) {
					k++;
			}else if(a[i] == b[j] && a[i] == c[k]) {
				System.out.println(a[i]);
				i++;
				j++;
				k++;
			}
			
		}
	}

}