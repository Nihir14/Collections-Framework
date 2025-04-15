package stack;

import java.util.Stack;

public class PushAndPop {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack after pushing elements: " + stack);
        // Pop an element from the stack
        System.out.println("Popped element: " + stack.pop());
    }
}
