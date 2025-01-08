public class ArrayCollection {
    Object[] elementData;
    int size;

    public ArrayCollection(int size) {
        elementData = new Object[size];

    }

    public int size() {
        return size;
    }

    public void add(Object obj) {
        elementData[size] = obj;
        size++;
    }

    public boolean isEmtry() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(elementData[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String ans = "";
        for (int i = 0; i < size; i++) {
            ans += elementData[i];
            if (i < size - 1)
                ans += ",";

        }
        return ans;
    }
    public int search(Object obj) { // Task6
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }
    

    public void remove(Object obj) {
        int n = search(obj);
        if (n == -1) {
            System.out.print("no such object");
        } else {
            for (int i = n + 1; i < size; i++) {
                elementData[i - 1] = elementData[i];
            }
            size--;
            elementData[size] = null;
        }
    }

}
