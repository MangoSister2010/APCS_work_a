public class factorial
{
    public static int factorial(int n) {
        if (n == 0 || n == 1) 
        {
            return 1;
        }
        
        int result = 1; 
        
        for (int i = 2; i <= n; i++) 
        {
            result *= i; 
        }
        
        return result;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   public static void testFactorial(int n, int expected)
    {
        int result = factorial(n); 
        System.out.print("  input:  " + n + "  expected:  " + expected +          "  result:  " + result);

        if (result==expected)
        {
        System.out.print(" Correct! ");  
        }
        else 
        { 
        System.out.print(" Wrong. ");
        }
    }
    
     public static void main(String[] args) 
     {
        testFactorial(6, 720);
        testFactorial(7, 5040);
        testFactorial(10, 3628800);
     }
} 
    
    
    
    
    
    
