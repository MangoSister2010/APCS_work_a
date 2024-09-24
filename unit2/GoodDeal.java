public class GoodDeal 
{
    public static boolean GoodDeal(double originalPrice, double salePrice) 
    {
        if(salePrice < 0.75 * originalPrice)
        {
            return true;
        }
      
        else
        {
            return false;   
        }
       
    }

    public static void main(String[] args) // test
    {
       System.out.println(GoodDeal(100,70));
       System.out.println(GoodDeal(100,80));

    }
}