public class GoodDeal 
{
    public static boolean goodDeal(double originalPrice, double salePrice) 
     {
        return salePrice < 0.75 * originalPrice;
        
     }
    public static void testGoodDeal(double originalPrice, double salePrice, boolean expected) // test
     {
        boolean result = goodDeal(originalPrice, salePrice);
        
        System.out.println("Orignal Price: " + originalPrice + "  Sale Price: " + salePrice + "  Expected: " + expected + "  Result: " + result);
        
            if(result == expected)
            {
                System.out.println("Correct");
            }
            else 
            {
                System.out.println("Incorrect");
            }
     }
     public static void main(String[]args)
     {
       testGoodDeal(100,70, false);
       testGoodDeal(100,80, true);

     }
       
}