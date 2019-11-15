public class Test {
    public static void main(String[] args) {
        
        // MyArrayList Passed Simple Test
        MyArrayList list = new MyArrayList(new Object[4]);
        System.out.println(list.size());
        list.add(0, 12);
        System.out.println(list.size());
        System.out.println(list.toString());

        // MySinglyLinkedList Passed Simple Test
        MySinglyLinkedList singlyLinkedList = new MySinglyLinkedList();
        singlyLinkedList.add(0, 1234);
        System.out.println(singlyLinkedList);
        singlyLinkedList.remove(0);

        // GenericBinaryTree Passed Simple Test
        GenericBinaryTree<Integer> bitree = new GenericBinaryTree<>();
        System.out.println(bitree.size());
    }
}