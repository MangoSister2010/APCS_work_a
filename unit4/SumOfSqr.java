public class SumOfSqr
{
    public static int SumOfSqr(int n) 
    {
        int sum = 0;
        for (int i = 1; i <= n; i++) 
        {
            sum += i * i;
        }
        return sum;
    }
     
    public static void testSumOfSqr(int n, int expected)
    {
        int result = SumOfSqr(n); 
        System.out.print("input " + n + " + expected: " + expected + " result: " + result);

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
        testSumOfSqr(1,1);
        testSumOfSqr(2,5);
        testSumOfSqr(3, 14);
     }
}