/** An implementation of array list that implements a simplified list interface. */
public class MyArrayList implements SimpleList {
    
    /** Private array used internally. */
    private Object[] array;

    /** Construct a list with an empty Object array. */
    public MyArrayList() {
        this.array = new Object[0];
    }

    /**
     * Construct an array list with an array.
     * @param input the array to be stored inside
     */
    public MyArrayList(Object[] input) {
        // In case the input is null, this is the backup plan
        this();
        if (array != null) {
            this.array = new Object[input.length];
            for (int i = 0; i < input.length; i++) {
                this.array[i] = input[i];
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int index) {
        // If the index is invalid, return null
        // Else return the element at the given index
        return index < 0 || index >= this.array.length ? null : this.array[index];
    }

    /** {@inheritDoc} */
    @Override
    public void set(int index, Object element) {
        // If the index is invalid, return
        if (index < 0 || index >= this.array.length) return;
        // Else set the element at the given index
        this.array[index] = element;
    }

    /** {@inheritDoc} */
    @Override
    public void add(int index, Object element) {
        // If the index is invalid, return
        if (index < 0 || index > this.array.length) return;
        // By adding element, the array increases its size by 1
        Object[] newArray = new Object[this.array.length + 1];
        // Copy values to the new array as well as add the given element
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                // Things before the index don't change
                newArray[i] = this.array[i];
            } else if (i == index) {
                // Put element at the given index
                newArray[i] = element;
            } else {
                // Things after index shift right by 1
                newArray[i] = this.array[i - 1];
            }
        }
        // Replace the inner array with the new array
        this.array = newArray;
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int index) {
        // If the index is invalid, return null
        if (index < 0 || index >= this.array.length) return null;
        // By removing element, the array decreases its size by 1
        Object[] newArray = new Object[this.array.length - 1];
        // Declare a variable to store the removed value
        Object removed = null;
        // Copy values to the new array as well as remove the element at the given index
        for (int i = 0; i < newArray.length; i++) {
            if (i < index) {
                // Things before the index don't change
                newArray[i] = this.array[i];
            } else {
                // Store the removed value if it is the given index
                if (i == index) removed = this.array[index];
                // For everything at the index or after, shift right by 1
                newArray[i] = this.array[i + 1];
            }
        }
        // Replace the inner array with the new array
        this.array = newArray;
        // Return the removed value
        return removed;
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return this.array.length;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        if (this.array == null || this.array.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        System.out.println(java.util.Arrays.toString(this.array));
        for (Object element : this.array) sb.append(element + ", ");
        sb.append("\b\b]");
        return sb.toString();
    }

}