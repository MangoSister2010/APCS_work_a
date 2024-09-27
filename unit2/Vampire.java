public class Vampire 
{
    public static boolean Vampire(float hour, boolean awake) 
    {
        if (awake && (hour < 6.0 || hour >= 22.0)) //awake = true
        {
            return true; 
        } 
        else if (!awake && (hour >= 6.0 && hour < 22.0)) //not awake = false
        {
            return true; 
        }
        return false; // Not a vampire 
    }

    public static void testVampire(float hour, boolean awake, boolean expected)
    {
        boolean result = Vampire(hour, awake);
        System.out.println("  Hour:  " + hour + "  Awake:  " + awake +  "  Expected:  " + expected + "  Results:  " + result);
        
        if(result==expected)
        {
            System.out.println("Correct");
        }
        else
        {
            System.out.println("Incorrect");
        }
    }
    
    
    
    
    
    public static void main(String[] args) //test
    {
        testVampire(5.0f, true, true); // f is used for float or double
        testVampire(10.0f, false, false);
    }
}