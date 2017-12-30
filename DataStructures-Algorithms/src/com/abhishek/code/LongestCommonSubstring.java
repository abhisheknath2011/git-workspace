/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek
 *
 */
public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = "abcd";
		String b = "bcdef";
		findLongestCommSubstring(a, b);

	}
	
	public static void findLongestCommSubstring(String a, String b) {
		int m = a.length();
		int n = b.length();
		int dpTable [][] = new int[m+1][n+1];
		int max = 0;
		int row = 0;
		int col = 0;
		for(int i=0; i<m+1; i++) {
			dpTable[i][0] = 0;
		}
		for(int i=0; i<n+1; i++) {
			dpTable[0][i] = 0;
		}
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					if(i == 1 || j == 1) {
						dpTable[i][j] = 1;
					}else {
						dpTable[i][j] = dpTable[i-1][j-1] + 1;
					}
					if(max < dpTable[i][j]) {
						max = dpTable[i][j];
						row = i;
						col = j;
					}
				}
			}
		}
		System.out.println("Max Length : "+max);
		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				System.out.print(" "+dpTable[i][j]);
			}
			System.out.println("");
		}
		String commonStr = "";
		while(dpTable[row][col]!=0) {
			commonStr = a.charAt(row-1) + commonStr;
			row--;
			col--;
		}
		System.out.println("Common Str : "+commonStr);
	}

}