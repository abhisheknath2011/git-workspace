/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek Nath
 *
 */
public class MaxSumSubset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {-7,3,4,-3,5,7,-6};
		//maxSumSubset(a);
		int b [] = {-2, -5, 6, -2, -3, 1, 5, -6};
		maxSumSubset(b);
		maxSum(b);
		
		int arr[] = {2, 3, 4, 5, 7};
		//maxSumSubset(arr);
	}

	private static void maxSumSubset(int a []) {
		int prevSum = a[0];
		int curr = 1;
		int start = 0;
		int currSum = a[0];
		int maxSum = 0;
		while(curr<a.length) {
			currSum +=a[curr];
			if(currSum > prevSum) {
				while(start < curr) {
					if(currSum - a[start] > currSum) {
						currSum = currSum - a[start];
						start++;
					}else {
						break;
					}
				}
				if(currSum > maxSum) {
					maxSum = currSum;
				}
			}else {
				//currSum -= a[curr];
				maxSum = prevSum;
				currSum = 0;
				prevSum = 0;
				start = curr + 1;
			}
			curr++;
		}
		int maxLen = curr - start + 1;
		System.out.println("Printing max sum :: "+maxSum);
		System.out.println("Printing subset :: ");
		for(int i=start; i<curr; i++) {
			System.out.print(" "+a[i]);
		}
	}
	
	public static void maxSum(int a []) {
		int currSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int i=0; i<a.length;i++) {
			currSum +=a[i];
			if(currSum > maxSum) {
				maxSum = currSum; 
			}
			if(currSum < 0) {
				currSum = 0;
			}
		}
		System.out.println("Max Sum : "+maxSum);
	}
}
