public class CountLucky 
{
    public static int countLucky(int[] nums) 
    {
        int count = 0;
        int i = 0;

         for (i=0; i< nums.length; i++) 
         {
             if (nums[i] % 7 == 0 || String.valueOf(nums[i]).endsWith("7")) 
             {
                 count++; // keeps track of amnt. of lucky numbers 
             }
         }

        return count;
    }


    public static void testCountLucky(int[] nums, int expected) 
    {
        int result = countLucky(nums);

        for(int i=0; i<nums.length; i++)
        {
         System.out.print(" Expected: " + expected + " Result: " + result + " ");
        }

        if (result == expected) 
        {
            System.out.println("Correct!");
        } else 
        {
            System.out.println("Wrong :( ");
        }
    }

    public static void main(String[] args) 
    {
        int[] values1 = {1, 2, 3};
        int[] values2 = {7, 13, 17};
        int[] values3 = {107, 207};
        int[] values4 = {}; 

        testCountLucky(values1, 0);
        testCountLucky(values2, 2);
        testCountLucky(values3, 2);
        testCountLucky(values4, 0); 
    }
}
