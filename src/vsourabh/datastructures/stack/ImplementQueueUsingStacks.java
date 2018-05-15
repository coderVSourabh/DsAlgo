package vsourabh.datastructures.stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	public static void main(String[] args){
		MyQueue q = new MyQueue();
		q.push(0);q.push(2);q.push(4);
		q.push(6);q.push(8);q.push(10);
		System.out.println(q.peek());
		System.out.println(q.pop());
		System.out.println(q.empty());
		System.out.println(q.peek());
		System.out.println(q.pop());
	}
}
class MyQueue {

	Stack<Integer> input;
	Stack<Integer> output;
	
	/** Initialize your data structure here. */
	public MyQueue() {
		input = new Stack<>();
		output = new Stack<>();
	}
	/** Push element x to the back of queue. */
	public void push(int x) {
		input.push(x);
	}
	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		peek();
		return output.pop();
	}
	/** Get the front element. */
	public int peek() {
		if(output.empty())
			while(!input.empty())
				output.push(input.pop());
		return output.peek();
	}
	/** Returns whether the queue is empty. */
	public boolean empty() {
		return input.empty() && output.empty();
	}
}