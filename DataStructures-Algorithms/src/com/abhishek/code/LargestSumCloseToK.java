/**
 * 
 */
package com.abhishek.code;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Abhishek
 *
 */
public class LargestSumCloseToK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a [] = {2,3,1,2,4,7};
		int n = 8;
		getLargestSumCloseToK(a, n);
	}
	
	public static int getLargestSumCloseToK(int[] arr, int k){
	    int sum=0;
	    TreeSet<Integer> set = new TreeSet<Integer>();
	    int result=Integer.MIN_VALUE;
	    set.add(0);
	 
	    for(int i=0; i<arr.length; i++){
	        sum=sum+arr[i];
	 
	        Integer ceiling = set.ceiling(sum-k);
	        if(ceiling!=null){
	            result = Math.max(result, sum-ceiling);        
	        }
	 
	        set.add(sum);
	    }
	    System.out.println(" Result : "+result);
	    return result;
	}

}
