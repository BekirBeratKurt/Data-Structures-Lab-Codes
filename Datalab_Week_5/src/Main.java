public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.enQueue(5);
        pq.enQueue(3);
        pq.enQueue(1);
        pq.enQueue(7);
        pq.enQueue(2);

        pq.display();

        pq.enQueue(5);
        pq.enQueue(7);

        try {
            pq.deQueue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        pq.display();

        System.out.println(pq.isEmpty());
    }
}