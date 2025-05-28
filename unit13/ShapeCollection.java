import java.util.ArrayList;

class Shape
{
    private String name; 
    private int numberOfSides;
    
    public Shape(String name, int numberOfSides)
    {
        this.name = name;
        this.numberOfSides = numberOfSides;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumberOfSides()
    {
        return numberOfSides;
    }
}

class ShapeCollection
{
    private ArrayList<Shape> shapes; 
    
    public ShapeCollection()
    {
        shapes = new ArrayList<>();
    }
    
    public void addShape(Shape shape)
    {
        shapes.add(shape);
    }
    
    public int numberOfSides(String shapeName)
    {
        for(Shape shape : shapes)
        {
            if(shape.getName().equalsIgnoreCase(shapeName))
            {
                return shape.getNumberOfSides();
            }
        }
        
        return -1;
    }
    
    public double averageNumberOfSides()
    {
        if(shapes.isEmpty()) return 0;
        int totalSides = 0;
        for(Shape shape : shapes)
        {
            totalSides += shape.getNumberOfSides();
        }
        
        return (double) totalSides / shapes.size();
    }
    
    public ArrayList<Shape> shapesWithEvenSides()
    {
        ArrayList<Shape> evenShapes = new ArrayList<>();
        for(Shape shape : shapes)
        {
            if (shape.getNumberOfSides() % 2 == 0)
            {
                evenShapes.add(shape);
            }
        }
        
        return evenShapes;
    }
    
    public static void main(String[] args)
    {
        ShapeCollection collection = new ShapeCollection();
        
        collection.addShape(new Shape("Triangle", 3));
        collection.addShape(new Shape("Square", 4));
        collection.addShape(new Shape("Pentagon", 5));
        collection.addShape(new Shape("Hexagon", 6));
        
        System.out.println("Sides of Square: " + collection.numberOfSides("square"));
        
        System.out.println("Average number of sides: " + collection.averageNumberOfSides());
        
        ArrayList<Shape> evenShapes = collection.shapesWithEvenSides();
        System.out.println("Shapes with even number of sides:");
        for(Shape shape: evenShapes)
        {
            System.out.println("-" + shape.getName() + ": " + shape.getNumberOfSides() + " sides");
        }
    }
}