public class Fibonacci 
{

    public static void main(String[] args) 
    {
        int n = 10;  
        int[] fibTerms = genFibonacci(n);

        System.out.print("First " + n + " terms of Fibonacci: ");
        for (int term : fibTerms) 
        {
            System.out.print(term + " ");
        }
        System.out.println();

       
        testFibonacci(5, new int[]{0, 1, 1, 2, 3});
        testFibonacci(8, new int[]{0, 1, 1, 2, 3, 5, 8, 13});
    }

    public static int[] genFibonacci(int n) 
    {
        if (n <= 0) 
        {
            return new int[] {};  
        }
        
        int[] fib = new int[n];
        
        fib[0] = 0;  
        if (n > 1) 
        {
            fib[1] = 1; 
        }
        
        for (int i = 2; i < n; i++) 
        {
            fib[i] = fib[i - 1] + fib[i - 2];  
        }
        
        return fib;
    }

    
    public static void testFibonacci(int n, int[] expected) 
    {
        int[] result = genFibonacci(n);
        System.out.print("Input: " + n + " Expected: ");
        for (int a : expected) 
        {
            System.out.print(a + " ");
        }
        System.out.print(" Result: ");
        for (int a : result) 
        {
            System.out.print(a + " ");
        }
        System.out.println();
        if (java.util.Arrays.equals(result, expected)) 
        {
            System.out.println("Correct!");
        } 
        else 
        {
            System.out.println("Wrong.");
        }
    }
}
