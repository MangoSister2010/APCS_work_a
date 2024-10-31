public class Rectangle
{
    
    private int x;
    private int y;
    
    public Rectangle(int xIn, int yIn)
    {
        x = xIn;
        y = yIn;
    }

    public int area()
    {
        return x*y;
    }

    public int perimeter()
    {
        return 2*(x + y);
        
    }
}