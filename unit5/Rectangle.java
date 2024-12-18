public class Rectangle
{
    
    private int base;
    private int height;
    
    public Rectangle(int baseIn, int heightIn)
    {
        base = baseIn;
        height = heightIn;
    }
    
    public int area()
    {
        return base*height;
    }

    public int perimeter()
    {
        return 2*(base + height);
        
    }
    
    public double diagonal() 
    {
        return Math.sqrt(base * base + height * height);
    }
    
    //accessor 
    public int getBase()
    {
        return base; 
    }
    
    public int getHeight()
    {
        return height; 
    }
}