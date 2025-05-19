import java.util.ArrayList;

public class ItemCalculator 
{
    public static void printItems(ArrayList<Item> items)
    {
        for(int i=0; i<items.size(); i++)
        {
            Item item = items.get(i);
            System.out.println(item.getName() + ": $" + item.getPrice());
        }
    }
    
    public static float averagePrice(ArrayList<Item> items)
    {
        if(items.size() == 0)
        {
            return 0;
        }
        
        float sum = 0;
        for(int i = 0; i<items.size(); i++)
        {
            Item item = items.get(i);
            sum = sum + item.getPrice();
        }
        return sum/items.size();
    }
    
    public static String mostExpensiveItem(ArrayList<Item> items)
    {
        if(items.size() == 0)
        {
            return null;
        }
        
        Item maxItem = items.get(0);
        for(int i = 1; i<items.size(); i++)
        {
            Item currentItem = items.get(i);
            if(currentItem.getPrice() > maxItem.getPrice())
            {
                maxItem = currentItem;
            }
        }
        
        return maxItem.getName();
    }
        
        public static void runTests()
        {
            ArrayList<Item> items = new ArrayList<Item>();
            items.add(new Item("Pencil", 1.5f));
            items.add(new Item("Notebook", 3.0f));           
            items.add(new Item("Backpack", 10.0f));
            
            float average = averagePrice(items);
            if(Math.abs(average - 4.83f) < 0.01f)
            {
                System.out.println("Average Price Test: Pass");
            }
            else
            {
                System.out.println("Average Price Test: Fail");
            }
            
            String mostExpensive = mostExpensiveItem(items);
            if(mostExpensive.equals("Backpack"))
            {
                System.out.println("Most Expensive Item Test: Pass");
            }
            else
            {
                System.out.println("Most Expensive Item Test: Fail");
            }
        }
    
    public static void main(String[] args)
    {
        runTests();
    }
}