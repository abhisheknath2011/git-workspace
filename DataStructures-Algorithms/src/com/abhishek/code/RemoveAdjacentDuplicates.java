/**
 * 
 */
package com.abhishek.code;

/**
 * @author Abhishek Nath
 * Removes adjacent duplicates from the given string
 *
 */
public class RemoveAdjacentDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "abbbacccaddbceea";
		String output = removeAdjDuplicates(input);
		System.out.println("output : "+output);
	}
	
	public static String removeAdjDuplicates(String input) {
		StringBuilder builder = new StringBuilder();
		int index = 0;
		char ch;
		boolean skip=false;
		while(index < input.length()) {
			ch = input.charAt(index);
			if(builder.length()==0) {
				builder.append(ch);
				index++;
				continue;
			}
			if(ch == builder.charAt(builder.length()-1)) {
				skip=true;
			}else {
				if(skip) {
					builder.deleteCharAt(builder.length()-1);
					skip = false;
					index--;
				}else {
					builder.append(ch);
				}
			}
			index++;
		}
		return builder.toString();
	}
}
