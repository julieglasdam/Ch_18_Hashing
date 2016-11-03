import java.lang.reflect.Array;

/**
 * Created by Julie on 06-10-2016.
 */
public class HashIntSet {
    private int[] set;
    private int size;


    public HashIntSet() {
        this.set = new int[10];
        this.size = 0;
    }


    private void checkCapacity(int capacity) {
        if (capacity > set.length) {
            this.set = new int [size*2];
        }
    }

    private boolean containsValue(int value) {
        for (int i = 0; i < size; i++) {
            if (set[i] == value)
                return true;
        }
        return false;
    }

    private void removeIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        set[index] = 0;
    }

    private int hashing(int value) {
        return (Math.abs(value) % set.length);
    }

    private void checkIndex(int indexInput, int value) {
        int index = indexInput;
        boolean run = true;

        while (run) {
            if (set[index] == 0) {
                set[index] = value;
                run = false;
            }
            else {
                index = index+1;
            }
        }
    }

    public void add(int value) {
        if (!containsValue(value)) {
            checkCapacity(size + 1);
            checkIndex(hashing(value), value);
            size++;
        }
    }

    // ---- Ex1 ----
    public void addAll(HashIntSet newSet) {
        for (int i = 0; i < newSet.size+1; i++) {
            add(newSet.set[i]);
        }
    }

    // ---- Ex2 ----
    public boolean containsAll(HashIntSet newSet) {
        for (int i = 0; i < newSet.size; i++) {
            if (!containsValue(newSet.set[i])) {
                return false;
            }
        }
        return true;
    }

    // ---- Ex3 ----
    public boolean equals(HashIntSet newSet) {
        if (this.size == newSet.size) {
            for (int i = 0; i < newSet.size; i++) {
                if (!containsValue(newSet.set[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    // ---- Ex4 ----
    public void removeAll(HashIntSet newSet) {
        for (int i = 0; i < newSet.size; i++) {
            if (containsValue(newSet.set[i])) {
                removeIndex(set[i]);
            }
        }
    }

    // ---- Ex5 ----
    public void retainAll(HashIntSet newSet) {
        for (int i = 0; i < newSet.size; i++) {
            if (!containsValue(newSet.set[i])) {
                removeIndex(set[i]);
            }
        }
    }

    // ---- Ex6 ----
 /*   public Array toArray() {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            if (set[i] != 0) {

            }
        }

    } */


    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        else {


            String result = "";
            if (set[0] != 0) {
                 result = "[" + set[0];
            }
            else {
                result = "[";


            }
            for (int i = 1; i < set.length; i++) {
                if (set[i] != 0) {
                    result += ", " + set[i];
                }

            }
            result += "]";
            return result;
        }

    }
}
