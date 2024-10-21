public class StringTimes
{
    public static String StringTimes(String str, int n) 
    {
        String result = "";
        
        for (int i=0; i<n; i++) 
          {
            result = result + str;  // could use += here
          }
        
        return result;
    }
    
    public static void testStringTimes(String str, int n, String expected)
    {
        String result = StringTimes(str, n); 
        System.out.print("String: " + str + " times: " + n + " + expected: " + expected + " result: " + result);

        if (result.equals(expected))
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
        testStringTimes("Hi", 3, "HiHiHi");
        testStringTimes("Hi", 2, "HiHi");   // Expected "HiHi"
        testStringTimes("Hello", 0, "");
     }
    
}
    
    
    
    
    
   