public class countOccurrences
{
    public static int CountOccurrences(String x, String y) 
    {
       int total = 0; 
        for (int i=0; i+y.length()<=x.length(); i++)
        {
            String sub = x.substring(i, i+y.length());
            if (sub.equals(y))
                total += 1; 
        }

        return total; 
    } 
    
    public static void testCountOccurrences(String x, String y, int expected)
    {
        int result = CountOccurrences(x,y); 
        System.out.print("String: " + x + " Check: " + y + " + expected: " + expected + " result: " + result);

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
        testCountOccurrences("Mississippi", "iss", 2);
        testCountOccurrences("banananana", "na", 4);
        testCountOccurrences("tutu", "tu", 2);
        testCountOccurrences("lulululala", "lu", 3);
        testCountOccurrences("fatty", "t", 2);
     }
}