public interface SimpleList {

    /**
     * Get the element at this index.
     * @param index the index of the element to get
     * @return the element found
     */
    Object get(int index);

    /**
     * Set the element at this index to the passed element.
     * @param index the index of the element to set
     * @param element the new element
     */
    void set(int index, Object element);

    /**
     * Add the element at the specified location in the list. 
     * @param index the index where the element is added
     * @param element the element added
     */
    void add(int index, Object element);

    /**
     * Remove and return the element at the specified location in the list.
     * @param index the index of the element to remove\
     * @return the removed element
     */
    Object remove(int index);

    /**
     * Return the number of elements in the list.
     * @return the size of the list
     */
    int size();

}