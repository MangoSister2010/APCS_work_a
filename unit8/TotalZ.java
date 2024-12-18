import java.util.ArrayList;
import java.util.List;

public class TotalZ 
{
    public static void main(String[] args) 
    {
        testTotalZ(new ArrayList<>(List.of("Claire", "Olivia")), 0);       
        testTotalZ(new ArrayList<>(List.of("Zack", "zion", "Zara")), 12);      
        testTotalZ(new ArrayList<>(List.of("zebra", "Zone", "apple")), 9); 
        testTotalZ(new ArrayList<>(), 0);                                       
    }

    public static int totalZ(ArrayList<String> names) 
    {
        int totalLength = 0;

        for (int i = 0; i < names.size(); i++) 
        { 
            String name = names.get(i);
            if (name.startsWith("Z") || name.startsWith("z")) 
            {
                totalLength += name.length();
            }
        }

        return totalLength;
    }

    public static void testTotalZ(ArrayList<String> names, int expected) 
    {
        int result = totalZ(names);
        System.out.println("Input: " + names + " Expected: " + expected + " Result: " + result);

        if (result == expected) 
        {
            System.out.println("Correct!");
        }
        else 
        {
            System.out.println("Wrong.");
        }
    }
}
