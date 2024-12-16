public class TotalZ 
{
    public static int totalZ(String[] names) 
    {
        int totalLength = 0;
        for (int i = 0; i < names.length; i++) 
        {
            if (names[i].startsWith("z") || names[i].startsWith("Z")) 
            {
                totalLength += names[i].length();
            }
        }
        return totalLength;
    }

    public static void testTotalZ(String[] names, int expected) 
    {
        int result = totalZ(names);
        
        System.out.println(" Expected: " + expected + " Result: " + result);
        
        if (result == expected) 
        {
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong.");
        }
    }

    public static void main(String[] args) 
    {
        
        testTotalZ(new String[]{"Claire", "Olivia"}, 0);
        testTotalZ(new String[]{"Zack", "zion", "Zara"}, 12);
    }
}