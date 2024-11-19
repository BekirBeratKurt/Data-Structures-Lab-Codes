public class PriorityQueue<T extends Comparable> {
    private Node<T> head;
    private Node<T> tail;

    public PriorityQueue() {
        head = null;
        tail = null;
    }

    public void enQueue(T val) {
        Node<T> newNode = new Node<>(val);

        if (head == null) {
            head = tail = newNode;
        } else {
            Node iterator = head;

            if (val.compareTo(head.value) > 0) {
                newNode.next = head;
                head = newNode;
            } else {
                while (iterator.next != null && val.compareTo(iterator.next.value) < 0) {
                    iterator = iterator.next;
                }

                if (iterator.next == null) {
                    tail.next = newNode;
                    tail = newNode;
                } else {
                    newNode.next = iterator.next;
                    iterator.next = newNode;
                }
            }
        }
    }

    public T deQueue() throws Exception {
        T temp;

        if (head == null) {
            throw new Exception("Queue is empty");
        } else {
            temp = head.value;
            head = head.next;
        }

        return temp;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node<T> temp = head;

        while (temp.next != null) {
            System.out.print(temp.value);
            System.out.print(" --> ");
            temp = temp.next;
        }

        System.out.println(temp.value);
    }
}