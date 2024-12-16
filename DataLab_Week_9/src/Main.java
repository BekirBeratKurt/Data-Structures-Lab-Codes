public class Main {
    public static void main(String[] args) {
        SeperateChaining<String> sc = new SeperateChaining<>(11);
        try {
            sc.insert(2, "a");
            sc.insert(3, "b");
            sc.insert(4, "c");
            sc.insert(5, "d");
            sc.insert(6, "e");
            sc.insert(13, "f");
            sc.insert(24, "g");
            sc.insert(14, "z");
        } catch (Exception e) {
            e.getMessage();
        }
        sc.display();
        System.out.println();
        sc.delete(25);
        sc.display();
    }
}