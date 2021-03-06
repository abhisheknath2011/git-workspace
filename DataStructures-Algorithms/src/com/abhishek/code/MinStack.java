/**
 * 
 */
package com.abhishek.code;

import java.util.Stack;

/**
 * @author Abhishek Nath
 *
 */
public class MinStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(5);
		minStack.push(3);
		minStack.push(1);
		minStack.push(2);
		minStack.push(4);
		while(!minStack.isEmpty()) {
			System.out.println("Min Element : "+minStack.getMin());
			System.out.println("Element poped : "+minStack.pop());
		}
	}
	
	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	
	public MinStack() {
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int item) {
		stack.push(item);
		if(minStack.isEmpty()) {
			minStack.push(item);
		}else {
			if(item < minStack.peek()) {
				minStack.pop();
				minStack.push(item);
			}
		}
	}
	
	public int pop() {
		if(stack.isEmpty()) {
			return -1;
		}
		int item = stack.pop();
		if(!minStack.isEmpty()) {
			if(item==minStack.peek()) {
				minStack.pop();
			}
			if(!minStack.isEmpty()) {
				return item;
			}
		}
		if(stack.isEmpty()) {
			return item;
		}
		int minElem = Integer.MAX_VALUE; 
		while(!stack.isEmpty()) {
			int item1 = stack.pop();
			minStack.push(item1);
			if(minElem > item1) {
				minElem = item1;
			}
		}
		while(!minStack.isEmpty()) {
			stack.push(minStack.pop());
		}
		minStack.push(minElem);
		return item;
	}
	
	public int getMin() {
		return !minStack.isEmpty() ? minStack.peek() : -1;
	}
	
	public boolean isEmpty() {
		return minStack.isEmpty();
	}

}
