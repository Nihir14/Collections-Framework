package collections;

import java.util.Stack;

/**
 * Test_08_List_Vector_Stack demonstrates the working of
 * {@link java.util.Stack}, which is a legacy class.
 *
 * <p>
 * Stack represents a <b>LIFO (Last In First Out)</b> data structure.
 * </p>
 *
 * <p>
 * IMPORTANT:
 * Stack extends {@link java.util.Vector}, which means:
 * <ul>
 *   <li>It is synchronized (thread-safe)</li>
 *   <li>It is slower</li>
 *   <li>It is legacy and not recommended for new code</li>
 * </ul>
 * </p>
 *
 * <p>
 * Preferred modern alternative:
 * <b>Deque (ArrayDeque / LinkedList)</b>
 * </p>
 *
 * @author Nihir
 */
public class Test_08_List_Vector_Stack {

    public static void main(String[] args) {

        /* -------------------------------------------------
         * 1. CREATE STACK
         * ------------------------------------------------- */

        Stack<Object> stack = new Stack<>();

        System.out.println("==== INITIAL STATE ====");
        System.out.println("Empty : " + stack.isEmpty());
        System.out.println(stack);
        System.out.println();

        /* -------------------------------------------------
         * 2. PUSH OPERATION (INSERT)
         * ------------------------------------------------- */

        System.out.println("==== PUSH ====");

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push("a");
        stack.push(null); // allowed
        stack.push("a");  // duplicate allowed

        System.out.println("After push(): " + stack);
        System.out.println();

        /* -------------------------------------------------
         * 3. PEEK OPERATION (TOP ELEMENT)
         * ------------------------------------------------- */

        System.out.println("==== PEEK ====");
        System.out.println("Top element : " + stack.peek());
        System.out.println("Stack remains same : " + stack);
        System.out.println();

        /* -------------------------------------------------
         * 4. POP OPERATION (REMOVE TOP)
         * ------------------------------------------------- */

        System.out.println("==== POP ====");
        System.out.println("Popped : " + stack.pop());
        System.out.println("After pop(): " + stack);
        System.out.println();

        /* -------------------------------------------------
         * 5. SEARCH OPERATION
         * ------------------------------------------------- */

        System.out.println("==== SEARCH ====");
        System.out.println("Position of 20 : " + stack.search(20));
        System.out.println("Position of 100 : " + stack.search(100));
        System.out.println();

        /* -------------------------------------------------
         * 6. VECTOR METHODS AVAILABLE
         * ------------------------------------------------- */

        System.out.println("==== VECTOR METHODS ====");
        System.out.println("Size     : " + stack.size());
        System.out.println("Capacity : " + stack.capacity());
        System.out.println("Contains 'a' : " + stack.contains("a"));
        System.out.println();

        /* -------------------------------------------------
         * 7. ITERATION
         * ------------------------------------------------- */

        System.out.println("==== ITERATION ====");
        for (Object o : stack) {
            System.out.print(o + " | ");
        }
        System.out.println();

        /* -------------------------------------------------
         * 8. FINAL STATE
         * ------------------------------------------------- */

        System.out.println("\nFinal Stack: " + stack);
    }
}
