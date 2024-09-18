public class Fibonacci {
    public static void main(String[] args) {

        int a = 1; 
        int b = 1; 

        System.out.println(a);
       
        }

        
        for (int i = 2; i < 30; i++) {
            int c = a + b; 
            System.out.println(c); 
            
            a = b; 
            b = c; 
        }
    }

