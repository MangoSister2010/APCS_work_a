public class Attention 
{

    public static boolean attention(String intro) 
    {
        return intro.startsWith("Hey you!"); 
    }

    public static void testAttention(String intro, boolean expected) 
    {
        boolean result = attention(intro);
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
        testAttention("Hi, I'm Claire", false);
        testAttention("Hey you! Stop!", true);
        testAttention("Bye.", false);
    }
}