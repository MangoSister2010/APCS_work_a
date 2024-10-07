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

    public static void main(String[] args) 
    {
        System.out.println(Vampire(5.0f, true)); // f is used for float or double
        System.out.println(Vampire(10.0f, false));
    }
}