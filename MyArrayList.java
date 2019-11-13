// WARNING: This code is not robust, it's just a minimal demo.
public class MyArrayList implements SimpleList {
    
    /** Private array used internally. */
    private Object[] arr;

    /** Construct a list with an empty Object array. */
    public MyArrayList() {
        this.arr = new Object[0];
    }

    /**
     * Construct a list with an array.
     * @param arr original array
     */
    public MyArrayList(Object[] arr) {
        if (arr != null) {
            this.arr = new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                this.arr[i] = arr[i];
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int index) {
        return this.arr[index];
    }

    /** {@inheritDoc} */
    @Override
    public void set(int index, Object element) {
        this.arr[index] = element;
    }

    /** {@inheritDoc} */
    @Override
    public void add(int index, Object element) {
        Object[] newArr = new Object[this.arr.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = this.arr[i];
            } else if (i == index) {
                newArr[i] = element;
            } else {
                newArr[i] = this.arr[i - 1];
            }
        }
        this.arr = newArr;
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int index) {
        Object[] newArr = new Object[this.arr.length - 1];
        Object toReturn = null;
        for (int i = 0; i < newArr.length; i++) {
            if (i == index) {
                toReturn = this.arr[index];
                newArr[i] = this.arr[i + 1];
            } else if (i > index) {
                newArr[i] = this.arr[i + 1];
            } else {
                newArr[i] = this.arr[i];
            }
        }
        this.arr = newArr;
        return toReturn;
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return this.arr.length;
    }

}