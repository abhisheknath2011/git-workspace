/**
 * 
 */
package com.abhishek.code;

import java.util.Arrays;

/**
 * @author Abhishek Nath
 * Given an array of positive and negative numbers. Return the sum of
 * three numbers in the array which is closest to a given sum.
 */
public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Input Array
		int a [] = {4, 6, -3, -1, 0, 5, 1};
		// Given sum
		int sum = 7;
		int result = closestSum(a, sum);
		System.out.println("Closest sum : "+result);
		
		// Input Array
		int a1 [] = {4, 6, 3, 1, 0, 5, 8};
		// 0 1 3 4 5 6 8
		// Given sum
		sum = 2;
		result = closestSum(a1, sum);
		System.out.println("Closest sum : "+result);
	}
	
	private static int closestSum(int [] a, int sum) {
		// sort the array
		Arrays.sort(a);
		int max = Integer.MAX_VALUE;
		int closest = -1;
		for(int k=0; k < a.length - 2; k++) {
			// left pointer
			int i = k+1;
			// right pointer
			int j = a.length - 1;
			while(i < j) {
				int res = a[k] + a[i] + a[j];
				int diff = sum - res;
				// diif > 0 increase left pointer
				if(diff > 0) {
					i++;
				}
				// diff < increase right pointer
				else if(diff < 0){
					j--;
				}else {
					// diff 0 sum is same is given sum
					return res;
				}
				// find the closet sum
				if(Math.abs(diff) < Math.abs(max)) {
					max = diff;
					closest = res;
				}
			}
		}
		return closest;
	}

}
