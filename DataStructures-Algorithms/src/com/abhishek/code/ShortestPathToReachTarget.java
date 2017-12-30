/**
 * 
 */
package com.abhishek.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author Abhishek
 *
 */
public class ShortestPathToReachTarget {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShortestPathToReachTarget path = new ShortestPathToReachTarget();
		Set<String> words = new HashSet<String>();
		words.add("POON");
		words.add("PLEE");
		words.add("SAME");
		words.add("POIE");
		words.add("PLEA");
		words.add("PLIE");
		words.add("POIN");
		String source = "TOON";
		String target = "PLEA";
		path.findShortestPath(words, source, target);
	}
	
	public boolean isAdjacent(String word1, String word2) {
		int count = 0;
		for(int i=0;i<word1.length(); i++) {
			if(word1.charAt(i)!=word2.charAt(i)) {
				count++;
			}
		}
		if(count == 1)
			return true;
		return false;
	}
	
	public void findShortestPath(Set<String> words, String source, String target) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(source);
		Set<String> visitedSet = new HashSet<String>();
		int len = 0;
		System.out.println("Start Word : "+source);
		while(!queue.isEmpty()) {
			String start = queue.poll();
			for(String word : words) {
				if(!visitedSet.contains(word) && isAdjacent(start, word)) {
					visitedSet.add(word);
					queue.add(word);
					System.out.println("Next Word : "+word);
					len++;
				}
			}
		}
		System.out.println("Path Length : "+len);
	}
}
