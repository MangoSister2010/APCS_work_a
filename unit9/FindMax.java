import java.util.ArrayList;
import java.util.List;

public class FindMax 
{
    public static void main(String[] args) 
    {
        testFindMax(new ArrayList<>(List.of(1.0, 2.1, 5.3)), 5.3);
        testFindMax(new ArrayList<>(List.of(0.0, -35.0, 90.1)), 90.1);
        testFindMax(new ArrayList<>(List.of(-10.5, -20.3, -1.0)), -1.0);
        testFindMax(new ArrayList<>(List.of(3.3, 3.3, 3.3)), 3.3);
    }

    public static double findMax(ArrayList<Double> values) 
    {
        double max = values.get(0);
        for (double value : values) 
        {
            if (value > max) 
            {
                max = value;
            }
        }
        return max;
    }

    public static void testFindMax(ArrayList<Double> values, double expected) 
    {
        double result = findMax(values);
        System.out.println("Input: " + values + " Expected: " + expected + " Result: " + result);
       
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
