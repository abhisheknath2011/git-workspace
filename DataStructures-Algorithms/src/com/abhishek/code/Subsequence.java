/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek Nath
 * The program finds if the second string is subsequence of first string or not
 *
 */
public class Subsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "abcde";
		String str2 = "be";
		boolean retValue = isSubsequence(str1, str2);
		System.out.println("Is second string subsequence of frst : "+retValue);
		str1 = "abcde";
		str2 = "bex";
		retValue = isSubsequence(str1, str2);
		System.out.println("Is second string subsequence of frst : "+retValue);
		str1 = "abccde";
		str2 = "bcce";
		retValue = isSubsequence(str1, str2);
		System.out.println("Is second string subsequence of frst : "+retValue);
	}
	
	public static boolean isSubsequence(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		/* Main string length is less the second string length and hence, 
		 * return false
		 */
		if(len1 < len2) {
			return false;
		}
		// length is second string is zero and hence return true
		if(len1 >=0 && len2 == 0) {
			return true;
		}
		
				
		boolean retValue = false;
		/* character at last position in both the string is equal and so get the substring 
		 * from 0 to length - 1 and keep comparing till string length is zero. 
		 * 
		 */
		if(str1.charAt(len1-1) == str2.charAt(len2-1)) {
			retValue = true;
			return retValue && isSubsequence(str1.substring(0,len1-1), str2.substring(0, len2-1));
		}
		/* character at last position in both the string is not equal and so get the 
		 * substring from 0 to length -1 for the main string and invoke the method 
		 * recursively.  
		 */
		return isSubsequence(str1.substring(0,len1-1), str2.substring(0, len2));
	}

}
