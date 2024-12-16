public class SumOfSquares 
{
    public static double sumOfSquares(double[] arr) 
    {
        double sum = 0; 
        for(int i = 0; i < arr.length; i++) 
        { 
            sum += arr[i] * arr[i]; 
        } 
        
        return sum; 
    }
    
    public static void testSumOfSquares(double[] arr, double expected) 
    {
        double result = sumOfSquares(arr);
            
        System.out.println(" Expected: " + expected + " Result: " + result); 
    
        if(result == expected) 
        {
            System.out.println("Correct!");
        }
        else 
        {
            System.out.println("Wrong.");
        }
    }
    
    public static void main(String[] args) 
    {
        testSumOfSquares(new double[]{0}, 0.0);
        testSumOfSquares(new double[]{1.0, 2.0, 3.0}, 14.0);
        testSumOfSquares(new double[]{2.0, 2.0, 2.0}, 12.0);
    }
}