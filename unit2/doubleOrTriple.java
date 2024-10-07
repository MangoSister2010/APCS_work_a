public class DoubleOrTriple
{
    public static int doubleOrTriple(int n)
    {
        if(n%2==0)
        {
            return n*2;
        }
        else 
        {
            return n*3;
        }
    }
    
    public static void testDoubleOrTriple(int n, int expected) //used void instead of int because does not need to return any value
    {
        int result = doubleOrTriple(n);
        System.out.println("Number:  " + n + "  Expected:  " + expected + "  Result:  " + result);
        
        if(result==expected)
        {
            System.out.println("Correct");
        }
        else
        {
            System.out.println("Incorrect");
        }
    }
    
    public static void main(String[]args)
    {
        testDoubleOrTriple(4, 8);
        testDoubleOrTriple(5, 15); 
        testDoubleOrTriple()
    }
}