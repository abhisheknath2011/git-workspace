/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek Nath 
 * Find longest palindromic subsequence
 */
public class LongestPalindromicSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "CAHNCGHHACD";
		String result = findLongestPalindromicSubsequence(input);
		System.out.println("Longest palidromic subsequence is :" + result);

		input = "ABDCECABDA";
		result = findLongestPalindromicSubsequence(input);
		System.out.println("Longest palidromic subsequence is :" + result);
	}

	private static String findLongestPalindromicSubsequence(String input) {
		return findLongestPalindromicSubsequence(input, 0, input.length() - 1);
	}

	private static String findLongestPalindromicSubsequence(String input, int left, int right) {
		if (left == right && input.charAt(left) == input.charAt(right)) {
			return String.valueOf(input.charAt(left));
		}

		if (left + 1 == right && input.charAt(left) == input.charAt(right)) {
			return input.charAt(left) + "" + input.charAt(right);
		}

		if (input.charAt(left) == input.charAt(right)) {
			return String.valueOf(input.charAt(left)) + findLongestPalindromicSubsequence(input, left + 1, right - 1)
					+ String.valueOf(input.charAt(right));
		} else {
			String subseq1 = findLongestPalindromicSubsequence(input, left + 1, right);
			String subseq2 = findLongestPalindromicSubsequence(input, left, right - 1);
			if (subseq1.length() > subseq2.length()) {
				return subseq1;
			}
			return subseq2;
		}
	}
}
