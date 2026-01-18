package solvingProblemsOfArray;

/**
 * NihirMap is a custom implementation of a Map-like data structure
 * using parallel arrays for keys and values.
 *
 * <p>
 * This class is created for educational purposes to understand
 * how key-value mappings work internally.
 * </p>
 *
 * <p>
 * Duplicate keys are not allowed. If a key already exists,
 * its value will be replaced.
 * </p>
 *
 * @author Nihir
 */
public class NihirMap {

    /**
     * Array to store keys.
     */
    private Object[] keys;

    /**
     * Array to store values corresponding to keys.
     */
    private Object[] values;

    /**
     * Number of key-value pairs stored.
     */
    private int size;

    /**
     * Constructs an empty NihirMap with initial capacity 10.
     */
    public NihirMap() {
        keys = new Object[10];
        values = new Object[10];
        size = 0;
    }

    /**
     * Returns the number of key-value pairs in the map.
     *
     * @return map size
     */
    public int size() {
        return size;
    }

    /**
     * Returns the current capacity of the map.
     *
     * @return internal array capacity
     */
    public int capacity() {
        return keys.length;
    }

    /**
     * Checks whether the map is empty.
     *
     * @return true if map is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds a key-value pair to the map.
     * If the key already exists, its value is replaced.
     *
     * @param key   key to insert
     * @param value value associated with key
     */
    public void put(Object key, Object value) {

        int index = indexOfKey(key);

        // Replace value if key exists
        if (index >= 0) {
            values[index] = value;
            return;
        }

        // Grow capacity if required
        if (size == capacity()) {
            grow();
        }

        keys[size] = key;
        values[size] = value;
        size++;
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param key key to search
     * @return value if found, null otherwise
     */
    public Object get(Object key) {
        int index = indexOfKey(key);
        return index >= 0 ? values[index] : null;
    }

    /**
     * Removes a key-value pair from the map.
     *
     * @param key key to remove
     * @return removed value, or null if key not found
     */
    public Object remove(Object key) {

        int index = indexOfKey(key);
        if (index < 0) {
            return null;
        }

        Object removedValue = values[index];

        // Shift elements left
        for (int i = index; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }

        keys[size - 1] = null;
        values[size - 1] = null;
        size--;

        return removedValue;
    }

    /**
     * Checks whether the map contains a given key.
     *
     * @param key key to search
     * @return true if key exists
     */
    public boolean containsKey(Object key) {
        return indexOfKey(key) >= 0;
    }

    /**
     * Checks whether the map contains a given value.
     *
     * @param value value to search
     * @return true if value exists
     */
    public boolean containsValue(Object value) {

        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (values[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(values[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes all key-value pairs from the map.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            keys[i] = null;
            values[i] = null;
        }
        size = 0;
    }

    /**
     * Returns the index of the specified key.
     *
     * @param key key to search
     * @return index if found, -1 otherwise
     */
    private int indexOfKey(Object key) {

        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (key.equals(keys[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Doubles the capacity of internal arrays.
     */
    private void grow() {
        Object[] newKeys = new Object[capacity() * 2];
        Object[] newValues = new Object[capacity() * 2];

        System.arraycopy(keys, 0, newKeys, 0, size);
        System.arraycopy(values, 0, newValues, 0, size);

        keys = newKeys;
        values = newValues;
    }

    /**
     * Returns string representation of the map.
     *
     * @return formatted map string
     */
    @Override
    public String toString() {

        if (size == 0) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{\n");

        for (int i = 0; i < size; i++) {
            sb.append("  [")
                    .append(keys[i])
                    .append(" = ")
                    .append(values[i])
                    .append("]");

            if (i != size - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }

        sb.append("}");
        return sb.toString();
    }
}
