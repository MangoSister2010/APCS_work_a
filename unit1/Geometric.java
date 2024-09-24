public class Geometric 
{
    int term = 1;
    int ratio = 2;
    
    public static void main(String[] args) 
    { 
        for (int i = 1; i < 10; i++) 
        {
            System.out.println(term);
            term *= ratio;
        }
    }
}