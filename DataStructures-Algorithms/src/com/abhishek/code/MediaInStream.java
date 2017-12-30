/**
 * 
 */
package com.abhishek.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Abhishek
 *
 */
public class MediaInStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		MediaInStream mediaInStream = new MediaInStream();
		list.add(12);
		list.add(4);
		list.add(5);
		list.add(3);
		list.add(8);
		list.add(7);
		mediaInStream.findMedian(list);
	}
	
	public void findMedian(List<Integer> list) {
		PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i2  - i1;
			}
		});
		
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i1  - i2;
			}
		});
		double m1 = 0;
		double m2 = 0;
		double m = 0;
		boolean addToMaxPQ = true;
		for(int num : list) {
			if(maxPQ.isEmpty()) {
				maxPQ.add(num);
			}else if(minPQ.isEmpty()) {
				if(maxPQ.peek() > num) {
					minPQ.add(maxPQ.remove());
					maxPQ.add(num);
				}else {
					minPQ.add(num);
				}
			}else if(!maxPQ.isEmpty() && !minPQ.isEmpty()) {
				if(num <= maxPQ.peek()) {
					addToMaxPQ = true;
				}else if(num > maxPQ.peek() && num < minPQ.peek()) {
					addToMaxPQ = false;
				}else if(num >= minPQ.peek()) {
					addToMaxPQ = false;
				}
				
				if(addToMaxPQ){
					if(maxPQ.size() <= minPQ.size()) {
						maxPQ.add(num);
					}else {
						minPQ.add(maxPQ.poll());
						maxPQ.add(num);
					}
				}else {
					if(maxPQ.size() >= minPQ.size()) {
						minPQ.add(num);
					}else {
						maxPQ.add(minPQ.poll());
						minPQ.add(num);
					}
				}
			}
			
			if(!maxPQ.isEmpty()) {
				m1 = maxPQ.peek();
			}
			
			if(!minPQ.isEmpty()) {
				m2 = minPQ.peek();
			}
			if(maxPQ.size() == minPQ.size()) {
				m = (m1 + m2)/2;
			}else if(maxPQ.size() > minPQ.size()) {
				m = m1;
			}else {
				m = m2;
			}
			System.out.println("Added num : "+num+" new median : "+m);
		}
	}

}