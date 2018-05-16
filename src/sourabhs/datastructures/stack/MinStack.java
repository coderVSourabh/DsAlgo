package sourabhs.datastructures.stack;

import java.util.Stack;

public class MinStack {

	private int min = Integer.MAX_VALUE;
	private Stack<Integer> stack;
	public MinStack() { 
		stack = new Stack<>();
	}

	public void push(int x) {
		if(x <= min) {        
			stack.push(min);
			min=x;
		}
		stack.push(x);
	}

	public void pop() {
		if(stack.pop() == min) min=stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min;
	}


	private long min2;
	Stack<Long> stack2 = new Stack<>();

	public void push2(int x) {
		if (stack2.isEmpty()){
			stack2.push(0L);
			min2=x;
		}else{
			stack2.push(x-min2);//Could be negative if min value needs to change
			if (x<min2) min2=x;
		}
	}

	public void pop2() {
		if (stack2.isEmpty()) return;
		long pop=stack2.pop();
		if (pop<0)  min2=min2-pop;//If negative, increase the min value
	}

	public int top2() {
		long top=stack2.peek();
		if (top>0){
			return (int)(top+min2);
		}else{
			return (int)(min2);
		}
	}

	public int getMin2() {
		return (int)min2;
	}


	public static void main(String[] args) {
		MinStack stackA = new MinStack();
		stackA.push(-5);
		stackA.push(-8);
		stackA.push(2);
		System.out.println("Min: " + stackA.getMin() + " Top: " + stackA.top());
		stackA.pop();
		System.out.println("Min: " + stackA.getMin() + " Top: " + stackA.top());
		stackA.pop();
		System.out.println("Min: " + stackA.getMin() + " Top: " + stackA.top());
		stackA.pop();

		System.out.println("**********************************************");
		stackA = new MinStack();
		stackA.push2(-5);
		stackA.push2(-8);
		stackA.push2(2);
		System.out.println("Min: " + stackA.getMin2() + " Top: " + stackA.top2());
		stackA.pop2();
		System.out.println("Min: " + stackA.getMin2() + " Top: " + stackA.top2());
		stackA.pop2();
		System.out.println("Min: " + stackA.getMin2() + " Top: " + stackA.top2());
		stackA.pop2();
	}

}
