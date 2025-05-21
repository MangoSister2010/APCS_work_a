public class TwoD
{
    public static void main(String[] args)
    {
        Rectangle[][] rectangles = 
        {
            {new Rectangle("Rect1", 3.0, 4.0), new Rectangle("Rect2", 5.0, 6.0)},
            {new Rectangle("Rect3", 7.0, 2.0), new Rectangle("Rect4", 4.5, 4.5)}  
        };
        
        System.out.println("average perimeter: " + averagePerimeter(rectangles));
        Rectangle largest = rectangleWithGreatestArea(rectangles);
        System.out.println("Rectange with greatest area: " + largest.getName() + "(Area: " + largest.area() + ")");
    }
    
    static class Rectangle
    {
        private String name;
        private double width;
        private double height;
        
        public Rectangle(String name, double width, double height)
        {
            this.name = name;
            this.width = width;
            this.height = height; 
        }
        
        public String getName()
        {
            return name;
        }
        
        public double getWidth()
        {
            return width;
        }
        public double getHeight()
        {
            return height;
        }
        public double perimeter()
        {
            return 2 * (width + height);
        }
        public double area()
        {
            return width * height;
        }
    }
    
    public static double averagePerimeter(Rectangle[][] arr)
    {
        double totalPerimeter = 0;
        int count = 0;
        
        for(Rectangle[] row : arr)
        {
            for(Rectangle rect: row )
            {
                totalPerimeter += rect.perimeter();
                count++;
            }
        }
        
        return count == 0 ? 0 : totalPerimeter / count; 
    }
    
    public static Rectangle rectangleWithGreatestArea(Rectangle [][] arr)
    {
        if (arr == null || arr.length == 0) return null; 
        
        Rectangle maxRect = arr[0][0];
        for(Rectangle[] row : arr)
        {
            for (Rectangle rect : row)
            {
                if(rect.area() > maxRect.area())
                {
                    maxRect = rect;
                }
            }
        }
        
        return maxRect;
    }
}