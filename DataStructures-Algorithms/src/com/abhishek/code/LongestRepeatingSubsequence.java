/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek
 *
 */
public class LongestRepeatingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "AABEBCDD";
		LongestRepeatingSubsequence subseq = new LongestRepeatingSubsequence();
		subseq.findLongestRepeatingSubseq(input);
	}
	
	public void findLongestRepeatingSubseq(String input) {
		int n = input.length();
		int dpTable [][] = new int[n+1][n+1];
		for(int i=0;i<=n;i++) {
			dpTable[0][i] = 0;
			dpTable[i][0] = 0;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i!=j && input.charAt(i-1)==input.charAt(j-1)) {
					dpTable[i][j] = dpTable[i-1][j-1] + 1;
				}else {
					dpTable[i][j] = max(dpTable[i][j-1], dpTable[i-1][j]);
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			System.out.println();
			for(int j=1;j<=n;j++) {
				System.out.print(dpTable[i][j]+" ");
			}
		}
		
		System.out.print("Max length : "+dpTable[n][n]);
	}
	
	public int max(int a, int b) {
		return a > b ? a : b;
	}

}
