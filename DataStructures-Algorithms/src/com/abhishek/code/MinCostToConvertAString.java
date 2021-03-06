/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek Nath
 *
 */
public class MinCostToConvertAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String source = "abcef";
		String target = "xydef";
		
		int minCost = findMinCost(source, target, source.length() - 1, target.length() - 1);
		System.out.println("Min Cost : "+minCost);
		
		source = "abcef";
        target = "xyd";
        
        minCost = findMinCost(source, target, source.length() - 1, target.length() - 1);
		System.out.println("Min Cost : "+minCost);
	}
	
	public static int findMinCost(String source, String target, int i, int j) {
		if(i < 0) {
			return j+1;
		}
		if(j < 0) {
			return i+1;
		}
		if(source.charAt(i) == target.charAt(j)) {
			return findMinCost(source, target, i-1, j-1) + 0;
		}
		return findMin(findMinCost(source, target, i, j-1), 
				findMinCost(source, target, i-1, j),
				findMinCost(source, target, i-1, j-1)) + 1;
	}
	
	private static int findMin(int x, int y, int z) {
		if(x < y && x < y) {
			return x;
		}else if(y < x && y < z) {
			return y;
		}
		return z;
	}

}
