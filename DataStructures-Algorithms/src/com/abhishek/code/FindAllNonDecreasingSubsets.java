/**
 * 
 */
package com.abhishek.code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Abhishek
 *
 */
public class FindAllNonDecreasingSubsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	public void findSubsets(int a []) {
		// TODO - To complete the implementation
		Map<Integer, List<Integer>> map = new LinkedHashMap<Integer, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(a[0]);
		map.put(a[0], list);
		int i = 1;
		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext()) {
				int key = iter.next();
		}
		
		if(!map.containsKey(a[i])) {
			List<Integer> list1 = new ArrayList<Integer>();
		}
		
	}

}
