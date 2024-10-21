public class Attention1 
{

    public static boolean Attention1(String intro) 
    {
        if(intro.length()<8)
        {
            return false;
        }
        
        String begin = intro.substring(0,8);
            if(begin.equals("Hey you!"))
            {
                return true; 
            }
            else 
            {
                return false; 
            }
    }
    public static void testAttention1(String intro, boolean expected) 
    {
        boolean result = Attention1(intro);
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
        testAttention1("Hi, I'm Claire", false);
        testAttention1("Hey you! Stop!", true);
        testAttention1("Bye.", false);
    }
}