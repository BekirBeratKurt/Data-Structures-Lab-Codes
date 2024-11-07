public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!\n");
        CircularQueue<Integer> cq1 = new CircularQueue<>(Integer.class,8);
        cq1.enQueue(1);
        cq1.enQueue(3);
        cq1.enQueue(2);
        cq1.enQueue(5);
        cq1.enQueue(4);
        try {
            cq1.display();
            System.out.println();
            System.out.println("Boyut = "+cq1.count());
            System.out.println("Bulundu mu = "+search(cq1,4));
            cq1.display();
            System.out.println("\n");
            System.out.println(Polindrome("bekir"));
        }catch (Exception exc){
            System.out.println("Hataaaaaa");
            System.out.println(exc.getMessage());
        }
    }
    public static <T extends Comparable> boolean search(CircularQueue<T> q,T val) throws Exception {
        boolean found = false;
        T temp ;
        for (int i = 0; i < q.count(); i++) {
            temp = q.deQueue();
            q.enQueue(temp);
            if(temp.compareTo(val) == 0){
                found = true;
            }
        }
        return found;
    }

    public static boolean Polindrome(String s) throws Exception{
        GenericStack<Character> gs = new GenericStack<>(Character.class,s.length());
        CircularQueue<Character> cq = new CircularQueue<>(Character.class,s.length());
        for (int i = 0; i < s.length(); i++) {
            gs.push(s.charAt(i));
            cq.enQueue(s.charAt(i));
        }
        for (int j = 0; j < s.length() / 2; j++) {
            if(gs.pop() != cq.deQueue()){
                return false;
            }
        }
        return true;
    }
}