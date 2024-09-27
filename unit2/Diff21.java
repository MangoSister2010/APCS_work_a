public class Diff21 
{
    public static int Diff21(int n) 
    {
        if (n > 21) 
        {
            return 2 * (n - 21); 
        } 
        
        else 
        {
            return 21 - n; 
        }
    }
    
    public static void testDiff21(int n, int expected)
    {
        int result = Diff21(n);
        System.out.println(" Number: " + n + " Expected: " + expected + " Result: " + result );
        
        if(result==expected)
        {
            System.out.println("Correct");
        }
        else
        {
            System.out.println("Incorrect"); 
        }
    }
    
    
    
    public static void main(String[] args) //test
    {
        testDiff21(19, 2);
        testDiff21(30, 18);
    }
}