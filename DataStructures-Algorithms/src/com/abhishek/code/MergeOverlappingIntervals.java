/**
 * 
 */
package com.abhishek.code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Abhishek Nath
 *
 */
public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(5,7));
		intervals.add(new Interval(6,8));
		System.out.println("Gven Intervals : "+intervals);
		mergeInterval(intervals);
		
		intervals = new ArrayList<Interval>();
		intervals.add(new Interval(6,8));
		intervals.add(new Interval(1,9));
		intervals.add(new Interval(2,4));
		intervals.add(new Interval(4,7));
		System.out.println("Given Intervals : "+intervals);
		mergeInterval(intervals);
	}
	
	static class Interval {
		protected int start;
		protected int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		public String toString() {
			return ""+start+","+end;
		}
	}
	
	public static void mergeInterval(List<Interval> intervals) {
		Comparator<Interval> comp = new Comparator<Interval>() {

			@Override
			public int compare(Interval i1, Interval i2) {
				if(i1.start!=i2.start) {
					return i1.start - i2.start;
				}else {
					return i1.end - i2.end;
				}
			}
			
		};
		intervals.sort(comp);
		System.out.println("Sorted Intervals : "+intervals);
		merge(intervals, 0);
		System.out.println("Merged Intervals : "+intervals);
	}
	
	public static void merge(List<Interval> intervals, int index) {
		if(intervals.size()==1)
			return;
		if(index > intervals.size()-2) 
			return;
		Interval i1 = intervals.get(index);
		Interval i2 = intervals.get(index+1);
		if(i1.end >= i2.start) {
			Interval interval = null;
			if(i1.end >= i2.end) {
				interval = new Interval(i1.start, i1.end);
			}else {
				interval = new Interval(i1.start, i2.end);
			}
			intervals.remove(index);
			intervals.remove(index);
			intervals.add(index, interval);
			merge(intervals, index);
		}else {
			merge(intervals, index+1);
		}
	}

}
