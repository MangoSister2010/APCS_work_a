public class ArrayComp
{
    public static void main(String[] args)
    {
        int [][] intArray = 
        {
            {3, 5, 7},
            {2, 9, 1},
            {6, 8, 4}
        };
        
        System.out.println("a) Smallest integer: " + smallestIntInArray(intArray));
        
        float[][] floatArray = 
        {
            {1.1f, 2.2f},
            {3.3f, 4.4f}
        };
        
        System.out.println("b) Sum of float array: " + sumOfFloatArray(floatArray));
        
        String[][] stringArray = 
        {
            {"Apple", "banana", "Avocado"}, 
            {"ant", "Bear", "apricot"}
        };
        
        System.out.println("c) Strings starting with 'A': " + countStringsStartingWithA(stringArray));
    }
    
    public static int smallestIntInArray(int[][] arr)
    {
        int smallest = arr[0][0];
        for(int[] row : arr)
        {
            for(int value: row)
            {
                if(value < smallest)
                {
                    smallest = value;
                }
            }
        }
        return smallest;
    }
    
    public static float sumOfFloatArray(float[][] arr)
    {
        float sum = 0;
        for(float[] row : arr)
        {
            for(float value : row)
            {
                sum += value;
            }
        }
        return sum;
    }
    
    public static int countStringsStartingWithA(String [][] arr)
    {
        int count = 0;
        for(String[] row : arr)
        {
            for(String value : row)
            {
                if(value != null && value.toUpperCase().startsWith("A"))
                {
                    count++;
                }
            }
        }
        
        return count;
    }
}