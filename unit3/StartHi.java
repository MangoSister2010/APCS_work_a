public class StartHi 
{

    public static boolean StartHi(String intro) 
    {
        return intro.startsWith("hi"); 
    }

    public static void testStartHi(String intro, boolean expected) 
    {
        boolean result = StartHi(intro);
        System.out.println("Input: " + intro + " Expected: " + expected + " Result: " + result);

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
        testStartHi("hi, I'm Claire", true);
        testStartHi("Hey you! Stop!", false);
        testStartHi("Bye.", false);
    }
}