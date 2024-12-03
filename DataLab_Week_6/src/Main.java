public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst =new BinarySearchTree<>();
        try {
            bst.insert(30);
            bst.insert(20);
            bst.insert(10);
            bst.insert(25);
            bst.insert(50);
            bst.insert(40);
            bst.insert(45);
            bst.insert(37);
            bst.inorder();
            System.out.println("\n");
            bst.inorder();
            System.out.println("\n");
            bst.inorder();
            System.out.println("\n");
            System.out.println(bst.inorderSuccessor(20));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}