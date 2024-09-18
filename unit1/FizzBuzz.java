public class FizzBuzz {
    public static void main(String[] args) {
        
        
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz"); // Multiple of both 3 and 5
            } else if (i % 3 == 0) {
                System.out.println("Fizz"); // Multiple of 3
            } else if (i % 5 == 0) {
                System.out.println("Buzz"); // Multiple of 5
            } else {
                System.out.println(i); 
                
                
            }
        }
    }
}