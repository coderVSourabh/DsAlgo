package vsourabh.datastructures.stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	public static void main(String[] args) {
		MyStack obj = new MyStack();
		obj.push(12);
		int param_3 = obj.top();
		System.out.println(param_3);
		
		obj.push(10);
		param_3 = obj.top();
		System.out.println(param_3);
		
		int param_2 = obj.pop();
		System.out.println(param_2);
		
		param_2 = obj.pop();
		System.out.println(param_2);
		
		boolean param_4 = obj.empty();
		System.out.println(param_4);
	}

}
class MyStack {

	Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i = 1; i < queue.size(); i ++)
        	queue.add(queue.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}