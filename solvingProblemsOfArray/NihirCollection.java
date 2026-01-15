package solvingProblemsOfArray;

import java.util.Arrays;

public class NihirCollection {
    private Object[] elementData;

    @Override
    public String toString() {
        return "NihirCollection{" +
                "elementData=" + Arrays.toString(elementData) +
                ", elementCount=" + elementCount +
                '}';
    }

    private int elementCount;

    public NihirCollection() {
        elementData = new Object[10];
    }

    public void add(Object element) {
        if (size() == capacity()) {
            increaseCapacity();
        }
        elementData[elementCount] = element;
        elementCount++;
    }

    private void increaseCapacity() {
        Object[] newElementData = new Object[elementCount * 2];

        if (elementCount >= 0) System.arraycopy(elementData, 0, newElementData, 0, elementCount);

        elementData = newElementData;
    }

    public int capacity() {
        return elementData.length;
    }

    public int size() {
        return elementCount;
    }
}
