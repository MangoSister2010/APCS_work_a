public class ArrayInitialization
{
    public static void main(String[] args)
    {
        int[][] diagonalArray = new int[10][10];
        for (int i = 0; i<10; i++)
        {
            for(int j = 0; j<10; j++)
            {
                if (i ==j)
                {
                    diagonalArray[i][j] = 1;
                }
                else
                {
                    diagonalArray[i][j] = 0;
                }
            }
        }
        
        System.out.print("a) Diagonal array:");
        printIntArray(diagonalArray);
    
        String [][] stringArray = 
        {
            {"apple", "banana", "cherry"}, {"dog", "elephant", "fox"}
        };
        
        System.out.println("\nb) String array:");
        printStringArray(stringArray);
    
        double[][] doubleArray = new double[5][5];
        for(int i = 0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                doubleArray[i][j] = (i+1) * 10 + (j+1);
            }
        }
        
        System.out.println("\nc) Double array:");
        printDoubleArray(doubleArray);
    
        int[][] intArray = new int[6][5];
        for(int i = 0; i<6; i++)
        {
            for (int j = 0; j< 5; j++)
            {
                intArray[i][j] = i+1;
            }
        }
        
        System.out.println("\nd) Integer array:");
        printIntArray(intArray);
    }
    
    public static void printIntArray(int[][] arr)
    {
        for(int[] row : arr)
        {
            for(int value : row)
            {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    public static void printDoubleArray(double[][] arr)
    {
        for(double[] row:arr)
        {
            for(double value : row)
            {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    
    public static void printStringArray(String [][] arr)
    {
        for (String [] row : arr)
        {
            for(String value : row)
            {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}