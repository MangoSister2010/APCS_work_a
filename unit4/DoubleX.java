public class DoubleX
{
    public static boolean DoubleX(String str) 
    {
        int i = str.indexOf("x");
        if (i == -1) 
        {
            return false;
        }

        if (i+1 >= str.length()) 
        {
            return false; 
        }
        
        return str.substring(i+1, i+2).equals("x");
    }
    
    public static void testDoubleX(String str, boolean expected)
    {
        boolean result = DoubleX(str); 
        System.out.print("String: " + str + " + expected: " + expected + " result: " + result);

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
        testDoubleX("cxxabc", true);
        testDoubleX("adsaxdx", false);  
        testDoubleX("abxxcdx", true);
     }
}