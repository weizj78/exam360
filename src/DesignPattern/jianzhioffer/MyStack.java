package DesignPattern.jianzhioffer;

import java.util.Stack;

public class MyStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {

        if(minStack.isEmpty()||minStack.peek()>=node ){
            minStack.push(node);
        }else minStack.push(minStack.peek());
        stack.push(node);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {

        return  stack.peek();
    }

    public int min() {
        return  minStack.peek();
    }
}
