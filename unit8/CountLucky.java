import java.util.ArrayList;
import java.util.List;

public class CountLucky 
{
    public static void main(String[] args) 
    {

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);   // not lucky
        numbers.add(7);   // lucky 
        numbers.add(13);  // not lucky 
        numbers.add(17);  // lucky 
        numbers.add(107); // lucky 
        numbers.add(200); // not lucky

        int luckyCount = countLucky(numbers);
        System.out.println("Number of lucky numbers: " + luckyCount);

        testCountLucky(new ArrayList<Integer>(), 0);                   
        testCountLucky(new ArrayList<>(List.of(1, 2, 3)), 0);            
        testCountLucky(new ArrayList<>(List.of(7, 13, 17)), 2);           
        testCountLucky(new ArrayList<>(List.of(107, 200)), 1);           
        testCountLucky(new ArrayList<>(List.of(49, 57, 777, 1234)), 3);  
    }

    public static int countLucky(ArrayList<Integer> nums) 
    {
        int count = 0;

        for (int i = 0; i < nums.size(); i++) 
        {
            int num = nums.get(i);  
            
            if (num % 7 == 0 || String.valueOf(num).endsWith("7")) 
            {
                count++;  
            }
        }

        return count;
    }

    public static void testCountLucky(ArrayList<Integer> nums, int expected) 
    {
        int result = countLucky(nums);
        
        System.out.println("Input: " + nums + " Expected: " + expected + " Result: " + result);
        
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
