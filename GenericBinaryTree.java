public class GenericBinaryTree<E extends Comparable<E>> {

    /** Private node class to store data. */
    private class Node {
        Node left;
        Node right;
        E element;
        Node(E element) {
            this.element = element;
        }
    }

    /** Root node of the tree. */
    private Node root;

    /** Empty constructor to generate a new binary tree. */
    public GenericBinaryTree() {}

    /**
     * Return the size of the tree.
     * @return size of the tree
     */
    public int size() {
        return size(root);
    }

    /**
     * Inner method to return the size of a substree.
     * @param node the starting node of the subtree
     * @return the size of the subtree
     */
    private int size(Node node) {
        return node == null ? 0 : size(node.left) + size(node.right) + 1;
    }

    /**
     * Add a an element to a tree.
     * @param element the element to add
     */
    public void add(E element) {
        add(root, element);
    }

    /**
     * Private method to add nodes to a tree with order.
     * @param current current node
     * @param element element to add
     */
    private void add(Node current, E element) {
        // If the current node is null, set root to the element
        if (current == null) {
            root = new Node(element);
            return;
        }
        // If element to add is smaller than current element, go left
        // Else go right
        if (current.element.compareTo(element) >= 0) {
            if (current.left == null) {
                current.left = new Node(element);
            } else {
                add(current.left, element);
            }
        } else {
            if (current.right == null) {
                current.right = new Node(element);
            } else {
                add(current.right, element);
            }
        }
    }

    public boolean search(E element) {
        return search(root, element);
    }

    private boolean search(Node current, E element) {
        // Return false if the tree is empty
        if (current == null) {
            return false;
        }
        if (current.element.equals(element)) {
            return true;
        } else if (current.element.compareTo(element) >= 0) {
            return search(current.right, element);
        } else {
            return search(current.left, element);
        }
    }

}