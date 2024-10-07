public class NearHundred 
{
    public static boolean NearHundred(int n) 
    {
        return (Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10); //math.abs is absolute value
    }

    public static void testNearHundred(int n, boolean expected) 
    {
        boolean result = NearHundred(n);
        System.out.println("Number: " + n + " Expected: " + expected + " Result: " + result);

        if (result == expected) 
        {
            System.out.println("Correct");
        } 
        else 
        {
            System.out.println("Incorrect");
        }
    }

    public static void main(String[] args) 
    {
        testNearHundred(90, true);
        testNearHundred(190, true);
        testNearHundred(50,false );
    }
}