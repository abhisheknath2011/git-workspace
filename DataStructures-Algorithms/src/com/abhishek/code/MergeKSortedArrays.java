/**
 * 
 */
package com.abhishek.code;

import java.util.PriorityQueue;

/**
 * @author Abhishek Nath
 *
 */
public class MergeKSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
		MergeKSortedArrays mergeArray = new MergeKSortedArrays();
		mergeArray.merge(new int [][] {arr1, arr2, arr3});
	}
	
	public void merge(int arr [][]) {
		PriorityQueue<ArrayContainer> pq = new PriorityQueue<ArrayContainer>();
		int row = arr.length;
		int col = arr[0].length;
		int result [] = new int [row*col];
		int resIndex = 0;
		for(int i = 0; i < row; i++) {
			pq.add(new ArrayContainer(arr[i], 0));
		}
		while(!pq.isEmpty()) {
			ArrayContainer ac = pq.poll();
			result[resIndex++] = ac.a[ac.index];
			if(ac.index < col-1) {
				pq.add(new ArrayContainer(ac.a, ac.index + 1));
			}
		}
		for(int i=0; i<row*col; i++) {
			System.out.print(" "+result[i]);
		}
	}
    
	class ArrayContainer implements Comparable<ArrayContainer> {
		int a [];
		int index;
		public ArrayContainer(int a [], int index) {
			this.a = a;
			this.index = index;
		}
		@Override
		public int compareTo(ArrayContainer ac) {
			// TODO Auto-generated method stub
			return this.a[index] - ac.a[ac.index];
		}	
	}
}
