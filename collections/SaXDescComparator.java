package collections;

import java.util.Comparator;

/**
 * SaXDescComparator is a custom Comparator implementation
 * used to sort {@link Sa} objects in descending order
 * based on the value of {@code x}.
 *
 * <p>
 * This comparator is used with {@link java.util.TreeSet}
 * when we want ordering different from the natural ordering
 * defined in {@link Sa#compareTo(Sa)}.
 * </p>
 *
 * <p>
 * Ordering logic:
 * <ul>
 *   <li>Positive value → s1 comes after s2</li>
 *   <li>Negative value → s1 comes before s2</li>
 *   <li>Zero → elements are considered duplicates</li>
 * </ul>
 * </p>
 *
 * <p>
 * NOTE:
 * TreeSet uses the comparison result to:
 * <ul>
 *   <li>Sort elements</li>
 *   <li>Detect duplicates (compare() == 0)</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class SaXDescComparator implements Comparator<Sa> {

    /**
     * Compares two Sa objects based on x value
     * in descending order.
     *
     * @param s1 first object
     * @param s2 second object
     * @return comparison result
     */
    @Override
    public int compare(Sa s1, Sa s2) {
        // Descending order of x
        return s2.getX() - s1.getX();
    }
}
