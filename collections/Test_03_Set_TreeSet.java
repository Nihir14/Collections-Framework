package collections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Test_03_Set_TreeSet demonstrates the working of
 * {@link java.util.TreeSet} with:
 *
 * <ul>
 *   <li>Wrapper classes</li>
 *   <li>Comparable objects</li>
 *   <li>Comparator (outer class)</li>
 *   <li>Anonymous class</li>
 *   <li>Lambda expressions</li>
 * </ul>
 *
 * <p>
 * TreeSet:
 * <ul>
 *   <li>Stores elements in sorted order</li>
 *   <li>Uses Red-Black Tree internally</li>
 *   <li>Does NOT use equals() or hashCode()</li>
 *   <li>Uses compareTo() or compare() ONLY</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class Test_03_Set_TreeSet {

    public static void main(String[] args) {

        /* ---------- NATURAL ORDERING ---------- */

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(4);
        ts.add(2);
        ts.add(3);
        System.out.println(ts); // ascending

        TreeSet<String> ts2 = new TreeSet<>();
        ts2.add("a");
        ts2.add("c");
        ts2.add("d");
        ts2.add("b");
        System.out.println(ts2);

        /* ---------- COMPARABLE OBJECT ---------- */

        TreeSet<Sa> ts3 = new TreeSet<>();
        ts3.add(new Sa(5, 6));
        ts3.add(new Sa(5, 6)); // duplicate (compareTo == 0)
        ts3.add(new Sa(3, 4));
        ts3.add(new Sa(4, 2));
        System.out.println(ts3);

        /* ---------- COMPARATOR (OUTER CLASS) ---------- */

        TreeSet<Sa> ts4 = new TreeSet<>(new SaXDescComparator());
        ts4.add(new Sa(5, 6));
        ts4.add(new Sa(5, 6));
        ts4.add(new Sa(3, 4));
        ts4.add(new Sa(4, 2));
        System.out.println(ts4);

        /* ---------- ANONYMOUS CLASS ---------- */

        TreeSet<Sa> ts5 = new TreeSet<>(new Comparator<Sa>() {
            @Override
            public int compare(Sa s1, Sa s2) {
                return s1.getY() - s2.getY();
            }
        });
        ts5.add(new Sa(5, 6));
        ts5.add(new Sa(5, 6));
        ts5.add(new Sa(3, 4));
        ts5.add(new Sa(4, 2));
        System.out.println(ts5);

        /* ---------- LAMBDA EXPRESSIONS ---------- */

        TreeSet<Sa> ts6 = new TreeSet<>((s1, s2) -> s2.getY() - s1.getY());
        ts6.add(new Sa(5, 6));
        ts6.add(new Sa(5, 6));
        ts6.add(new Sa(3, 4));
        ts6.add(new Sa(4, 2));
        System.out.println(ts6);

        TreeSet<String> ts7 = new TreeSet<>((s1, s2) -> s2.compareTo(s1));
        ts7.add("a");
        ts7.add("c");
        ts7.add("d");
        ts7.add("b");
        System.out.println(ts7);

        TreeSet<Integer> ts8 = new TreeSet<>((i1, i2) -> i2.compareTo(i1));
        ts8.add(1);
        ts8.add(4);
        ts8.add(2);
        ts8.add(3);
        System.out.println(ts8);

        /* ---------- NON-COMPARABLE CLASS WITH COMPARATOR ---------- */

        TreeSet<Ex> ts9 = new TreeSet<>((e1, e2) -> e1.getX() - e2.getX());
        ts9.add(new Ex(5, 6));
        ts9.add(new Ex(7, 9));
        ts9.add(new Ex(2, 5));
        System.out.println(ts9);

        TreeSet<Ex> ts10 = new TreeSet<>((e1, e2) -> e2.getX() - e1.getX());
        ts10.add(new Ex(5, 6));
        ts10.add(new Ex(7, 9));
        ts10.add(new Ex(2, 5));
        System.out.println(ts10);

        TreeSet<Ex> ts11 = new TreeSet<>((e1, e2) -> e1.getY() - e2.getY());
        ts11.add(new Ex(5, 6));
        ts11.add(new Ex(7, 9));
        ts11.add(new Ex(2, 5));
        System.out.println(ts11);

        TreeSet<Ex> ts12 = new TreeSet<>((e1, e2) -> e2.getY() - e1.getY());
        ts12.add(new Ex(5, 6));
        ts12.add(new Ex(7, 9));
        ts12.add(new Ex(2, 5));
        System.out.println(ts12);
    }
}
