package cursorObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/**
 * Iterator
 *
 * - Iterator is a cursor object
 * - It is part of Collections Framework (Java 1.2+)
 * - Used to retrieve and remove elements safely
 * - Works on both legacy and CSF collections
 *
 * Problems with Enumeration:
 * 1. Method names are lengthy
 * 2. Removal operation is not supported
 *
 * To overcome these, Iterator is introduced
 */
public class Test_02_Iterator {

    public static void main(String[] args) {

        /* =======================
         * Iterator on Vector
         * ======================= */
        Vector<Object> v1 = new Vector<>();
        v1.add("a");
        v1.add(5);
        v1.add("b");
        v1.add(6);
        v1.add("c");
        v1.add(7);

        Iterator<Object> itr = v1.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();


        /* =======================
         * Iterator on ArrayList
         * ======================= */
        ArrayList<Object> al = new ArrayList<>();
        al.add("a1");
        al.add(51);
        al.add("b1");
        al.add(61);
        al.add("c1");
        al.add(71);

        itr = al.iterator();

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();


        /* =======================
         * Iterator remove rules
         * ======================= */
        itr = al.iterator();

        // itr.remove();           // RE: IllegalStateException (next() not called)

        while (itr.hasNext()) {
            Object obj = itr.next();

            // remove only Integer objects
            if (obj instanceof Integer) {
                itr.remove();     // valid removal
            }
        }

        System.out.println(al); // Only String objects remain
    }
}
