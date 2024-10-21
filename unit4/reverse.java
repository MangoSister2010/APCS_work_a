public class reverse 
{
    public static String reverse(String str) 
    {
        String result = "";
        
        for(int i = str.length()-1; i>=0; i--)
        {
            result += str.substring(i, i+1);
        }
    
        return result; 
    }
    
public static void testReverse(String str, String expected)
    {
        String result = reverse(str); 
        System.out.print("  input:  " + str + "  expected:  " + expected +          "  result:  " + result);

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
        testReverse("", "");
        testReverse("eheh", "hehe");
        testReverse("12345", "54321");
        testReverse("abc", "cba");
     }
}
   
    
    
    
    
    
    
  