import java.util.ArrayList;
import java.util.List;

public class SumOfSquares 
{
    public static void main(String[] args) 
    {
        testSumOfSquares(new ArrayList<>(List.of(0.0)), 0.0);                  
        testSumOfSquares(new ArrayList<>(List.of(1.0, 2.0, 3.0)), 14.0);      
        testSumOfSquares(new ArrayList<>(List.of(2.0, 2.0, 2.0)), 12.0);      
        testSumOfSquares(new ArrayList<>(List.of(1.5, 2.5, 3.5)), 20.75);    
    }

    public static double sumOfSquares(ArrayList<Double> nums) 
    {
        double sum = 0.0;

        for (int i = 0; i < nums.size(); i++) 
        {
            double num = nums.get(i);
            sum += num * num; 
        }

        return sum;
    }

    public static void testSumOfSquares(ArrayList<Double> nums, double expected) 
    {
        double result = sumOfSquares(nums);
        System.out.println(" Input: " + nums + " Expected: " + expected + " Result: " + result);

        if (result==expected) 
        { 
            System.out.println("Correct!");
        } 
        else 
        {
            System.out.println("Wrong.");
        }
    }
}
