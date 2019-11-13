// WARNING: This code is not robust, it's just a minimal demo.
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

    /** Empty constructor that does nothing. */
    public MySinglyLinkedList() {}

    /**
     * Create a list with an Object array.
     * @param arr the object array
     */
    public MySinglyLinkedList(Object[] arr) {
        this.size = arr.length;
        Item current = new Item(arr[0], null);
        for (int i = 1; i < arr.length; i++) {
            current.next = new Item(arr[i], null);
            current = current.next;
        }
    }
    
    /**
     * Add an element to the front of the list.
     * @param element the element to add
     */
    public void addToFront(Object element) {
        this.first = new Item(element, this.first);
        this.size++;
    }

    private Item getItem(int index) {
        int count = 0;
        for (Item current = this.first; current != null; current = current.next) {
            if (count == index) {
                return current;
            }
            count++;
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int index) {
        return getItem(index).value;
    }

    /** {@inheritDoc} */
    @Override
    public void set(int index, Object element) {
        getItem(index).value = element;
    }

    /** {@inheritDoc} */
    @Override
    public void add(int index, Object element) {
        if (index == 0) {
            addToFront(element);
            return;
        }
        Item prev = getItem(index - 1);
        Item next = getItem(index);
        prev.next = new Item(element, next);
        this.size++;
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int index) {
        Item current = getItem(index);
        Item prev = getItem(index - 1);
        Item next = getItem(index + 1);
        prev.next = next;
        this.size--;
        return current;
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return this.size;
    }

}