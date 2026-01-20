package collections;

/**
 * Sa represents a custom object that supports:
 * <ul>
 *   <li>Natural ordering (Comparable)</li>
 *   <li>Hash-based collections (hashCode)</li>
 *   <li>Equality comparison (equals)</li>
 * </ul>
 *
 * <p>
 * Natural ordering is defined based on {@code x} value
 * in ascending order.
 * </p>
 *
 * <p>
 * When stored in a TreeSet:
 * <ul>
 *   <li>compareTo() decides sorting</li>
 *   <li>compareTo() == 0 → duplicate element</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class Sa implements Comparable<Sa> {

    private int x;
    private int y;

    public Sa(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Natural ordering of Sa objects.
     *
     * <p>
     * This method is automatically used by TreeSet
     * when no Comparator is provided.
     * </p>
     *
     * @param s object to compare with
     * @return comparison result based on x
     */
    @Override
    public int compareTo(Sa s) {
        return this.x - s.x; // ascending order
    }

    /**
     * Equality based on both x and y values.
     *
     * <p>
     * Used by HashSet / HashMap, NOT by TreeSet.
     * </p>
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sa s = (Sa) o;
        return this.x == s.x && this.y == s.y;
    }

    /**
     * Hash code based on x and y.
     *
     * <p>
     * Required for hash-based collections.
     * </p>
     */
    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public String toString() {
        return "Sa{x=" + x + ", y=" + y + '}';
    }
}
