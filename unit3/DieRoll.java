public class DieRoll
{
    public static void main(String[]args) 
    {
        for (int i = 0; i < 1; i++)
        {
            int value = (int)(Math.random() * 6 + 1);
            System.out.print(value + " ");
        }
    }
}