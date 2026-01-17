package solvingProblemsOfArray;

public class NihirCollection {

    private Object[] elementData;

    private int elementCount;

    public NihirCollection() {
        elementData = new Object[10];
    }

    public int capacity() {
        return elementData.length;
    }

    public int size() {
        return elementCount;
    }

    private void increaseCapacity() {
        Object[] newElementData = new Object[elementCount * 2];

        if (elementCount >= 0) System.arraycopy(elementData, 0, newElementData, 0, elementCount);

        elementData = newElementData;
    }

    public void add(Object element) {
        if (size() == capacity()) {
            increaseCapacity();
        }
        elementData[elementCount] = element;
        elementCount++;
    }

    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    public int indexOf(Object object) {
        if (object == null) {
            for  (int i = 0; i < size(); i++) {
                if (elementData[i] == null) return i;
            }
        } else {
            for (int i = 0; i < elementCount; i++) {
                if (object.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object object) {
        if (object == null) {
            for  (int i = size()-1; i >=0; i--) {
                if (elementData[i] == null) return i;
            }
        } else {
            for (int i = size()-1; i >=0; i--) {
                if (object.equals(elementData[i])) return i;
            }
        }
        return -1;
    }

    public Object get(int index) {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException(index);
        return elementData[index];
    }

    public Object remove(int index) {
        Object element = get(index);

        for  (int j = index; j < elementCount-1; j++) {
            elementData[j] = elementData[j+1];
        }

        elementData[elementCount-1] = null;
        elementCount--;

        return element;
    }

    public boolean remove(Object object) {
        if (indexOf(object) < 0) {
            return false;
        }
        remove(indexOf(object));
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size() == 0) {
            return sb.toString();
        } else {
            sb.append("[");
            for (int i = 0; i < size(); i++) {
                sb.append(elementData[i]);
                if (i != size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        return sb.toString();
    }
}
