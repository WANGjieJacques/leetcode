package easy.minstack;

import java.util.LinkedList;

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private LinkedList<Integer> stack;
	private LinkedList<Integer> minStack;
	
	public MinStack() {
		this.stack = new LinkedList<>();
		this.minStack = new LinkedList<>();
	}
    public void push(int x) {
        stack.push(x);
        if (this.minStack.isEmpty()) {
        	this.minStack.push(x);
        } else {
        	int previousMin = minStack.peek();
        	if (previousMin < x) {
        		this.minStack.push(previousMin);
        	} else {
        		this.minStack.push(x);
        	}
        }
    }

    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }

    public int top() {
    	return this.stack.peek();
        
    }

    public int getMin() {
        return this.minStack.peek();
    }

}
