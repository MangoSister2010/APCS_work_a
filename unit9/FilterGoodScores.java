import java.util.ArrayList;
import java.util.List;

public class FilterGoodScores 
{
    public static void main(String[] args) 
    {
        ArrayList<Integer> scores1 = new ArrayList<>(List.of(85, 91, 78, 95, 88, 100));
        ArrayList<Integer> scores2 = new ArrayList<>(List.of(90, 5, 2));

        testFilterGoodScores(scores1, new ArrayList<>(List.of(91, 95, 100)));
        testFilterGoodScores(scores2, new ArrayList<>());
    }

    public static ArrayList<Integer> filterGoodScores(ArrayList<Integer> scores) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        for (int score : scores) 
        {
            if (score > 90) 
            {
                result.add(score);
            }
        }
        return result;
    }

    public static void testFilterGoodScores(ArrayList<Integer> scores, ArrayList<Integer> expected) 
    {
        ArrayList<Integer> result = filterGoodScores(scores);
        
        System.out.println("Input: " + scores + " Expected: " + expected + " Result: " + result);
        
        if (result.equals(expected)) 
        {
            System.out.println("Correct!");
        } 
        else 
        {
            System.out.println("Wrong.");
        }
    }
}