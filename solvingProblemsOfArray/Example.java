package solvingProblemsOfArray;

/**
 * Example is a simple data class used to test
 * object comparison and storage inside {@link NihirCollections}.
 *
 * <p>
 * It demonstrates how overriding {@code equals()} affects
 * methods like {@code contains()}, {@code indexOf()},
 * and {@code lastIndexOf()} in a custom collection.
 * </p>
 *
 * <p>
 * Two Example objects are considered equal if both
 * {@code x} and {@code y} values are the same.
 * </p>
 *
 * @author Nihir
 */
public class Example {

    /**
     * First integer value.
     */
    private int x;

    /**
     * Second integer value.
     */
    private int y;

    /**
     * Constructs an Example object with given values.
     *
     * @param x first value
     * @param y second value
     */
    public Example(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Compares this object with another for equality.
     *
     * @param o object to compare
     * @return true if both objects have same x and y values
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Example example = (Example) o;
        return x == example.x && y == example.y;
    }

    /**
     * Returns a string representation of this object.
     *
     * @return formatted string containing x and y values
     */
    @Override
    public String toString() {
        return "Example{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
