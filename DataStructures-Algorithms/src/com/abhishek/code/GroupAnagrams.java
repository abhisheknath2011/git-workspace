/**
 * 
 */
package com.abhishek.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Abhishek
 *
 */
public class GroupAnagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs [] = {"cat", "dog", "tac", "god", "act"};
		GroupAnagrams groupAnagrams = new GroupAnagrams();
		groupAnagrams.groupAnagrams(strs);
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        String ns = new String(arr);
	        System.out.println(ns);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	 
	    result.addAll(map.values());
	    
	    System.out.println("Result : "+result);
	 
	    return result;
	}

}
