/**
 * 
 */
package com.abhishek.code;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abhishek
 *
 */
public class LongestSubstringKDistinctChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "abac";
		findLongestSubstringKDistinct(input, 2);
		String input1 = "aabbccefgg";
		findLongestSubstringKDistinct(input1, 3);

	}
	
	public static int findLongestSubstringKDistinct(String input, int k) {
		if(k==0 || input == null || input.isEmpty()) {
			return 0;
		}
		if(input.length() < k) {
			return input.length();
		}
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		int curr = 0;
		int start = 0;
		int maxLen = Integer.MIN_VALUE;
		int startIndex = 0;
		int endIndex = 0;
		while(curr < input.length()) {
			char ch = input.charAt(curr);
			if(!charMap.containsKey(ch)) {
				charMap.put(ch, 1);
			}else {
				charMap.put(ch, charMap.get(ch) + 1);
			}
			while(charMap.size() > k) {
				char startCh = input.charAt(start);
				if(charMap.get(startCh) == 1) {
					charMap.remove(startCh);
				}else {
					charMap.put(startCh, charMap.get(startCh) - 1);
				}
				start++;
			}
			if(charMap.size() == k) {
				if(maxLen < curr - start + 1) {
					maxLen = curr - start + 1;
					startIndex = start;
					endIndex = curr;
				}
			}
			curr++;
		}
		System.out.println("Max Len : "+maxLen);
		System.out.println("Longest Substring : "+input.substring(startIndex, endIndex + 1));
		return maxLen;
	}

}