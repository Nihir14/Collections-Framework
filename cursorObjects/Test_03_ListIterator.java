package cursorObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
 * ============================================================
 * Iterator vs ListIterator
 * ============================================================
 *
 * Iterator:
 * ----------
 * - Forward only cursor
 * - Can retrieve elements from index 0 to size()-1
 * - Cannot move backward
 * - Can remove elements (safe removal)
 * - Available from Java 1.2
 *
 * Iterator<E> methods:
 * 1. boolean hasNext()
 * 2. E next()
 * 3. void remove()
 *
 *
 * ListIterator:
 * -------------
 * - Bidirectional cursor (forward + backward)
 * - Available only for List implementations
 * - Sub-interface of Iterator
 * - Available from Java 1.2
 *
 * Extra methods provided by ListIterator:
 * 1. boolean hasPrevious()
 * 2. E previous()
 * 3. void add(E e)
 * 4. void set(E e)
 *
 * Factory Method:
 * ---------------
 * - iterator()      -> Collection interface
 * - listIterator()  -> List interface
 */

public class Test_03_ListIterator {

    public static void main(String[] args) {

        ArrayList<Object> al = new ArrayList<>();

        al.add("a");
        al.add(5);
        al.add("b");
        al.add(6);
        al.add("c");
        al.add(7);

        System.out.println("Original List : " + al);
        System.out.println("--------------------------------");

        /* ===============================
         * Using Iterator (Forward Only)
         * =============================== */
        Iterator<Object> itr = al.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("--------------------------------");

        /* =====================================
         * Using ListIterator (Forward Direction)
         * ===================================== */
        ListIterator<Object> litr = al.listIterator();

        while (litr.hasNext()) {
            Object obj = litr.next();
            System.out.println(obj);
        }

        System.out.println("--------------------------------");

        /* =====================================
         * Using ListIterator (Backward Direction)
         * ===================================== */
        while (litr.hasPrevious()) {
            Object obj = litr.previous();
            System.out.println(obj);
        }

        System.out.println("--------------------------------");

        /* =====================================
         * add() and set() using ListIterator
         * ===================================== */
        litr = al.listIterator();

        while (litr.hasNext()) {
            Object obj = litr.next();

            if (obj instanceof String s) {
                // replaces current element
                litr.set(s.toUpperCase());
            }
            else if (obj instanceof Integer) {
                // inserts new element
                litr.add(20);
            }
        }

        System.out.println("After modification : " + al);
    }
}
