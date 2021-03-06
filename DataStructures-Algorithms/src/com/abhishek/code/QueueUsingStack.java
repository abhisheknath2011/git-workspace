package com.abhishek.code;

import java.util.Stack;

public class QueueUsingStack {

	public static void main(String[] args) {
		QueueUsingStack queueUsingStack = new QueueUsingStack();
		queueUsingStack.enqueue(5);
		queueUsingStack.enqueue(3);
		queueUsingStack.enqueue(1);
		queueUsingStack.enqueue(2);
		queueUsingStack.enqueue(4);
		System.out.println("------------------------");
		while(!queueUsingStack.isEmpty()) {
			System.out.println("Element dequeued :: "+ queueUsingStack.dequeue());
		}
	}
	
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public QueueUsingStack() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	public void enqueue(int elem) {
		stack1.add(elem);
		System.out.println("Element enqueued :: "+elem);
	}
	
	public int dequeue() {
		if(!stack2.isEmpty()) {
			return stack2.pop();
		}else {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return !stack2.isEmpty() ? stack2.pop() : -1;
	}
	public boolean isEmpty() {
		return !stack1.isEmpty() ? false : stack2.isEmpty();
	}
}
