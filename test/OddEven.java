public class OddEven
{
    public static void main(String[]args)
    {
        for(int i=1; i<=50; i++)
        {
            if(i%2==0)
            {
                System.out.println("Even");
            }
            else
            {
                System.out.println("Odd"); 
            }
        }
    }
}



public class OddEven 
{
    public static void main(String[] args) 
    {
        int evenCount = 0;
        int oddCount = 0;

        for (int i = 1; i <= 50; i++) 
        {
            if (i % 2 == 0) 
            {
                evenCount++; // count numbers of even there are by +1 every time there is an even number but it starts from 0 as it is defined above
            } else 
            {
                oddCount++;
            }
        }

        System.out.println("Even numbers count: " + evenCount);
        System.out.println("Odd numbers count: " + oddCount);
    }
}