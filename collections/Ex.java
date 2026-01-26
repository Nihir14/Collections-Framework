package collections;

/**
 * Ex is a simple data class that does NOT implement Comparable.
 *
 * <p>
 * This means:
 * <ul>
 *   <li>It cannot be stored in TreeSet without a Comparator</li>
 *   <li>Ordering must be provided externally</li>
 * </ul>
 * </p>
 *
 * <p>
 * Used to demonstrate TreeSet behavior with:
 * <ul>
 *   <li>Lambda expressions</li>
 *   <li>Custom ordering logic</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class Ex {

    private int x;
    private int y;

    public Ex(int x, int y) {
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
     * Equality is based on x and y values.
     *
     * <p>
     * Not used by TreeSet for duplicate detection.
     * TreeSet only uses Comparator / Comparable.
     * </p>
     */
//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Ex e = (Ex) o;
//        return this.x == e.x && this.y == e.y;
//    }

//    @Override
//    public int hashCode() {
//        return x + y;
//    }

    @Override
    public String toString() {
        return "Ex{x=" + x + ", y=" + y + '}';
    }
}
