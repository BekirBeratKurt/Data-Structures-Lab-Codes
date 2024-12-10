public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree();
        try {
            bst.insert(15);
            bst.insert(10);
            bst.insert(12);
            bst.inorder();
            System.out.println(bst.height());
            System.out.println(bst.balance());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}