/**
 * 
 */
package com.abhishek.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Abhishek Nath
 *
 */
public class CommonCharactersInArrayOfStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<String>();
		arr.add("aghkafgklt");
		arr.add("dfghako");
		arr.add("qwemnaarkf");
		
		/*arr.add("abc");
		arr.add("cde");
		arr.add("ace");*/
		
		findCommonCharacters(arr);
		
		findCommonChars(arr);
	}
	
	public static void findCommonCharacters(List<String> arr) {
		Set<Character> tmp1 = new TreeSet<Character>();
		Set<Character> tmp2 = new TreeSet<Character>();
		
		//Place all chars from first string in tmp1
		for(char c: arr.get(0).toCharArray())
			tmp1.add(c);
		
		//Parse through all the strings.
		for(String s:arr){
			for(char c:s.toCharArray()){
				if(tmp1.contains(c))
					tmp2.add(c);
			}
			tmp1.clear();
			tmp1.addAll(tmp2);
			tmp2.clear();
		}
		System.out.println(tmp1.size()+" : "+tmp1);
	}
	
	public static void findCommonChars(List<String> arr) {
		int chars [] = new int [26]; 
		int commonChars [] = new int[26];
		
		//Parse through all the strings.
		for(String s:arr){
			chars = new int [26]; 
			for(int i=0;i<s.length();i++){
				int a = s.charAt(i) - 'a';
				chars[s.charAt(i) - 'a'] += 1;
				System.out.print("[ "+a+" : "+chars[a]+" ]");
			}
			System.out.println();
			for(int i=0;i<6;i++) {
				if(chars[i] > 0) {
					commonChars[i] = findMin(commonChars[i], chars[i]); 
				}else {
					commonChars[i] = -1;
				}
			}
			
		}
		System.out.println("Common Chars ");
		for(int i=0;i<6;i++) {
			if(commonChars[i] > 0) {
				System.out.println((char)('a' + i));
			}
		}
	}
	
	public static int findMin(int a, int b) {
		if(a==-1) {
			return -1;
		}
		if(a==0) {
			return b;
		}
		
		return a <= b ? b : -1; 
	}

}
