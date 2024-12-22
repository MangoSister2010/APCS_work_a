public class Reverse 
{

    public static void main(String[] args) 
    {
        String[] words = {"hello", "world", "java"};
        String[] reversedWords = reverseAll(words);

        for (String word : reversedWords) 
        {
            System.out.println(word);
        }
        
        testReverse("hello", "olleh");
        testReverse("world", "dlrow");
        testReverse("java", "avaj");
        testReverse("example", "elpmaxe");
    }

    public static String reverse(String s) 
    {
        String reversed = "";  
        
        for (int i = s.length() - 1; i >= 0; i--) 
        {
        reversed += s.charAt(i);  
        }
        
        return reversed;
    }

    public static String[] reverseAll(String[] strings) 
    {
        String[] reversedArray = new String[strings.length];
        for (int i = 0; i < strings.length; i++) 
        {
            reversedArray[i] = reverse(strings[i]);
        }
        return reversedArray;
    }
    
    public static void testReverse(String input, String expected) 
    {
        String result = reverse(input);
        System.out.println("Input: " + input + " Expected: " + expected + " Result: " + result);
        if (result.equals(expected)) 
        {
            System.out.println("Correct!");
        } 
        else 
        {
            System.out.println("Wrong.");
        }
    }
}
