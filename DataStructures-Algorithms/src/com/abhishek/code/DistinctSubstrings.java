/**
 * 
 */
package com.abhishek.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Abhishek Nath
 * Find the distinct substrings of a given string
 */
public class DistinctSubstrings {

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Set<String> substrSet = new HashSet<String>();
		substrSet.add("");
		findDistinctSubstrings("ababa", 1, substrSet);
		substrSet.forEach(System.out::println);

	}
	
	private static void findDistinctSubstrings(String str, int j, Set<String> substrSet) {
		if(j==str.length()) {
			substrSet.add(str);
			//System.out.println(str);
			return;
		}
		for(int i=0;i<=str.length()-j;i++) {
			String substr = str.substring(i, i+j);
			substrSet.add(substr);
			//System.out.println(substr);
		}
		findDistinctSubstrings(str, j+1, substrSet);
	}

}
