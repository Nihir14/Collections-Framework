package solvingProblemsOfArray;

/**
 * NihirCollection is a custom dynamic array implementation
 * similar to {@link java.util.ArrayList}.
 *
 * <p>
 * It stores elements in an internal Object array and grows
 * dynamically when capacity is exceeded.
 * </p>
 *
 * <p>
 * This class is created for learning purposes to understand
 * how collections work internally.
 * </p>
 *
 * @author Nihir
 */
public class NihirCollection {

    /**
     * Internal array used to store elements.
     */
    private Object[] elementData;

    /**
     * Number of elements currently stored in the collection.
     */
    private int elementCount;

    /**
     * Constructs an empty collection with an initial capacity of 10.
     */
    public NihirCollection() {
        elementData = new Object[10];
    }

    /**
     * Returns the current capacity of the internal array.
     *
     * @return capacity of the collection
     */
    public int capacity() {
        return elementData.length;
    }

    /**
     * Returns the number of elements present in the collection.
     *
     * @return size of the collection
     */
    public int size() {
        return elementCount;
    }

    /**
     * Increases the capacity of the internal array
     * by doubling its current size.
     */
    private void increaseCapacity() {
        Object[] newElementData = new Object[elementCount * 2];

        if (elementCount >= 0) {
            System.arraycopy(elementData, 0, newElementData, 0, elementCount);
        }

        elementData = newElementData;
    }

    /**
     * Adds an element at the end of the collection.
     *
     * @param element element to be added
     */
    public void add(Object element) {
        if (size() == capacity()) {
            increaseCapacity();
        }
        elementData[elementCount] = element;
        elementCount++;
    }

    /**
     * Returns a string representation of the collection.
     *
     * @return string form of elements
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (size() == 0) {
            return sb.toString();
        }

        sb.append("[");
        for (int i = 0; i < size(); i++) {
            sb.append(elementData[i]);
            if (i != size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Checks whether the collection contains a given object.
     *
     * @param object object to search
     * @return true if object exists, false otherwise
     */
    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    /**
     * Returns the index of the first occurrence of the object.
     *
     * @param object object to find
     * @return index if found, -1 otherwise
     */
    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size(); i++) {
                if (elementData[i] == null) return i;
            }
        } else {
            for (int i = 0; i < elementCount; i++) {
                if (object.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the object.
     *
     * @param object object to find
     * @return last index if found, -1 otherwise
     */
    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size() - 1; i >= 0; i--) {
                if (elementData[i] == null) return i;
            }
        } else {
            for (int i = size() - 1; i >= 0; i--) {
                if (object.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index index of element
     * @return element at index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public Object get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index index of element to remove
     * @return removed element
     */
    public Object remove(int index) {
        Object element = get(index);

        for (int j = index; j < elementCount - 1; j++) {
            elementData[j] = elementData[j + 1];
        }

        elementData[elementCount - 1] = null;
        elementCount--;

        return element;
    }

    /**
     * Removes the first occurrence of the specified object.
     *
     * @param object object to remove
     * @return true if removed, false otherwise
     */
    public boolean remove(Object object) {
        int index = indexOf(object);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    /**
     * Inserts an element at the specified index.
     *
     * @param index index to insert element
     * @param element element to add
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public void add(int index, Object element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(index);
        }

        if (size() == capacity()) {
            increaseCapacity();
        }

        for (int i = elementCount; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

        elementData[index] = element;
        elementCount++;
    }

    /**
     * Replaces the element at the specified index.
     *
     * @param index index of element
     * @param element new element
     * @return old element
     */
    public Object set(int index, Object element) {
        checkIndex(index);
        Object oldValue = elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    /**
     * Validates index range.
     *
     * @param index index to validate
     * @throws IndexOutOfBoundsException if index is invalid
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(index);
        }
    }
}
