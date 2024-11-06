public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> DList = new DoublyLinkedList<>();
        DList.addToEnd(5);
        DList.addToEnd(6);
        DList.addToEnd(3);
        DList.addToFront(7);
        DList.addToFront(9);
        try {
            DList.display();
            DList.bubbleSort();
            DList.display();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}