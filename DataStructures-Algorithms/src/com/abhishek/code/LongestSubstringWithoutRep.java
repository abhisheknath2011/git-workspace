/**
 * 
 */
package com.abhishek.code;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Abhishek Nath
 * Find the longest substring without repetition 
 * in a given string
 */
public class LongestSubstringWithoutRep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abacadcde";
		int maxlen = findLongestSubstrWithoutRep(str);
		System.out.println("Input String : "+str);
		System.out.println("Length of the longest sub string without repetition : "+maxlen);
		
		str = "eabacadcdefa";
	    maxlen = findLongestSubstrWithoutRep(str);
	    System.out.println("Input String : "+str);
		System.out.println("Length of the longest sub string without repetition : "+maxlen);
	}
	
	private static int findLongestSubstrWithoutRep(String str) {
		Set<Character> set = new HashSet<Character>();
		int start = 0;
		int curr = 0;
		int maxLen = 0;
		while(start <= curr && curr < str.length()) {
			char ch = str.charAt(curr);
			if(!set.contains(ch)) {
				set.add(ch);
				if(curr - start + 1 > maxLen) {
					maxLen = curr - start + 1;
				}
				curr++;
			}else {
				set.remove(str.charAt(start));
				start++;
			}
		}
		return maxLen;
	}

}
