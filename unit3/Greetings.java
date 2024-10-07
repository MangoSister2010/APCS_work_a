public class Greetings 
{

    public static String greetings(String name) 
    {
        return "Hello, " + name + ", how are you?";
    }

    public static void testGreetings(String name, String expected) {
        String result = greetings(name);
        System.out.println("Input: " + name + " Expected: " + expected + " Result: " + result);

        if (result.equals(expected)) // result.equals is used for strings instead of ==
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
        testGreetings("Claire", "Hello, Claire, how are you?");
        testGreetings("Logan", "Hello, Logan, how are you?");
        testGreetings("Brian", "Hello, Brian, how are you?");
    }
}