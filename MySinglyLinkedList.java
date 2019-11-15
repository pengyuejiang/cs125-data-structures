/** An implementation of singly linked list that implements a simplified list interface. */
public class MySinglyLinkedList implements SimpleList {

    /** Private item used for internal storage. */
    private class Item {
        Object value;
        Item next;
        Item(Object value, Item next) {
            this.value = value;
            this.next = next;
        }
    }
    
    /** First item of the list. */
    private Item first;

    /** Storing the size of the list. */
    private int size;

    /** Empty constructor that creates an empty singly linked list. */
    public MySinglyLinkedList() {}

    /**
     * Create a list with an Object array.
     * @param input the object array
     */
    public MySinglyLinkedList(Object[] input) {
        this();
        // Return for null and empty array
        if (input == null || input.length == 0) return;
        // Set list size
        this.size = input.length;
        // Set the first element
        this.first = new Item(input[0], null);
        Item current = first;
        // Store each element in the array into the list
        for (int i = 1; i < input.length; i++) {
            current.next = new Item(input[i], null);
            current = current.next;
        }
    }

    /**
     * Auxiliary function to get the item at the given index.
     * Assuming index to be valid, because invalid index
     * is filtered in the function that calls this one.
     * @param index index of the Item 
     * @return the <code>Item</code> (not the element) at the given index
     */
    private Item getItem(int index) {
        // Return <code>null</code> for invalid index
        if (index < 0 || index >= size) return null;
        // Keep a variable to track the progress
        int count = 0;
        // Iterate through the list
        for (Item current = this.first; current != null; current = current.next) {
            // If found, return
            if (count == index) return current;
            count++;
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int index) {
        // Return <code>null</code> for invalid index
        if (index < 0 || index >= size) return null;
        // Return the value of the element at the given index
        return getItem(index).value;
    }

    /** {@inheritDoc} */
    @Override
    public void set(int index, Object element) {
        // Return for invalid index
        if (index < 0 || index >= size) return;
        getItem(index).value = element;
    }

    /** {@inheritDoc} */
    @Override
    public void add(int index, Object element) {
        // Return for invalid index
        if (index < 0 || index > size) return;
        if (index == 0) {
            // If add at the front
            this.first = new Item(element, this.first);
        } else if (index == size) {
            // If appending to the end
            getItem(size - 1).next = new Item(element, null);
        } else {
            // Other cases
            Item prev = getItem(index - 1);
            Item next = getItem(index);
            prev.next = new Item(element, next);
        }
        // Increase the size of the array
        this.size++;
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int index) {
        // Return <code>null</code> for invalid index
        if (index < 0 || index >= size) return null;
        if (index == 0) {
            Object toReturn = first.value;
            first = first.next;
            return toReturn;
        }
        Item current = getItem(index);
        Item prev = getItem(index - 1);
        Item next = getItem(index + 1);
        prev.next = next;
        // Decrease the size of the array
        this.size--;
        // Return the removed Item's value
        return current;
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return this.size;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (Item i = first; i != null; i = i.next) sb.append(i.value + ", ");
        sb.append("\b\b]");
        return sb.toString();
    }

}