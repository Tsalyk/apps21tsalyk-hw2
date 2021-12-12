package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList {
    private Object[] array = new Object[1];
    private int n=0;
    private int capacity=1;

    public ImmutableArrayList(Object[] elements) {
        int size = elements.length;
        this.n = size;
        this.capacity = 2 * size;
        this.array = new Object[capacity];

        int i = 0;

        for (Object el : elements) {
            this.array[i] = el;
            i++;
        }
    }

    public ImmutableArrayList() {
    }

    private ImmutableList copy() {
        ImmutableList immutableList;
        try {
            immutableList = (ImmutableList) this.clone();
        } catch (CloneNotSupportedException error) {
            immutableList = new ImmutableArrayList();
        }

        return immutableList;
    }

    private void increaseSize() {
        Object[] newArray = new Object[2*capacity];

        int i = 0;

        for (Object el : array) {
            newArray[i] = el;
            i++;
        }

        capacity *= 2;
        array = newArray;
    }

    private void rightSlide(int index) {
        if (n+1 == capacity) {
            capacity += 1;
        }

        Object[] newArray = new Object[n+1];

        for (int i = 0; i < n; i++) {

            if (i >= index) {
                newArray[i+1] = array[i];
            } else {
                newArray[i] = array[i];
            }
        }

        array = newArray;
    }

    private void leftSlide(int index) {
        Object[] newArray = new Object[n];

        for (int i = 0; i < n; i++) {

            if (i >= index) {
                newArray[i] = array[i+1];
            } else {
                newArray[i] = array[i];
            }
        }

        array = newArray;
    }

    @Override
    public ImmutableList add(Object e) {
        ImmutableList immutableList = this.copy();

        if (n >= capacity) {
            this.increaseSize();
        }

        array[n] = e;
        n++;

        return immutableList;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        ImmutableList immutableList = this.copy();

        if (n >= capacity) {
            this.increaseSize();
        }

        if (index >= 0 & index < n) {
            this.rightSlide(index);
            array[index] = e;
            n++;
        }

        return immutableList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableList immutableList = this.copy();

        for (Object el : c) {
            this.add(c);
        }

        return immutableList;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        int i = index;

        ImmutableList immutableList = this.copy();

        for (Object el : c) {
            this.add(i, c);
            i++;
        }

        return immutableList;
    }

    @Override
    public Object get(int index) {
        if (index >= 0 & index < n) {
            return array[index];
        }

        return -1;
    }

    @Override
    public ImmutableList remove(int index) {
        ImmutableList immutableList = this.copy();

        if (index >= 0 & index < n) {
            this.leftSlide(index);
            n--;
        }

        return immutableList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList immutableList = this.copy();

        if (index >= 0 & index < n) {
            array[index] = e;
        }

        return immutableList;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < n; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public ImmutableList clear() {
        ImmutableList immutableList = this.copy();

        array = new Object[1];
        n = 0;
        capacity = 1;

        return immutableList;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[n];

        for (int i = 0; i < n; i++) {
            newArray[i] = array[i];
        }

        return newArray;
    }
}
