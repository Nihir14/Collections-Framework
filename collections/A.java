package collections;

/**
 * A is a simple data class used to demonstrate
 * how {@code hashCode()} and {@code equals()} work
 * internally in hash-based collections such as
 * {@link java.util.HashSet} and {@link java.util.HashMap}.
 *
 * <p>
 * This class intentionally prints messages inside
 * {@code hashCode()} and {@code equals()} to show:
 * <ul>
 *   <li>When hashCode() is called</li>
 *   <li>When equals() is called</li>
 *   <li>How duplicate detection happens</li>
 * </ul>
 * </p>
 *
 * <p>
 * Two objects of this class are considered equal
 * if both {@code x} and {@code y} values are the same.
 * </p>
 *
 * <p>
 * ⚠️ Note: This implementation uses {@code x + y}
 * as hash code for demonstration purposes only.
 * In real applications, a better hash function
 * should be used to reduce collisions.
 * </p>
 *
 * @author Nihir
 */
public class A {

	/**
	 * First integer value.
	 */
	private int x;

	/**
	 * Second integer value.
	 */
	private int y;

	/**
	 * Constructs an A object with given x and y values.
	 *
	 * @param x first value
	 * @param y second value
	 */
	public A(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the value of x.
	 *
	 * @return x value
	 */
	public int getX() {
		return x;
	}

	/**
	 * Updates the value of x.
	 *
	 * @param x new value
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the value of y.
	 *
	 * @return y value
	 */
	public int getY() {
		return y;
	}

	/**
	 * Updates the value of y.
	 *
	 * @param y new value
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Generates a hash code for this object.
	 *
	 * <p>
	 * This method is called by hash-based collections
	 * to determine the bucket index.
	 * </p>
	 *
	 * <p>
	 * The console output helps track how many times
	 * this method is invoked.
	 * </p>
	 *
	 * @return hash code value
	 */
	@Override
	public int hashCode() {
		System.out.println("\nIn hc");
		return x + y;
	}

	/**
	 * Compares this object with another object for equality.
	 *
	 * <p>
	 * This method is invoked when:
	 * <ul>
	 *   <li>Two objects have the same hash code</li>
	 *   <li>HashSet/HashMap needs to check duplicates</li>
	 * </ul>
	 * </p>
	 *
	 * <p>
	 * The console output shows:
	 * <ul>
	 *   <li>The current object ({@code this})</li>
	 *   <li>The object being compared</li>
	 * </ul>
	 * </p>
	 *
	 * @param obj object to compare
	 * @return true if both x and y values are equal
	 */
	@Override
	public boolean equals(Object obj) {
		System.out.println("in eq");
		System.out.println(this + "   " + obj);

		if (obj instanceof A) {
			A a = (A) obj;
			return (this.x == a.x) &&
					(this.y == a.y);
		}

		return false;
	}

	/**
	 * Returns a string representation of this object.
	 *
	 * @return formatted string with x and y values
	 */
	@Override
	public String toString() {
		return "A(" + x + ", " + y + ")";
	}
}
