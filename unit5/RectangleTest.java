public class RectangleTest
{
    public static void main(String[] args)
    {
        Rectangle r = new Rectangle(5, 10);

        System.out.println("Base: " + r.getBase());
        System.out.println("Height: " + r.getHeight());
        System.out.println("Area: " + r.area());
        System.out.println("Perimeter: " + r.perimeter());
        System.out.println("Diagonal: " + r.diagonal());
    }
}