public class Geometric {
    public static void main(String[] args) {
        int term = 1;
        int ratio = 2;
        
        for (int i = 0; i < 10; i++) {
            System.out.println(term);
            term *= ratio;
        }
    }
}